import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AbstractControlOptions,
  FormBuilder,
  FormGroup,
  ValidationErrors,
  Validators,
  FormControl,
  FormsModule,
  ReactiveFormsModule
} from '@angular/forms';
import { Service } from '../../service/login.service';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
import { NgIf } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    RouterModule,
    NgIf,
    MatButtonModule,
    MatCardModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule
  ],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  hide = true;
  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: Service,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      nome: [null, [Validators.required]],
      email: [null, [Validators.required, Validators.email]],
      senha: [null, [
        Validators.required,
        Validators.pattern(/(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*#?&^_-]).{8,}/)
      ]],
      repetirSenha: [null, [Validators.required]]
    }, {
      validators: this.confirmarSenha('senha', 'repetirSenha')
    } as AbstractControlOptions);
  }

  get nome(): FormControl {
    return this.form.get('nome') as FormControl;
  }

  get email(): FormControl {
    return this.form.get('email') as FormControl;
  }

  get senha(): FormControl {
    return this.form.get('senha') as FormControl;
  }

  get repetirSenha(): FormControl {
    return this.form.get('repetirSenha') as FormControl;
  }

  onSubmit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      console.log('Formulário inválido');
      return;
    }

    const { nome, email, senha } = this.form.value;

    const payload = {
      nome,
      email,
      senha,
      login: email
    };

    this.service.post(payload, 'usuario/cadastrar').subscribe({
      next: () => this.router.navigate(['/home']),
      error: err => console.error('Erro no cadastro:', err)
    });
  }

  confirmarSenha(controlName: string, matchingControlName: string) {
    return (control: AbstractControl): ValidationErrors | null => {
      const group = control as FormGroup;
      const senha = group.controls[controlName];
      const repetirSenha = group.controls[matchingControlName];

      if (!senha || !repetirSenha) return null;

      return senha.value === repetirSenha.value
        ? null
        : { confirmarSenha: true };
    };
  }
}
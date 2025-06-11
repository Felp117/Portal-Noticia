import { ChangeDetectionStrategy, Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { FormControl, FormsModule, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { Service } from '../../service/login.service';
import { Login } from '../../models/login.models';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-auth',
  providers: [Service],
  imports: [MatButtonModule, MatIconModule, MatCardModule, MatFormFieldModule, MatInputModule, MatFormFieldModule, FormsModule, ReactiveFormsModule, NgIf, RouterModule],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']

})
export class AuthComponent {
  login = new FormControl(null, [Validators.required, Validators.email]);
  senha = new FormControl(null, [Validators.required]);
  hide = true;

  constructor(
    private service: Service,
    private router: Router
  ) {
  }

  getErrorMessage() {
    return this.login.hasError('required') ? 'Digite seu Email' :
      this.login.hasError('login') ? 'login invalido' :
        '';
  }

  acess() {

    let data: Login = {
      login: this.login.value,
      senha: this.senha.value
    }

    this.service.login(data).subscribe({
      next: (r) => {
        this.router.navigate(['/home'], { queryParams: { logged: true } })
      },
      error: (r) => {
        alert('Email ou senha invalido')
      }
    })
  }
}

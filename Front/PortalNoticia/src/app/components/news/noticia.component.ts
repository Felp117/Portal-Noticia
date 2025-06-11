import { Component } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { Noticia } from '../../models/noticia.models';
import { Categoria } from '../../models/categoria';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Service } from '../../service/login.service';

@Component({
  selector: 'app-noticia',
  providers: [Service],
  imports: [MatButtonModule, MatCardModule, MatFormFieldModule, MatInputModule, FormsModule, ReactiveFormsModule, RouterModule, CommonModule],
  templateUrl: './noticia.component.html',
  styleUrl: './noticia.component.scss'
})
export class NoticiaComponent {

  form: FormGroup;

  categorias: Categoria[] = [
    {id: 1, nome: 'Esporte'},
    {id: 2, nome: 'Politica'},
    {id: 3, nome: 'Entretenimento'},
    {id: 4, nome: 'Empregos'},
    {id: 5, nome: 'região'}
  ]

  constructor(
    private fb: FormBuilder,
    private service: Service,
  ) {
    this.form = this.fb.group({
      titulo: [null, [Validators.required,]],
      descricao: [null, [Validators.required]],
      dataPub: [null, [Validators.required, this.dateValidator]],
      categoria: [null, [Validators.required]]
    })
  }

  cadastrar() {
    let data: Noticia = {
    titulo: this.form.get('titulo').value,
    descricao: this.form.get('descricao').value,
    dataPub: this.form.get('dataPub').value,
    categoria: this.form.get('categoria').value
  }

    this.service.post(data, `noticia`).subscribe({
      next: (r) => {
        this.form.reset();

      },
      error: (r) => {
        alert('Preencha os campos corretamente!')
      }
    })
  }

  getErrorMessage() {
    this.form.hasError('data_pub') ? 'Data invalida' :
      '';
  }

  dateValidator(control: AbstractControl): { [key: string]: string } | null {

    const today = new Date().getTime();

    if (!(control && control.value)) {
      return null;
    }

    return control.value.getTime() > today
      ? { data_pub: 'Não use datas futuras!' }
      : null;
  }
}

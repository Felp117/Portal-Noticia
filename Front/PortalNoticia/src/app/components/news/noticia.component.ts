import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-noticia',
  imports: [MatButtonModule, MatCardModule, MatFormFieldModule, MatInputModule],
  templateUrl: './noticia.component.html',
  styleUrl: './noticia.component.scss'
})
export class NoticiaComponent {

}

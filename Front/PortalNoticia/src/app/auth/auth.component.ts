import { ChangeDetectionStrategy, Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { FormControl, FormsModule, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';


@Component({
  selector: 'app-auth',
  imports: [MatButtonModule, MatIconModule, MatCardModule, MatFormFieldModule, MatInputModule, MatFormFieldModule, FormsModule, ReactiveFormsModule, NgIf],
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.scss'
})
export class AuthComponent {
  email = new FormControl('', [Validators.required, Validators.email]);

  getErrorMessage() {
    return this.email.hasError('required') ? 'Digite seu Email' :
      this.email.hasError('email') ? 'Email invalido' :
        '';
  }
  hide = true;
}

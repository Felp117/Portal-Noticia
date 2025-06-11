import { Component, OnInit } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import { MatDividerModule } from '@angular/material/divider';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { ActivatedRoute, RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-template',
  imports: [MatToolbarModule, MatTabsModule, MatButtonModule, 
    MatDividerModule, MatIconModule, RouterOutlet, RouterLink, CommonModule],
  templateUrl: './template.component.html',
  styleUrl: './template.component.scss'
})
export class TemplateComponent implements OnInit{

    logged: boolean = false;

    constructor (private router: ActivatedRoute){

    }

  ngOnInit(): void {
      this.router.queryParams.subscribe((t) => {
        if(t['logged']) {
          this.logged = Boolean(JSON.parse(t['logged']))
        }
      });
  }


}

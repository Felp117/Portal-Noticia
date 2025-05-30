import { Routes } from '@angular/router';
import { TemplateComponent } from './template/template.component';
import { AuthComponent } from './auth/auth.component';
import { HomeComponent } from './home/home.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: '',
        component: TemplateComponent,
        children: [
            {
                path: 'home',
                component: HomeComponent
            }
        ]
    },
    {
        path: 'login',
        component: AuthComponent
    }
];

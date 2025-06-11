import { Routes } from '@angular/router';
import { TemplateComponent } from './template/template.component';
import { AuthComponent } from './components/auth/auth.component';
import { HomeComponent } from './components/home/home.component';
import { NoticiaComponent } from './components/news/noticia.component';
import { RegisterComponent } from './components/register/register.component';

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
            },
            {
                path: 'noticia',
                component: NoticiaComponent
            },
        ]
    },
    {
        path: 'login',
        component: AuthComponent
    },
    {
        path: 'cadastro',
        component: RegisterComponent
    },

];

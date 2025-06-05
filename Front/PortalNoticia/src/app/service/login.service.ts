import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, of } from "rxjs";
import { SimpleService } from "./simple.service";
import { Login } from "../models/login.models";

@Injectable({
    providedIn: 'root'
})
export class Service extends SimpleService {
   
    constructor (http: HttpClient) {
        super(http);
    }

    // teste (): Observable<any> {
    //     return this.get(`/teste`);
    // }

    // categories(): Observable<any> {

    //     let categories: Category[] = [
    //         { id: 1, descricao: 'Geral' },
    //         { id: 2, descricao: 'Esportes' },
    //         { id: 3, descricao: 'Empregos' }
    //     ]

    //     let result: Result<Category[]> = {
    //         result: categories
    //     }

    //     return of(result);
    //     //return this.get(`/category`);
    // }

    login(data: Login): Observable<any> {
        return this.post(data, `login`);
    }
}


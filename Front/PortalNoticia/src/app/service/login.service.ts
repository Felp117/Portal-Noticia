import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, of, tap } from "rxjs";
import { SimpleService } from "./simple.service";
import { Login } from "../models/login.models";
import { LoginResponse } from "../components/types/login.response.type";

@Injectable({
    providedIn: 'root'
})
export class Service extends SimpleService {

    constructor(http: HttpClient) {
        super(http);
    }

    login(data: Login): Observable<any> {
        return this.http.post<LoginResponse>(`login`, data).pipe(tap((value) => {
            sessionStorage.setItem("auth-token", value.token)
            sessionStorage.setItem("nome", value.nome)
        }))
    }
}


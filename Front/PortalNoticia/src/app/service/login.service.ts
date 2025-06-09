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

    login(data: Login): Observable<any> {
        return this.post(data, `login`);
    }
}


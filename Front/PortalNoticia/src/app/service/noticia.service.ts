import { Injectable } from "@angular/core";
import { SimpleService } from "./simple.service";
import { HttpClient } from "@angular/common/http";
import { noticia } from "../models/noticia.models";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class Service extends SimpleService {

    constructor(http: HttpClient) {
        super(http);
    }

    cadastro(data: noticia): Observable<any> {
        return this.post(data, `noticia`)
    }

}
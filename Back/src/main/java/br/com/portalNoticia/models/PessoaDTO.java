package br.com.portalNoticia.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.beans.ConstructorProperties;

@AllArgsConstructor
@Data
public class PessoaDTO {

    private String nome;
    private String email;
}

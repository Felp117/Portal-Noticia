package br.com.portal.noticia.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {

    private String login;
    private String senha;

}

package br.com.portalNoticia.dto;

import br.com.portalNoticia.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UsuarioDto implements Serializable {

    private Integer id;
    private String login;
    private String senha;
    private String nome;
    private String email;

    public UsuarioDto() {} // construtor vazio necessário para desserialização

    public UsuarioDto(Usuario usuario) {
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.nome = usuario.getPessoa().getNome();
        this.email = usuario.getPessoa().getEmail();
    }
}

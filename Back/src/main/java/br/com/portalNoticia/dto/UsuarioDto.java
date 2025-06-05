package br.com.portalNoticia.dto;

import br.com.portalNoticia.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UsuarioDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String login;
    private String senha;

    public UsuarioDto(Usuario usuario) {
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
    }

}

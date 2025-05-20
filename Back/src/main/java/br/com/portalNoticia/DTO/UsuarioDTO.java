package br.com.portalNoticia.DTO;

import br.com.portalNoticia.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UsuarioDTO {

    private String nome;
    private String email;
    private String login;

    public Usuario converter() {
        return new Usuario(nome, email, login);
    }
}

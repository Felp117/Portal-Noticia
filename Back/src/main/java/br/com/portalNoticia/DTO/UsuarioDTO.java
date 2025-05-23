package br.com.portalNoticia.DTO;

import br.com.portalNoticia.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String email;
    private String login;

}

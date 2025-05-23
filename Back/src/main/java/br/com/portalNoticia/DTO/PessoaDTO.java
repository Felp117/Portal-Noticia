package br.com.portalNoticia.DTO;

import br.com.portalNoticia.entity.Pessoa;
import br.com.portalNoticia.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class PessoaDTO {

    private String nome;
    private String email;

    public Pessoa converter(){
        return new Pessoa(nome, email);
    }
    public static PessoaDTO converterEntidade(Pessoa pessoa) {
        return new PessoaDTO(pessoa.getNome(), pessoa.getEmail());
    }

}


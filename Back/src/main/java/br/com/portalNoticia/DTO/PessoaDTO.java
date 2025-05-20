package br.com.portalNoticia.DTO;

import br.com.portalNoticia.entity.Pessoa;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PessoaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    public Pessoa converter() {
        return new Pessoa(nome, email);
    }
}

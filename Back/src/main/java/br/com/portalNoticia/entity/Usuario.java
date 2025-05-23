package br.com.portalNoticia.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Usuario extends Pessoa {

    private String login;
    private String senha;


}

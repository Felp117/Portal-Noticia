package br.com.portalNoticia.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Usuario extends Pessoa{

    private String login;
    private String senha;
}

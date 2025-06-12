package br.com.portal.noticia.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "UsuarioId")
    private Pessoa pessoa;
    private String login;
    private String senha;


}

package br.com.portalNoticia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
public class Autor {

    private String nome;
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String biografia;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "autorid")
    private Pessoa pessoa;

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private List<Noticia> noticias;

}

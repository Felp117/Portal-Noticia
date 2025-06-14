package br.com.portal.noticia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String biografia;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "pessoaId")
    private Pessoa pessoa;

    @OneToMany(mappedBy = "autor")
    @JsonIgnore
    private List<Noticia> noticias;

}

package br.com.portal.noticia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String conteudo;
    private Timestamp dataPublicacao;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;

}

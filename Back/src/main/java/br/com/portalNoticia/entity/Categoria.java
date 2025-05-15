package br.com.portalNoticia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    @OneToMany
    @JoinColumn(name = "listaCategoria")
    private List<Categoria> listaCategoria = new ArrayList<>();
}

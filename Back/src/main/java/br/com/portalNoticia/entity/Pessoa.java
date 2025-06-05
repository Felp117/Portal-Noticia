package br.com.portalNoticia.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;

    public Pessoa(){

    }
    @Builder
    public Pessoa(Integer id,String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

}

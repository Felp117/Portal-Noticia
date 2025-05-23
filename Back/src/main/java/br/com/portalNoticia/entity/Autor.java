package br.com.portalNoticia.entity;

import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@Data
public class Autor extends Pessoa {

    private String biografia;

}

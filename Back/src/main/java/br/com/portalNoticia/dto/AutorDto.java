package br.com.portalNoticia.dto;

import br.com.portalNoticia.entity.Autor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutorDto extends PessoaDto{

    private String biografia;

    public AutorDto(Autor autor) {
        super(autor);
        this.biografia = (autor.getBiografia());
    }
}

package br.com.portalNoticia.dto;

import br.com.portalNoticia.entity.Noticia;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.security.Timestamp;

@Data
public class NoticiaResumoDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;
    private Timestamp dataPublicacao;

    public NoticiaResumoDto(Noticia noticia) {
        this.id = noticia.getId();
        this.titulo = noticia.getTitulo();
        this.dataPublicacao = noticia.getDataPublicacao();
    }
}

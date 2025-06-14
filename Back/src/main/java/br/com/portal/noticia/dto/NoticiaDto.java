package br.com.portal.noticia.dto;

import br.com.portal.noticia.entity.Noticia;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@NoArgsConstructor
@Data
public class NoticiaDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String titulo;
    private String conteudo;
    private Timestamp dataPublicacao;
    private Integer categoriaId;
    private String categoriaNome;
    private Integer autorId;
    private String autorNome;

    public NoticiaDto(Noticia noticia) {
        this.id = noticia.getId();
        this.titulo = noticia.getTitulo();
        this.conteudo = noticia.getConteudo();
        this.dataPublicacao = noticia.getDataPublicacao();

        if(noticia.getCategoria() != null) {
            this.categoriaId = noticia.getCategoria().getId();
            this.categoriaNome = noticia.getCategoria().getDescricao();
        }
        if(noticia.getAutor() != null) {
            this.autorId = noticia.getAutor().getId();
            this.autorNome = noticia.getAutor().getPessoa().getNome();
        }
    }


}

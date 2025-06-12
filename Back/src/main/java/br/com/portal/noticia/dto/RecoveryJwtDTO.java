package br.com.portal.noticia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RecoveryJwtDTO {
    private String token;
}

package dev.EventClean.infrastructure.dtos;

import dev.EventClean.core.enums.TipoEvento;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;


public record EventoDTO (
        Long id,
        String nome,
        String descricao,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String identificador,
        TipoEvento tipoEvento,
        String localEvento,
        String organizador,
        Integer capacidade
) {

}

package dev.EventClean.core.entities;

import dev.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record Evento(
        Long id,
        String nome,
        String descricao,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String identificador,
        TipoEvento tipoEvento,
        String local,
        String organizador
) {}

package dev.EventClean.infrastructure.mappers;

import dev.EventClean.core.entities.Evento;
import dev.EventClean.infrastructure.dtos.EventoDTO;
import org.springframework.stereotype.Component;

@Component
public class EventoMapper {

    public Evento toEvento (EventoDTO dto) {
        return new Evento(
                dto.id(),
                dto.nome(),
                dto.descricao(),
                dto.dataInicio(),
                dto.dataFim(),
                dto.identificador(),
                dto.tipoEvento(),
                dto.capacidade(),
                dto.localEvento(),
                dto.organizador()
        );
    }

    public EventoDTO toEventoDTO (Evento evento) {
        return new EventoDTO(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.identificador(),
                evento.tipoEvento(),
                evento.localEvento(),
                evento.organizador(),
                evento.capacidade()
                );
    }


}

package dev.EventClean.infrastructure.mappers;

import dev.EventClean.core.entities.Evento;
import dev.EventClean.infrastructure.dtos.EventoDTO;
import dev.EventClean.infrastructure.persistence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventoEntity toEntity(Evento evento) {
        return new EventoEntity(
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

    public Evento toDomain(EventoEntity eventoEntity) {
        return new Evento(
                eventoEntity.getId(),
                eventoEntity.getNome(),
                eventoEntity.getDescricao(),
                eventoEntity.getDataInicio(),
                eventoEntity.getDataFim(),
                eventoEntity.getIdentificador(),
                eventoEntity.getTipoEvento(),
                eventoEntity.getCapacidade(),
                eventoEntity.getLocalEvento(),
                eventoEntity.getOrganizador()

        );
    }


}

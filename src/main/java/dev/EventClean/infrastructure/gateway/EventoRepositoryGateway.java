package dev.EventClean.infrastructure.gateway;

import dev.EventClean.core.entities.Evento;
import dev.EventClean.core.gateway.EventoGateway;
import dev.EventClean.infrastructure.exceptions.DuplicateEventException;
import dev.EventClean.infrastructure.exceptions.NotFoundEventException;
import dev.EventClean.infrastructure.mappers.EventoEntityMapper;
import dev.EventClean.infrastructure.persistence.EventoEntity;
import dev.EventClean.infrastructure.persistence.EventoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public class EventoRepositoryGateway implements EventoGateway {

    private final EventoRepository repository;
    private final EventoEntityMapper entityMapper;

    public EventoRepositoryGateway(EventoRepository repository, EventoEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Evento criarEvento(Evento evento) {
        if (this.existePorIdentificador(evento.identificador())){
            throw new DuplicateEventException
                    ("O identificador numero: " + evento.identificador() + " já está em uso.");
        }
        EventoEntity entity = entityMapper.toEntity(evento);
        EventoEntity novoEvento = repository.save(entity);
        return entityMapper.toDomain(novoEvento);
    }

    @Override
    public List<Evento> buscarEventos() {
        List<EventoEntity> eventos = repository.findAll();
        return eventos.stream()
               .map(entityMapper::toDomain)
               .toList();
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return repository.findAll().stream()
                .anyMatch(evento -> evento.getIdentificador().equalsIgnoreCase(identificador));
    }

    @Override
    public Optional<Evento> buscarPorIdentificador(String identificador) {
        return Optional.ofNullable(repository.findByIdentificador(identificador)
                .orElseThrow(
                        () -> new NotFoundEventException
                                ("Evento com identificador: " + identificador + " não encontrado")));
    }

}

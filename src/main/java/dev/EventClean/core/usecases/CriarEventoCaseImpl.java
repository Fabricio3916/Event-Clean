package dev.EventClean.core.usecases;

import dev.EventClean.core.entities.Evento;
import dev.EventClean.core.gateway.EventoGateway;
import dev.EventClean.infrastructure.exceptions.DuplicateEventException;

public class CriarEventoCaseImpl implements CriarEventoCase {

    private final EventoGateway eventoGateway;

    public CriarEventoCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public Evento execute(Evento evento) {
        if (eventoGateway.existePorIdentificador(evento.identificador())){
            throw new DuplicateEventException
                    ("O identificador numero: " + evento.identificador() + " já está em uso.");
        }
        return eventoGateway.criarEvento(evento);
    }

}

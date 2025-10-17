package dev.EventClean.core.usecases;

import dev.EventClean.core.entities.Evento;
import dev.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventosCaseImpl implements BuscarEventosCase {

    private final EventoGateway eventoGateway;

    public BuscarEventosCaseImpl(EventoGateway eventoGateway) {
        this.eventoGateway = eventoGateway;
    }

    @Override
    public List<Evento> execute() {
        return eventoGateway.buscarEventos();
    }
}

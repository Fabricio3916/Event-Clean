package dev.EventClean.core.usecases;

import dev.EventClean.core.entities.Evento;
import dev.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventosCaseImpl implements BuscarEventosCase {

    private final EventoGateway gateway;

    public BuscarEventosCaseImpl(EventoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Evento> execute() {
        return gateway.buscarEventos();
    }
}

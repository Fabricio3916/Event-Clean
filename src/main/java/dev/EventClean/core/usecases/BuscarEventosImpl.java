package dev.EventClean.core.usecases;

import dev.EventClean.core.entities.Evento;
import dev.EventClean.core.gateway.EventoGateway;

import java.util.List;

public class BuscarEventosImpl implements BuscarEventosCase {

    private final EventoGateway gateway;

    public BuscarEventosImpl(EventoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<Evento> execute() {
        return gateway.buscarEventos();
    }
}

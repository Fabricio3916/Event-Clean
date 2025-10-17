package dev.EventClean.core.usecases;

import dev.EventClean.core.entities.Evento;
import dev.EventClean.core.gateway.EventoGateway;
import dev.EventClean.infrastructure.exceptions.NotFoundEventException;

public class FiltroIdentificadorUsecaseImpl implements FiltroIdentificadorUsecase {

    private final EventoGateway gateway;

    public FiltroIdentificadorUsecaseImpl(EventoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Evento execute(String identificador) {
        return gateway.buscarPorIdentificador(identificador).orElse(null);

    }
}

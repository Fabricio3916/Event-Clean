package dev.EventClean.core.gateway;

import dev.EventClean.core.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoGateway {

    Evento criarEvento(Evento evento);

    List<Evento> buscarEventos();

    boolean existePorIdentificador(String identificador);

    Optional<Evento> buscarPorIdentificador(String identificador);
}

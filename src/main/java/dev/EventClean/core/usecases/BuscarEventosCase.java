package dev.EventClean.core.usecases;

import dev.EventClean.core.entities.Evento;

import java.util.List;

public interface BuscarEventosCase {

    public List<Evento> execute();

}

package dev.EventClean.core.usecases;

import dev.EventClean.core.entities.Evento;

public interface FiltroIdentificadorUsecase {

    public Evento execute(String identificador);

}

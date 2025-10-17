package dev.EventClean.infrastructure.persistence;

import dev.EventClean.core.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<EventoEntity, Long> {

    Optional<Evento> findByIdentificador(String identifier);

}

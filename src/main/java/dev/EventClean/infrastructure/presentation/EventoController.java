package dev.EventClean.infrastructure.presentation;

import dev.EventClean.core.entities.Evento;
import dev.EventClean.core.usecases.BuscarEventosCase;
import dev.EventClean.core.usecases.CriarEventoCase;
import dev.EventClean.core.usecases.FiltroIdentificadorUsecase;
import dev.EventClean.infrastructure.dtos.EventoDTO;
import dev.EventClean.infrastructure.mappers.EventoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class EventoController {

    private final CriarEventoCase criarEventoCase;
    private final BuscarEventosCase buscarEventosCase;
    private final FiltroIdentificadorUsecase filtrarPorIdentificador;
    private final EventoMapper mapper;

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDTO eventoDTO ) {
        Evento novoEvento = criarEventoCase.execute(mapper.toEvento(eventoDTO));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem:", "Evento cadastrado com sucesso!");
        response.put("Dados do evento: ", mapper.toEventoDTO(novoEvento));
        return ResponseEntity.ok(response);
    }

    @GetMapping("listareventos")
    public ResponseEntity<Map<String, Object>> listaevento() {
       List<EventoDTO> listaEventos = buscarEventosCase.execute().stream().map(mapper::toEventoDTO).toList();
       Map<String, Object> response = new HashMap<>();
       response.put("Mensagem:", "Lista de eventos");
       response.put("Dados dos eventos: ", listaEventos);
       return ResponseEntity.ok(response);
    }

    @GetMapping("{identificador}")
    public ResponseEntity<EventoDTO> buscarPorIdentificador(@PathVariable("identificador") String identificador) {
        Evento evento = filtrarPorIdentificador.execute(identificador);
        return ResponseEntity.ok(mapper.toEventoDTO(evento));
    }
}

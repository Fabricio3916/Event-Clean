package dev.EventClean.infrastructure.persistence;

import dev.EventClean.core.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="tb_evento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private String identificador;

    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    private String localEvento;

    private String organizador;

    private Integer capacidade;

}
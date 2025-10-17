package dev.EventClean.infrastructure.beans;

import dev.EventClean.core.gateway.EventoGateway;
import dev.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CriarEventoCase criarEventoUseCase(EventoGateway eventoGateway) {
        return new CriarEventoCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventosCase buscarEventosUseCase(EventoGateway eventoGateway) {
        return new BuscarEventosCaseImpl(eventoGateway);
    }

    @Bean
    public FiltroIdentificadorUsecase filtroIdentificadorUsecase(EventoGateway eventoGateway) {
        return new FiltroIdentificadorUsecaseImpl(eventoGateway);
    }

}

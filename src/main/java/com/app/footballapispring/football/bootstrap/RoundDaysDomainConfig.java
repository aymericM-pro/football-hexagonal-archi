package com.app.footballapispring.football.bootstrap;

import com.app.footballapispring.football.domain.roundday.RoundDayRepository;
import com.app.footballapispring.football.domain.roundday.usecases.AddFixtureToRoundDayUseCase;
import com.app.footballapispring.football.domain.roundday.usecases.CreateRoundDayUseCase;
import com.app.footballapispring.football.domain.roundday.usecases.GetRoundDayQueryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoundDaysDomainConfig {

    @Bean
    public AddFixtureToRoundDayUseCase addFixtureToRoundDayUseCase(RoundDayRepository repository) {
        return new AddFixtureToRoundDayUseCase(repository);
    }

    @Bean
    public CreateRoundDayUseCase createRoundDayUseCase(RoundDayRepository repository) {
        return new CreateRoundDayUseCase(repository);
    }

    @Bean
    public GetRoundDayQueryHandler getRoundDayQueryHandler(RoundDayRepository repository) {
        return new GetRoundDayQueryHandler(repository);
    }
}

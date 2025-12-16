package com.app.footballapispring.football.infrastructure.roundday;

import com.app.footballapispring.football.domain.roundday.RoundDay;
import com.app.footballapispring.football.domain.roundday.RoundDayRepository;
import com.app.footballapispring.football.infrastructure.championship.ChampionshipEntity;
import com.app.footballapispring.football.infrastructure.championship.SpringDataChampionshipRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaRoundDayRepository implements RoundDayRepository {

    private final SpringDataRoundDayRepository roundDayJpa;
    private final SpringDataChampionshipRepository championshipJpa;

    public JpaRoundDayRepository(
            SpringDataRoundDayRepository roundDayJpa,
            SpringDataChampionshipRepository championshipJpa
    ) {
        this.roundDayJpa = roundDayJpa;
        this.championshipJpa = championshipJpa;
    }

    @Override
    public RoundDay save(RoundDay domain, String championshipId) {

        ChampionshipEntity championship = championshipJpa
                .findById(UUID.fromString(championshipId))
                .orElseThrow(() ->
                        new IllegalStateException("Championship not found")
                );

        RoundDayEntity entity =
                RoundDayMapper.toEntity(domain, championship);

        RoundDayEntity saved = roundDayJpa.save(entity);
        return RoundDayMapper.toDomain(saved);
    }

    @Override
    public Optional<RoundDay> findById(String id) {
        return roundDayJpa.findById(UUID.fromString(id))
                .map(RoundDayMapper::toDomain);
    }

    @Override
    public List<RoundDay> findAll() {
        return roundDayJpa.findAll()
                .stream()
                .map(RoundDayMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(String id) {
        roundDayJpa.deleteById(UUID.fromString(id));
    }
}

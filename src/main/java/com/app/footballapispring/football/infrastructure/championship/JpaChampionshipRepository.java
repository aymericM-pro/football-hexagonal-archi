package com.app.footballapispring.football.infrastructure.championship;

import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaChampionshipRepository implements ChampionshipRepository {

    private final SpringDataChampionshipRepository repository;

    public JpaChampionshipRepository(SpringDataChampionshipRepository repository) {
        this.repository = repository;
    }

    @Override
    public Championship save(Championship championship) {
        ChampionshipEntity entity = ChampionshipMapper.toEntity(championship);
        ChampionshipEntity entitySaved = repository.save(entity);
        return ChampionshipMapper.toDomain(entitySaved);
    }

    @Override
    public Optional<Championship> findById(String championshipId) {
        return repository.findById(UUID.fromString(championshipId))
                .map(ChampionshipMapper::toDomain);
    }

    @Override
    public List<Championship> findAll() {
        return repository.findAll()
                .stream()
                .map(ChampionshipMapper::toDomain)
                .toList();
    }

}

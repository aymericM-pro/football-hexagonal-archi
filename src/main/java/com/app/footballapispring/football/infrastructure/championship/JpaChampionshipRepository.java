package com.app.footballapispring.football.infrastructure.championship;

import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.infrastructure.team.TeamEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaChampionshipRepository implements ChampionshipRepository {

    private final SpringDataChampionshipRepository repository;

    public JpaChampionshipRepository(SpringDataChampionshipRepository repository) {
        this.repository = repository;
    }

    @OneToMany(mappedBy = "championship", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TeamEntity> teams = new ArrayList<>();

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
}

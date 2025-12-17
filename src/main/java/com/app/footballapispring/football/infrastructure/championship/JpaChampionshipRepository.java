package com.app.footballapispring.football.infrastructure.championship;

import com.app.footballapispring.core.errors.BusinessException;
import com.app.footballapispring.core.errors.exceptions.ChampionshipsError;
import com.app.footballapispring.football.domain.championship.Championship;
import com.app.footballapispring.football.domain.championship.ChampionshipRepository;
import com.app.footballapispring.football.infrastructure.team.JpaTeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class JpaChampionshipRepository implements ChampionshipRepository {

    private final SpringDataChampionshipRepository repository;
    private final JpaTeamRepository repositoryTeam;

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

    @Override
    public Optional<Championship> findByIdWithTeams(String championshipId) {
        return repository
                .findByIdWithTeams(UUID.fromString(championshipId))
                .map(ChampionshipMapper::toDomainWithTeams);
    }

    @Transactional
    public Championship initializeCalendar(String championshipId) {
        ChampionshipEntity championship = repository
                .findById(UUID.fromString(championshipId))
                .orElseThrow(() -> new BusinessException(ChampionshipsError.CHAMPIONSHIP_NOT_FOUND));

        Championship domain = ChampionshipMapper.toDomainWithTeams(championship);
        domain.createRounddaysChampionship();
        ChampionshipMapper.applyRoundDays(domain, championship);
        return ChampionshipMapper.toDomainWithTeams(championship);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Championship> findByIdWithRoundDays(String championshipId) {

        return repository
                .findByIdWithRoundDays(UUID.fromString(championshipId))
                .map(ChampionshipMapper::toDomainWithRoundDays);
    }
}

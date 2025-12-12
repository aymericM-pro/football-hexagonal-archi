package com.app.footballapispring.football.infrastructure.roundday;

import com.app.footballapispring.football.domain.roundday.RoundDay;
import com.app.footballapispring.football.domain.roundday.RoundDayRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaRoundDayRepository implements RoundDayRepository {

    private final SpringDataRoundDayRepository jpa;

    public JpaRoundDayRepository(SpringDataRoundDayRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public RoundDay save(RoundDay domain) {
        RoundDayEntity entity = RoundDayMapper.toEntity(domain);
        RoundDayEntity saved = jpa.save(entity);
        return RoundDayMapper.toDomain(saved);
    }

    @Override
    public Optional<RoundDay> findById(String id) {
        return jpa.findById(UUID.fromString(id))
                .map(RoundDayMapper::toDomain);
    }

    @Override
    public List<RoundDay> findAll() {
        return jpa.findAll()
                .stream()
                .map(RoundDayMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String id) {
        jpa.deleteById(UUID.fromString(id));
    }
}

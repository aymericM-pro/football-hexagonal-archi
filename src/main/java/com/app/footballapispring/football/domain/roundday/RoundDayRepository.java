package com.app.footballapispring.football.domain.roundday;

import java.util.List;
import java.util.Optional;

public interface RoundDayRepository {

    RoundDay save(RoundDay roundDay, String championshipId);

    Optional<RoundDay> findById(String id);

    List<RoundDay> findAll();

    void delete(String id);
}

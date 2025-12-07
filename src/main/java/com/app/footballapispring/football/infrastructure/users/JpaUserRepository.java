package com.app.footballapispring.football.infrastructure.users;

import com.app.footballapispring.football.domain.user.User;
import com.app.footballapispring.football.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JpaUserRepository implements UserRepository {

    private final SpringDataUserRepository repo;

    public JpaUserRepository(SpringDataUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User save(User user) {
        UserEntity entity = new UserEntity(
                user.getEmail(),
                user.getPasswordHash(),
                user.getRole()
        );
        UserEntity saved = repo.save(entity);
        return new User(
                saved.getId().toString(),
                saved.getEmail(),
                saved.getPasswordHash(),
                saved.getRole()
        );
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repo.findByEmail(email)
                .map(e -> new User(
                        e.getId().toString(),
                        e.getEmail(),
                        e.getPasswordHash(),
                        e.getRole()
                ));
    }
}

package ru.inno.springbootwebinar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.springbootwebinar.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

package jm.springboot3.repository;

import org.springframework.data.repository.CrudRepository;
import jm.springboot3.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
    User findByEmail(String email);
    void deleteById(Long id);
}


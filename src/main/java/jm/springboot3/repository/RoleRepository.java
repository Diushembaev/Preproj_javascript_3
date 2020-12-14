package jm.springboot3.repository;

import org.springframework.data.repository.CrudRepository;
import jm.springboot3.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}

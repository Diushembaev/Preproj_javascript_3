package jm.springboot3.service;

import jm.springboot3.model.Role;

import java.util.Set;

public interface RoleService {
    void createRoles(Set<Role> roles);
    Set<Role> getAllRoles();
}

package jm.springboot3.config;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import jm.springboot3.model.User;
import jm.springboot3.model.Role;
import jm.springboot3.service.RoleService;
import jm.springboot3.service.UserService;
import java.util.HashSet;
import java.util.Set;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private UserService userService;
    private RoleService roleService;

    public SetupDataLoader (UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Set<Role> allRoles = new HashSet<>();
        allRoles.add(new Role("ADMIN"));
        allRoles.add(new Role("USER"));
        roleService.createRoles(allRoles);
        User admin = new User("admin", "admin", 30, "admin@mail.ru", "admin");
        admin.setRoles("ADMIN, USER");
        userService.createUser(admin);
        User user = new User("user", "user", 10, "user@mail.ru", "user");
        user.setRoles("USER");
        userService.createUser(user);
    }
}

package com.example.userservice.user;

import com.example.userservice.model.Role;
import com.example.userservice.repo.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTest {
    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateFirstRole(){
        Role roleAdmin = new Role("Admin","manage everything");
        Role savedRole = repo.save(roleAdmin);
        assertThat(savedRole.getId()).isGreaterThan(0);
    }
}

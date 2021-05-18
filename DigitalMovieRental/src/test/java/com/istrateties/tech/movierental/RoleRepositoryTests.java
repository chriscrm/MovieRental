package com.istrateties.tech.movierental;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.istrateties.tech.movierental.entity.UserRolesEntity;
import com.istrateties.tech.movierental.repository.UserRoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback
public class RoleRepositoryTests {

	@Autowired
	UserRoleRepository repo;
	
	@Test
	public void testCreateRole() {
		UserRolesEntity user = new UserRolesEntity("user");
		UserRolesEntity admin = new UserRolesEntity("admin");
		
		repo.saveAll(List.of(user, admin));
		
		repo.findAll();
		
	}
	
}

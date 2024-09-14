package org.coderRups.UserService.entity.repo;

import org.coderRups.UserService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

}

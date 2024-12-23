package com.jsp.user_management_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.user_management_backend.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select a from User a where email=?1")
	User findbyEmail(String email);

}

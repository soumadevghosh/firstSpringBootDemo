package com.SpringMVCBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringMVCBoot.model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	User findByUsername (String username);
}

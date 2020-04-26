package com.SpringMVCBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringMVCBoot.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>
{
	Users findByUsername (String username);
}

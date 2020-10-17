package com.intern.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intern.test.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

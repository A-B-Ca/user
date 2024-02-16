package com.estore.user.repository;

import com.estore.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<UserEntity,Integer>{
    Optional<UserEntity> findByUserName(String userName);
}

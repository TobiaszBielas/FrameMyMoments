package com.frameMyMoments.repository;

import com.frameMyMoments.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.email=email")
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    List<User> findAllByUserRoleId(Long userRoleId);
}

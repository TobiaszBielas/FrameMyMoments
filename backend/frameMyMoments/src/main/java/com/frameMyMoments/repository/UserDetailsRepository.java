package com.frameMyMoments.repository;

import com.frameMyMoments.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository <UserDetails, Long>{
    Optional<UserDetails> findByUserId(Long userId);

}

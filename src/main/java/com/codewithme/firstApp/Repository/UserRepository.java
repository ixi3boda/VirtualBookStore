package com.codewithme.firstApp.Repository;

import com.codewithme.firstApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   User findByUserId(Long userId);

   Optional <User> findByUserName(String userName);
   Optional <User> findByUserEmail(String userEmail);
   boolean existsByUserName(String userName);
   boolean existsByUserEmail(String userEmail);
}

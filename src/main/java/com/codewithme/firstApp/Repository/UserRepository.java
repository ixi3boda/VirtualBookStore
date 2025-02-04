package com.codewithme.firstApp.Repository;

import com.codewithme.firstApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   User findByUserId(Long userId);
}

package com.arge.issuemanagement.repository;

import com.arge.issuemanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dilara.akbas on Sep, 2020
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}

package com.arge.issuemanagement.service;

import com.arge.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by dilara.akbas on Sep, 2020
 */
public interface UserService {

    User save(User user);

    User getById(Long id);

    Page<User> getAllPageable(Pageable pageable);

    Boolean delete(User user);

    User getByUsername(String username);
}

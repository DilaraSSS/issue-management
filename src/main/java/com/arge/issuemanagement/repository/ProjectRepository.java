package com.arge.issuemanagement.repository;

import com.arge.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

/**
 * Created by dilara.akbas on Sep, 2020
 */

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project getByProjectCode(String projectCode);

    List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode, String name);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);

    Project getByProjectCodeAndIdNot(String projectCode, Long id);

    Optional<Project> findByProjectCode(String projectCode);

}

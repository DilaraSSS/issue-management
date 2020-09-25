package com.arge.issuemanagement.repository;

import com.arge.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dilara.akbas on Sep, 2020
 */
public interface IssueRepository extends JpaRepository<Issue,Long> {

}

package com.arge.issuemanagement.repository;

import com.arge.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dilara.akbas on Sep, 2020
 */
public interface IssueHistoryRepository extends JpaRepository<IssueHistory,Long> {
}

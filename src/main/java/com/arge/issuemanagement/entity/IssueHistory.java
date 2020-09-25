package com.arge.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dilara.akbas on Sep, 2020
 */
@Entity
@Table(name = "issue_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class IssueHistory extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @JoinColumn(name = "issue_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Issue issue;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User assignee;

}

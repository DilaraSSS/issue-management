package com.arge.issuemanagement.entity;

import lombok.*;

import javax.persistence.*;

/**
 * Created by dilara.akbas on Sep, 2020
 */
@Entity
@Table(name = "project")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_name", length = 400)
    private String projectName;

    @Column(name = "project_code", unique = true)
    private String projectCode;

    @JoinColumn(name = "manager_user_id")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private User manager;

}

package com.arge.issuemanagement.service;

import com.arge.issuemanagement.dto.ProjectDto;
import com.arge.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by dilara.akbas on Sep, 2020
 */
public interface ProjectService {

    ProjectDto save(ProjectDto projectDto);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<ProjectDto> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(ProjectDto projectDto);

    ProjectDto update(Long id, ProjectDto projectDto);
}

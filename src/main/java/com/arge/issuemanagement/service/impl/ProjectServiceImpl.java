package com.arge.issuemanagement.service.impl;

import com.arge.issuemanagement.dto.IssueDto;
import com.arge.issuemanagement.dto.ProjectDto;
import com.arge.issuemanagement.entity.Issue;
import com.arge.issuemanagement.entity.Project;
import com.arge.issuemanagement.repository.ProjectRepository;
import com.arge.issuemanagement.service.ProjectService;
import com.arge.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by dilara.akbas on Sep, 2020
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {

        Project projectCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());

        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exists!");

        Project project = projectRepository.save(modelMapper.map(projectDto, Project.class));
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public ProjectDto getById(Long id) {

        if (projectRepository.findById(id).equals(Optional.empty()))
            throw new IllegalArgumentException("Project Does Not Exist with ID: " + id);

        return modelMapper.map(projectRepository.getOne(id), ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {

        if (projectRepository.findByProjectCode(projectCode).equals(Optional.empty()))
            throw new IllegalArgumentException("Project Does Not Exist with Project Code: " + projectCode);

        return modelMapper.map(projectRepository.getByProjectCode(projectCode), ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public TPage<ProjectDto> getAllPageable(Pageable pageable) {

        Page<Project> data = projectRepository.findAll(pageable);
        TPage<ProjectDto> response = new TPage<>();
        response.setStat(data, Arrays.asList((modelMapper.map(data.getContent(), ProjectDto[].class))));
        return response;
    }

    @Override
    public Boolean delete(ProjectDto projectDto) {
        return null;
    }

    public Boolean delete(Long id) {

        if (projectRepository.findById(id).equals(Optional.empty()))
            throw new IllegalArgumentException("Project Does Not Exist with ID: " + id);

        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {

        Project project = projectRepository.getOne(id);

        if (project == null)
            throw new IllegalArgumentException("Project Does Not Exist with Id: " + id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(), id);

        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exists!");

        project.setProjectCode(projectDto.getProjectCode());
        project.setProjectName(projectDto.getProjectName());

        return modelMapper.map(projectRepository.save(project), ProjectDto.class);
    }
}

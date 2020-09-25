package com.arge.issuemanagement.service.impl;

import com.arge.issuemanagement.dto.ProjectDto;
import com.arge.issuemanagement.entity.Project;
import com.arge.issuemanagement.repository.ProjectRepository;
import com.arge.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return modelMapper.map(projectRepository.getOne(id), ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return modelMapper.map(projectRepository.getByProjectCode(projectCode), ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<ProjectDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(ProjectDto projectDto) {
        return null;
    }

    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {

        Project project = projectRepository.getOne(id);

        if (project == null)
            throw new IllegalArgumentException("Project does not exist with Id: " + id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(), id);

        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exists!");

        project.setProjectCode(projectDto.getProjectCode());
        project.setProjectName(projectDto.getProjectName());

        return modelMapper.map(projectRepository.save(project), ProjectDto.class);
    }
}

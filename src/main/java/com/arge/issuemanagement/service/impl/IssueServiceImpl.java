package com.arge.issuemanagement.service.impl;

import com.arge.issuemanagement.dto.IssueDto;
import com.arge.issuemanagement.dto.ProjectDto;
import com.arge.issuemanagement.entity.Issue;
import com.arge.issuemanagement.entity.Project;
import com.arge.issuemanagement.repository.IssueRepository;
import com.arge.issuemanagement.service.IssueService;
import com.arge.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by dilara.akbas on Sep, 2020
 */
@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {
            if (issue.getDate() == null) {
                throw new IllegalArgumentException("Issue date cannot be empty!");
            }
            Issue issueMapped = modelMapper.map(issue, Issue.class);
            return modelMapper.map(issueRepository.save(issueMapped), IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {

        return modelMapper.map(issueRepository.getOne(id), IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        issueRepository.delete(modelMapper.map(issue, Issue.class));
        return Boolean.TRUE;
    }

    @Override
    public IssueDto update(Long id, IssueDto issueDto) {

        Issue issue = issueRepository.getOne(id);

        if (issue == null)
            throw new IllegalArgumentException("Issue does not exist with Id: " + id);


        return null;
    }

    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return true;
    }
}

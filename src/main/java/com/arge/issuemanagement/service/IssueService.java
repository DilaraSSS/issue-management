package com.arge.issuemanagement.service;

import com.arge.issuemanagement.dto.IssueDto;
import com.arge.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

/**
 * Created by dilara.akbas on Sep, 2020
 */
public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(IssueDto issue);

    IssueDto update(Long id, IssueDto issue);
}

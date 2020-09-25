package com.arge.issuemanagement.dto;

import com.arge.issuemanagement.entity.IssueStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by dilara.akbas on Sep, 2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueDto {

    @Schema(description = "Unique identifier of the Issue.", example = "1")
    private Long id;

    @Schema(description = "Description of Issue.")
    private String description;

    @Schema(description = "Details of Issue.")
    private  String details;

    @Schema(description = "Date of Issue.", example = "1970-01-19T12:44:03.488+00:00", required = true)
    private Date date;

    @Schema(description = "Issue Status of Issue")
    private IssueStatus issueStatus;

    @Schema(description = "User of Issue.")
    private UserDto userDto;

    @Schema(description = "Project of Issue.")
    private ProjectDto projectDto;
}

package com.arge.issuemanagement.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by dilara.akbas on Sep, 2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    @Schema(description = "Unique identifier of the Project.", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Name of Project.", example = "Mars Project", required = true)
    private String projectName;

    @NotNull
    @Schema(description = "Code of Project.", example = "MARS001", required = true)
    private String projectCode;
}

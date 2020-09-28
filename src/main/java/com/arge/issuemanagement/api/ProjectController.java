package com.arge.issuemanagement.api;

import com.arge.issuemanagement.dto.ProjectDto;
import com.arge.issuemanagement.service.impl.ProjectServiceImpl;
import com.arge.issuemanagement.util.ApiPaths;
import com.arge.issuemanagement.util.TPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by dilara.akbas on Sep, 2020
 */
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Tag(name = "The Project API")

public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectServiceImpl = projectService;
    }

    @GetMapping(ApiPaths.Methods.GET_BY_ID + "{id}")
    @Operation(summary = "Get By Id Operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Project with specified ID", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDto.class))}),
            @ApiResponse(responseCode = "404", description = "Project not found", content = @Content)})
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(projectServiceImpl.getById(id));
    }

    @PostMapping(ApiPaths.Methods.CREATE)
    @Operation(summary = "Create Operation")
    @ApiResponse(responseCode = "200", description = "Created the Project", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDto.class))})
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @GetMapping(ApiPaths.Methods.GET_BY_PROJECT_CODE + "{projectCode}")
    @Operation(summary = "Get By Project Code Operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Project with specified Project Code", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDto.class))}),
            @ApiResponse(responseCode = "404", description = "Project not found", content = @Content)})
    public ResponseEntity<ProjectDto> getProjectProjectCode(@PathVariable("projectCode") String projectCode) {
        return ResponseEntity.ok(projectServiceImpl.getByProjectCode(projectCode));
    }

    @PutMapping(ApiPaths.Methods.UPDATE + "{id}")
    @Operation(summary = "Update Operation")
    @ApiResponse(responseCode = "200", description = "Updated the Project", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDto.class))})
    public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectServiceImpl.update(id, project));
    }

    @GetMapping(ApiPaths.Methods.GET_BY_PAGEABLE)
    @Operation(summary = "Get All Pageable Operation")
    //@ApiResponses(value = {
    //        @ApiResponse(responseCode = "200", description = "Found the Pageable Projects", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = TPage<ProjectDto>.class))}),
    //       @ApiResponse(responseCode = "404", description = "Pageable Projects not found", content = @Content)})
    public ResponseEntity<TPage<ProjectDto>> getAllPageable(Pageable pageable) {
        TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping(ApiPaths.Methods.DELETE + "{id}")
    @Operation(summary = "Delete Operation")
    @ApiResponse(responseCode = "200", description = "Deleted the Project", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))})
    public ResponseEntity<Boolean> deleteProject(@PathVariable("id") Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}

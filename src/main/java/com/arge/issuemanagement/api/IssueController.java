package com.arge.issuemanagement.api;

import com.arge.issuemanagement.dto.IssueDto;
import com.arge.issuemanagement.service.impl.IssueServiceImpl;
import com.arge.issuemanagement.util.ApiPaths;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by dilara.akbas on Sep, 2020
 */
@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Tag(name = "The Issue API")
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping(ApiPaths.Methods.GET_BY_ID + "{id}")
    @Operation(summary = "Get By Id Operation")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Issue with specified ID", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = IssueDto.class))}),
            @ApiResponse(responseCode = "404", description = "Issue not found", content = @Content)})
    public ResponseEntity<IssueDto> getIssueById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(issueServiceImpl.getById(id));
    }

    @PostMapping(ApiPaths.Methods.CREATE)
    @Operation(summary = "Create Operation")
    @ApiResponse(responseCode = "200", description = "Created the Issue", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = IssueDto.class))})
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }

    @PutMapping(ApiPaths.Methods.UPDATE + "{id}")
    @Operation(summary = "Update Operation")
    @ApiResponse(responseCode = "200", description = "Updated the Issue", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = IssueDto.class))})
    public ResponseEntity<IssueDto> updateIssue(@PathVariable("id") Long id, @Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.update(id, issue));
    }

    @DeleteMapping(ApiPaths.Methods.DELETE + "{id}")
    @Operation(summary = "Delete Operation")
    @ApiResponse(responseCode = "200", description = "Deleted the Issue", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Boolean.class))})
    public ResponseEntity<Boolean> deleteIssue(@PathVariable("id") Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }

}

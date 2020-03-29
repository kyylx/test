package org.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.controller.responce.ProjectResponse;
import org.web.service.ProjectService;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public List<ProjectResponse> findAllProjects() {

        return projectService.findAllProjects();
    }
}

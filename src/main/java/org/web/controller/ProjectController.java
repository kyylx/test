package org.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web.domain.Device;
import org.web.domain.Project;
import org.web.service.ProjectService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/")
    public List<Project> findAllProjects() {

        return projectService.findAllProjects();
    }
}

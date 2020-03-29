package org.web.service;

import org.web.controller.responce.ProjectResponse;

import java.util.List;

public interface ProjectService {
    List<ProjectResponse> findAllProjects();
}

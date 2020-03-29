package org.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web.domain.Project;
import org.web.domain.Stats;
import org.web.repository.ProjectRepository;

import java.util.List;

@Service
public class DefaultProjectService implements ProjectService {

    private final ProjectRepository projectRepository;

    public DefaultProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAllProjects() {
        List<Project> projects = projectRepository.findAll();
        for (Project project : projects) {

        }

        return null;
    }
}

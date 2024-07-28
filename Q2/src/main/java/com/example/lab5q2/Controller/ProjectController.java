package com.example.lab5q2.Controller;

import com.example.lab5q2.Model.Project;
import com.example.lab5q2.Response.Response;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/lab5/q2")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<>();

    @PostMapping("/add")
    public Response addProject(@RequestBody Project project) {
        projects.add(project);
        return new Response("Project added");
    }

    @GetMapping("/displayAll")
    public ArrayList<Project> displayAllProjects() {
        return projects;
    }

    @PutMapping("/update/{index}")
    public Response updateProject(@PathVariable int index, @RequestBody Project project) {
        if (index < projects.size()) {
            projects.set(index, project);
            return new Response("Project updated");
        }
        return new Response("Project not found");
    }

    @DeleteMapping("/delete/{index}")
    public Response deleteProject(@PathVariable int index) {
        if (index < projects.size()) {
            projects.remove(index);
            return new Response("Project deleted");
        }
        return new Response("Project not found");
    }

    @PutMapping("/changeProjectStatus/{id}/{status}")
    public Response changeProjectStatus(@PathVariable int id, @PathVariable String status) {
        for (Project project : projects) {
            if (project.getId() == id) {
                if (!project.getStatus().equals(status)) {
                    project.setStatus(status);
                    return new Response("Project status changed");
                }
                else
                    return new Response("Project status not changed");
            }
        }
        return new Response("Project not found");
    }

    @GetMapping("/projectByTitle/{title}")
    public Project getProjectByTitle(@PathVariable String title) {
        for (Project project : projects) {
            if (project.getTitle().equals(title)) {
                return project;
            }
        }
        return null;
    }

    @GetMapping("/projectsByCompanyName/{companyName}")
    public ArrayList<Project> getProjectsByCompanyName(@PathVariable String companyName) {
        ArrayList<Project> companyProjects = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCompanyName().equals(companyName)) {
                companyProjects.add(project);
            }
        }
        return companyProjects;
    }
}

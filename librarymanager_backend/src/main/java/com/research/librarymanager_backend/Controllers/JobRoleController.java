package com.research.librarymanager_backend.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.librarymanager_backend.Models.JobRole;
import com.research.librarymanager_backend.Services.JobRoleService;

@RestController
@RequestMapping("/api/jobroles")
public class JobRoleController {

    @Autowired
    private JobRoleService jobRoleService;

    
    public JobRoleController(JobRoleService jobRoleService) {
        this.jobRoleService = jobRoleService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobRole>> getAllJobRoles() {
        List<JobRole> jobRole = jobRoleService.getAllJobRoles();
        return new ResponseEntity<>(jobRole, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<JobRole> getJobRoleById(@PathVariable("id") Long id) {
        JobRole jobRole = jobRoleService.getJobRoleById(id);
        return new ResponseEntity<>(jobRole, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<JobRole> createJobRole(@RequestBody JobRole jobRole) {
        JobRole newRole = jobRoleService.createJobRole(jobRole);
        return new ResponseEntity<>(newRole, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<JobRole> updateJobRole(@RequestBody JobRole jobRole) {
        JobRole updatedJobRole = jobRoleService.updateJobRole(jobRole);
        return new ResponseEntity<>(updatedJobRole, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJobRole(@PathVariable("id") Long id) {
        jobRoleService.deleteJobRole(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

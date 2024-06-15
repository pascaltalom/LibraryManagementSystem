package com.research.librarymanager_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Exceptions.JobRoleNotFoundException;
import com.research.librarymanager_backend.Models.JobRole;
import com.research.librarymanager_backend.Repositories.JobRoleRepository;

@Service
public class JobRoleService {

    @Autowired
    private JobRoleRepository jobRoleRepository;

    public JobRoleService(JobRoleRepository jobRoleRepository) {
        this.jobRoleRepository = jobRoleRepository;
    }

    // Get all JobRoles
    public List<JobRole> getAllJobRoles() {
        return jobRoleRepository.findAll();
    }

    // Get JobRole By Id
    public JobRole getJobRoleById(Long roleId) {
        return jobRoleRepository.findById(roleId).orElseThrow(()-> new JobRoleNotFoundException("Role with id"+ roleId + "Not Found"));
    }

    // Create a JobRole
    public JobRole createJobRole(JobRole jobRole) {
        return jobRoleRepository.save(jobRole);
    }

    // Update a JobRole
    public JobRole updateJobRole(JobRole jobRole){
        return jobRoleRepository.save(jobRole);
    }

    // Delete JobRole
    public void deleteJobRole(Long roleId) {
        jobRoleRepository.deleteById(roleId);
    }
}

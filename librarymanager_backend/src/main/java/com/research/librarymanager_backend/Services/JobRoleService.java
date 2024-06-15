package com.research.librarymanager_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Models.JobRole;
import com.research.librarymanager_backend.Repositories.JobRoleRepository;

@Service
public class JobRoleService {

    @Autowired
    private JobRoleRepository jobRoleRepository;

    // Get all JobRoles
    public List<JobRole> getAllJobRoles() {
        return jobRoleRepository.findAll();
    }

    // Get JobRole By Id
    public JobRole getJobRoleById(Long roleId) {
        Optional<JobRole> jobRole = jobRoleRepository.findById(roleId);
        return jobRole.orElse(null);
    }

    // Create a JobRole
    public JobRole createJobRole(JobRole jobRole) {
        return jobRoleRepository.save(jobRole);
    }

    // Update a JobRole
    public JobRole updateJobRole(Long roleId, JobRole jobRole) {
        Optional<JobRole> existingJobRole = jobRoleRepository.findById(roleId);
        if (existingJobRole.isPresent()) {
            JobRole updatedJobRole = existingJobRole.get();
            updatedJobRole.setRoleName(jobRole.getRoleName());
            updatedJobRole.setSalary(jobRole.getSalary());
            return jobRoleRepository.save(updatedJobRole);
        }
        return null;
    }

    // Delete JobRole
    public void deleteJobRole(Long roleId) {
        jobRoleRepository.deleteById(roleId);
    }
}

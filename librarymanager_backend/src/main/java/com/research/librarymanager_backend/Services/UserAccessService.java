package com.research.librarymanager_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Models.UserAccess;
import com.research.librarymanager_backend.Repositories.UserAccessRepository;

@Service
public class UserAccessService {

    @Autowired
    private UserAccessRepository userAccessRepository;

    // Get all User Accesses
    public List<UserAccess> getAllUserAccesses() {
        return userAccessRepository.findAll();
    }

    // Get User access By id
    public UserAccess getUserAccessById(Long userId) {
        Optional<UserAccess> userAccess = userAccessRepository.findById(userId);
        return userAccess.orElse(null);
    }

    // Create a User access
    public UserAccess createUserAccess(UserAccess userAccess) {
        return userAccessRepository.save(userAccess);
    }

    // Update a User Access
    public UserAccess updateUserAccess(Long userId, UserAccess userAccess) {
        Optional<UserAccess> existingUserAccess = userAccessRepository.findById(userId);
        if (existingUserAccess.isPresent()) {
            UserAccess updatedUserAccess = existingUserAccess.get();
            updatedUserAccess.setUsername(userAccess.getUsername());
            updatedUserAccess.setPassword(userAccess.getPassword());
            updatedUserAccess.setAccessLevel(userAccess.getAccessLevel());
            updatedUserAccess.setEmployee(userAccess.getEmployee());
            return userAccessRepository.save(updatedUserAccess);
        }
        return null;
    }

    // Delete User Access
    public void deleteUserAccess(Long userId) {
        userAccessRepository.deleteById(userId);
    }
}

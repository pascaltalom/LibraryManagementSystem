package com.research.librarymanager_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Exceptions.AccessNotFoundException;
import com.research.librarymanager_backend.Models.UserAccess;
import com.research.librarymanager_backend.Repositories.UserAccessRepository;

@Service
public class UserAccessService {

    @Autowired
    private UserAccessRepository userAccessRepository;
    

    // create a constructor
    public UserAccessService(UserAccessRepository userAccessRepository) {
        this.userAccessRepository = userAccessRepository;
    }

    // add a User access
    public UserAccess createUserAccess(UserAccess userAccess) {
        return userAccessRepository.save(userAccess);
    }

    // Get all User Accesses
    public List<UserAccess> getAllUserAccesses() {
        return userAccessRepository.findAll();
    }

    // Get User access By id
    public UserAccess getUserAccessById(Long userId) {
        return userAccessRepository.findById(userId).orElseThrow(()->new AccessNotFoundException("userAccess"+userId+" was Not Found"));
    }

    // Update a User Access
    public UserAccess updatUserAccess(UserAccess userAccess){
        return userAccessRepository.save(userAccess);
    }

    // Delete User Access
    public void deleteUserAccess(Long userId) {
        userAccessRepository.deleteById(userId);
    }
}

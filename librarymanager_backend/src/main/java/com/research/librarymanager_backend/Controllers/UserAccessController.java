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

import com.research.librarymanager_backend.Models.UserAccess;
import com.research.librarymanager_backend.Services.UserAccessService;

@RestController
@RequestMapping("/api/useraccess")
public class UserAccessController {

    @Autowired
    private UserAccessService userAccessService;

    public UserAccessController(UserAccessService userAccessService){
        this.userAccessService = userAccessService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAccess>> getAllUserAccess() {
        List<UserAccess> userAccess = userAccessService.getAllUserAccesses();
        return new ResponseEntity<>(userAccess, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserAccess> getUserAccessById(@PathVariable("id") Long id) {
        UserAccess userAccess = userAccessService.getUserAccessById(id);
        return new ResponseEntity<>(userAccess, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserAccess> createUserAccess(@RequestBody UserAccess userAccess) {
        UserAccess createUserAccess = userAccessService.createUserAccess(userAccess);
        return new ResponseEntity<>(createUserAccess, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<UserAccess> updateUserAccess(@RequestBody UserAccess userAccess) {
        UserAccess updatedUserAccess = userAccessService.updatUserAccess(userAccess);
        return new ResponseEntity<>(updatedUserAccess, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserAccess(@PathVariable("id") Long id) {
        userAccessService.deleteUserAccess(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

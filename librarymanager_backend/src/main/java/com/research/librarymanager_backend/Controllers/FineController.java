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

import com.research.librarymanager_backend.Models.Fine;
import com.research.librarymanager_backend.Services.FineService;

@RestController
@RequestMapping("/api/fines")
public class FineController {

    @Autowired
    private FineService fineService;

    public FineController(FineService fineService) {
        this.fineService = fineService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fine>> getAllFines() {
        List<Fine> fine = fineService.getAllFines();
        return new ResponseEntity<>(fine, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Fine> getFineById(@PathVariable("id") Long id) {
        Fine fine = fineService.getFineById(id);
        return new ResponseEntity<>(fine, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Fine> createFine(@RequestBody Fine fine) {
        Fine newfine = fineService.createFine(fine);
        return new ResponseEntity<>(newfine, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Fine> updateFine(@RequestBody Fine fine) {
        Fine updatefine = fineService.updateFine(fine);
        return new ResponseEntity<>(updatefine, HttpStatus.CREATED);
    }

    @DeleteMapping("/find/{id}")
    public ResponseEntity<Void> deleteFine(@PathVariable("id") Long id) {
        fineService.deleteFine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
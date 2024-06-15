package com.research.librarymanager_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Exceptions.FineNotFoundException;
import com.research.librarymanager_backend.Models.Fine;
import com.research.librarymanager_backend.Repositories.FineRepository;

@Service
public class FineService {

    @Autowired
    private FineRepository fineRepository;
    
    public FineService(FineRepository fineRepository) {
        this.fineRepository = fineRepository;
    }

    // Create a fine
    public Fine createFine(Fine fine) {
        return fineRepository.save(fine);
    }

    // Get all fines
    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }

    // Get Fine by Id
    public Fine getFineById(Long fineId) {
        return fineRepository.findById(fineId).orElseThrow(()->new FineNotFoundException("Fine with id"+ fineId +"Not Found"));
    }

    // Update Member
    public Fine updateFine(Fine fine){
        return fineRepository.save(fine);
    }


   // Delete fine
    public void deleteFine(Long fineId) {
        fineRepository.deleteById(fineId);
    }
}

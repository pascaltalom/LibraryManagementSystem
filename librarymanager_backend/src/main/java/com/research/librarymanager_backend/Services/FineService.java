package com.research.librarymanager_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Models.Fine;
import com.research.librarymanager_backend.Repositories.FineRepository;

@Service
public class FineService {

    @Autowired
    private FineRepository fineRepository;

    // Create a fine
    public Fine createFine(Fine fine) {
        return fineRepository.save(fine);
    }

    // Get all fines
    public List<Fine> getAllFines() {
        return fineRepository.findAll();
    }

    // Get Fine by Id
    public Optional<Fine> getFineById(Long fineId) {
        return fineRepository.findById(fineId);
    }


    // Update Fine
    public Fine updateFine(Long fineId, Fine fine) {
        Optional<Fine> existingFine = fineRepository.findById(fineId);
        if (existingFine.isPresent()) {
            Fine updatedFine = existingFine.get();
            updatedFine.setBookCopy(fine.getBookCopy());
            updatedFine.setFineAmount(fine.getFineAmount());
            updatedFine.setFineDate(fine.getFineDate());
            updatedFine.setStatus(fine.getStatus());
            updatedFine.setMember(fine.getMember());
            return fineRepository.save(updatedFine);
        }
        return null;
    }

   // Delete fine
    public void deleteFine(Long fineId) {
        fineRepository.deleteById(fineId);
    }
}

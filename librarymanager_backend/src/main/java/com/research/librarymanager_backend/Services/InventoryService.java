package com.research.librarymanager_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Models.Inventory;
import com.research.librarymanager_backend.Repositories.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Create Book
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Get all Inventories
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    // Get Inventory by Id
    public Optional<Inventory> getInventoryById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId);
    }

    // Update Inventory
    public Inventory updateInventory(Long inventoryId, Inventory inventory) {
        Optional<Inventory> existingInventory = inventoryRepository.findById(inventoryId);
        if (existingInventory.isPresent()) {
            Inventory updatedInventory = existingInventory.get();
            updatedInventory.setBook(inventory.getBook());
            updatedInventory.setQuantity(inventory.getQuantity());
            updatedInventory.setDateAdded(inventory.getDateAdded());
            updatedInventory.setDateModified(inventory.getDateModified());
            return inventoryRepository.save(updatedInventory);
        }
        return null;
    }

    // Delete
    public void deleteInventory(Long inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }
}

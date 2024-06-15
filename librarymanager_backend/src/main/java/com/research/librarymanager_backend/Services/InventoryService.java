package com.research.librarymanager_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Exceptions.InventoryNotFoundException;
import com.research.librarymanager_backend.Models.Inventory;
import com.research.librarymanager_backend.Repositories.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    // Create Book
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Get all Inventories
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    // Get Inventory by Id
    public Inventory getInventoryById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId).orElseThrow(()->new InventoryNotFoundException("Inventory with id"+ inventoryId +"Not Found"));
    }

    // Update Inventory
    public Inventory updateInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    // Delete
    public void deleteInventory(Long inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }
}

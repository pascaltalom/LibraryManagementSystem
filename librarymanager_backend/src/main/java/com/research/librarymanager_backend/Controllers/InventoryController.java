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

import com.research.librarymanager_backend.Models.Inventory;
import com.research.librarymanager_backend.Services.InventoryService;

@RestController
@RequestMapping("/api/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAllInventories() {
        List<Inventory> inventory = inventoryService.getAllInventories();
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Inventory> getInventoryById(@PathVariable("id") Long id) {
        Inventory inventory = inventoryService.getInventoryById(id);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        Inventory newinventory  = inventoryService.createInventory(inventory);
        return new ResponseEntity<>(newinventory, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Inventory> updateInventory(@RequestBody Inventory inventory) {
        Inventory updateinventory  = inventoryService.updateInventory(inventory);
        return new ResponseEntity<>(updateinventory, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteInventory(@PathVariable("id") Long id) {
        inventoryService.deleteInventory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

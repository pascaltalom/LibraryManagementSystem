package com.research.librarymanager_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.librarymanager_backend.Models.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long>{

}

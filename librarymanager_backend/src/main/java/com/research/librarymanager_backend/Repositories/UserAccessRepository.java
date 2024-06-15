package com.research.librarymanager_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.librarymanager_backend.Models.UserAccess;

public interface UserAccessRepository  extends JpaRepository<UserAccess, Long>{

}

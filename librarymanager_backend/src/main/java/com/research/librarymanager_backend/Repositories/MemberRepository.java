package com.research.librarymanager_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.librarymanager_backend.Models.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}

package com.research.librarymanager_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Exceptions.MemberNotFoundException;
import com.research.librarymanager_backend.Models.Member;
import com.research.librarymanager_backend.Repositories.MemberRepository;

@Service
public class MemberService {

     @Autowired
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // Get all Members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get Member by Id
    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(()->new MemberNotFoundException("Member with id"+ memberId +"Not Found"));
    }

    // Create member
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // Update Member
    public Member updateMember(Member member){
        return memberRepository.save(member);
    }

    // delete Member
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}

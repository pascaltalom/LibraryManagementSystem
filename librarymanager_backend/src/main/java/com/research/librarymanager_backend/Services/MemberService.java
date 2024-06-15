package com.research.librarymanager_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Models.Member;
import com.research.librarymanager_backend.Repositories.MemberRepository;

@Service
public class MemberService {

     @Autowired
    private MemberRepository memberRepository;

    // Get all Members
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Get Member by Id
    public Member getMemberById(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member.orElse(null);
    }

    // Create member
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    // Update Member
    public Member updateMember(Long memberId, Member member) {
        Optional<Member> existingMember = memberRepository.findById(memberId);
        if (existingMember.isPresent()) {
            Member updatedMember = existingMember.get();
            updatedMember.setFirstName(member.getFirstName());
            updatedMember.setLastName(member.getLastName());
            updatedMember.setPhone(member.getPhone());
            updatedMember.setEmail(member.getEmail());
            updatedMember.setAddress(member.getAddress());
            updatedMember.setMembershipExpirationDate(member.getMembershipExpirationDate());
            return memberRepository.save(updatedMember);
        }
        return null;
    }

    // Update Member
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}

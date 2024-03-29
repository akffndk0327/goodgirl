package com.example.goodgirl.repo;

import com.example.goodgirl.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    Member findByIdAndPassword(String id, String password);
}
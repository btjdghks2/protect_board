package com.example.ItemOrderUser.repository;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}

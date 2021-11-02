package com.kh.spring.querydsl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.spring.member.Member;
import com.kh.spring.rent.Rent;

public interface QueryDSLRepository extends JpaRepository<Member, String>, QueryDSLRepositoryCustom{

}

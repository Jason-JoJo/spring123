package com.spring30.dao;

import com.spring30.model.MemberAccountJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface MemberRepository extends JpaRepository<MemberAccountJPA,Long> {

    List<MemberAccountJPA> findAll();

    List<MemberAccountJPA> findByEmail(String email);

    @Query(value = "select id,email,password,address,cellphone from member.memberaccountjpa where EMAIL = ?1 and password = ?2 ",nativeQuery = true)
    List<MemberAccountJPA> findCheckMemberAccount(String email,String password);

}

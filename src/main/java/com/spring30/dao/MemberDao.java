package com.spring30.dao;


import com.spring30.model.MemberAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addMember(MemberAccount memberAccount){
        System.out.println("Excute Insert Member !");
        jdbcTemplate.update("INSERT INTO member_account(PASSWORD,EMAIL,ADDRESS,CELLPHONE,CREATE_DATE) VALUES(?,?,?,?,NOW())",memberAccount.getPassword(),memberAccount.getEmail(),memberAccount.getAddress(),memberAccount.getCellphone());
    }
}

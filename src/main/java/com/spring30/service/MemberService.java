package com.spring30.service;

import com.spring30.dao.MemberDao;
import com.spring30.model.MemberAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    MemberDao memberDao ;
    public void addMember(MemberAccount memberAccount){
        memberDao.addMember(memberAccount);
    }

}

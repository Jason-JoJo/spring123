package com.spring30.dao;

import com.spring30.model.MemberAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberApiRepository extends JpaRepository<MemberAccount, Long> {


}

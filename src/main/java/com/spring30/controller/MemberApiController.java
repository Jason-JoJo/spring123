package com.spring30.controller;


import com.spring30.dao.MemberApiRepository;
import com.spring30.model.MemberAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/memberApi")
public class MemberApiController {
    @Autowired
    MemberApiRepository memberApiRepository ;

    @RequestMapping(value = "/{id}" , produces = {"application/json;charset=UTF-8"})
    public Optional<MemberAccount> read(@PathVariable long id){
        return memberApiRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody MemberAccount memberAccount) {
        memberApiRepository.save(memberAccount);
    }

    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody MemberAccount memberAccount){
        memberApiRepository.save(memberAccount);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        memberApiRepository.deleteById(id);
    }


//    @GetMapping("/memTest")
//    public MemberAccount memberTest(){
//        MemberAccount memberAccount = new MemberAccount();
//        memberAccount.setEmail("b1");
//        memberAccount.setPassword("123456");
//        memberAccount.setCellphone("654987");
//        memberAccount.setAddress("5204677sa");
//        return memberAccount;
//    }

}

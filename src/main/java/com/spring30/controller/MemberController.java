package com.spring30.controller;


import com.spring30.dao.MemberDao;
import com.spring30.dao.MemberRepository;
import com.spring30.model.MemberAccount;
import com.spring30.model.MemberAccountJPA;
import com.spring30.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberAccount memberAccount ;

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    DataSource dataSource;

    public String addMemberPage(){
        List<MemberAccountJPA> memberAccountJPAList = new ArrayList<MemberAccountJPA>();
        memberAccountJPAList=memberRepository.findAll();

        for(int i=0;i<memberAccountJPAList.size();i++){
            System.out.println(memberAccountJPAList.get(i).getId());
        }
        return "addMemberPage";
    }



    @GetMapping("/add")
    public String addOne(){
//        memberAccount =new MemberAccount();
//        memberAccount.setPassword("123456");
//        memberAccount.setAddress("Taipei");
//        memberAccount.setCellphone("0987321456");
//        memberAccount.setEmail("abc@edf.com");
//        memberService.addMember(memberAccount);

        return "addMemberPage";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute MemberAccountJPA memberAccountJPA){
        System.out.println("in login");
        return "login";
    }

    @GetMapping("/upload")
    public String upload(@ModelAttribute MemberAccountJPA memberAccountJPA){
        System.out.println("in upload");
        return "uploadFile";
    }

    @PostMapping("/dologin")
    public String dologin (@ModelAttribute MemberAccountJPA memberAccountJPA, HttpSession httpSession, Model model) {
        System.out.println("in dologin");
        String email = memberAccountJPA.getEmail();
        String password = memberAccountJPA.getPassword();
        List<MemberAccountJPA>  memberAccountJPAList= memberRepository.findCheckMemberAccount(email,password);
        MemberAccountJPA memberAccountJPA1 =new MemberAccountJPA();
        memberAccountJPA1.setEmail(email);
        memberAccountJPA1.setPassword(password);
        if(memberAccountJPAList.size()==0){
            System.out.println("in memberAccountJPAList = 0");
            return "login";
        }else{
            System.out.println("in memberAccountJPAList != 0");
            httpSession.setAttribute("uid",memberAccountJPA1);
            httpSession.setAttribute("id",httpSession.getId());
            model.addAttribute("memberAccountJPA",memberAccountJPA1);
            System.out.println(httpSession.getId());
            return "wellcome";
        }

//        httpSession.setAttribute("uid",memberAccount);

        //登出清除session
//        if(httpSession.getAttribute("uid") != null){
//            httpSession.removeAttribute("uid");
//        }

//        System.out.println(memberRepository.findCheckMemberAccount(memberAccountJPA.getEmail(),memberAccountJPA.getPassword()));
//
//        return "wellcome";
    }
}

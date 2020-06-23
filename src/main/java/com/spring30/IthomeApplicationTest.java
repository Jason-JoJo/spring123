package com.spring30;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring30.dao.MemberApiRepository;
import com.spring30.model.MemberAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = IthomeApplicationTest.class)
@WebAppConfiguration
public class IthomeApplicationTest {

    @Autowired
    private MemberApiRepository memberApiRepository;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    ObjectMapper objectMapper;
    MockMvc mockMvc;

    MemberAccount memberAccount ;

    @Before
    public void setup(){
        MemberAccount memberAccount = new MemberAccount();
//        memberAccount.setId(3);
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();


        memberAccount = new MemberAccount();
        memberAccount.setCellphone("02135121");
        memberAccount.setEmail("qewq@qwe.asd.s");
        memberAccount.setPassword("qweqqq");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void contextLoads() throws Exception{
        String uri = "/memberApi/5";
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();
//        int status = result.getResponse().getStatus();
//        System.out.println(status);
//        Assert.assertEquals("Error",200,status);


        try{

            MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(uri).content(objectMapper.writeValueAsString(memberAccount)).accept(MediaType.APPLICATION_JSON)).andReturn();
            int status = result.getResponse().getStatus();
            Assert.assertEquals("錯誤",200,status);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

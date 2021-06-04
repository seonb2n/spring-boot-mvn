package me.seonbin.demospringmvc;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleTemplateController.class)
public class SampleTemplateControllerTest extends TestCase {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void template() throws Exception{
        //요청 "/"
        //응답 모델 name : seonbin
        //응답 view 이름 : template
        mockMvc.perform(get("/template"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("template"))
                .andExpect(model().attribute("name", is("seonbin")))
                .andExpect(content().string(containsString("seonbin")));
        //모델에 들어있는 String 을 확인하도록 함.
    }
}
package me.seonbin.demospringmvc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Autowired
    WebClient webClient;

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

    @Test
    public void cleintTest() throws Exception {
        HtmlPage page = webClient.getPage("/template");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");
        assertThat(h1.getTextContent()).isEqualToIgnoringCase("seonbin");

    }


}
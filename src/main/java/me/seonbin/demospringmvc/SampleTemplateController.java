package me.seonbin.demospringmvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleTemplateController {

    @GetMapping("/template")
    public String template(Model model) {
        //화면에 전달하는 데이터는 model 의 형태로 전달된다.
        //return 값은 뷰의 이름
        model.addAttribute("name","seonbin");
        return "template";
    }


}

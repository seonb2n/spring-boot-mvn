package me.seonbin.demospringmvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleTemplateController {

    @GetMapping("/template")
    public String template(Model model) {
        //화면에 전달하는 데이터는 model 의 형태로 전달된다.
        //return 값은 뷰의 이름
        model.addAttribute("name","seonbin");
        return "template";
    }

    @GetMapping("/error")
    public String error() {
        throw new SampleException();
    }

    //Exception 이 발생하고, Exception handler 로 아래 거가 사용됨됨
   @ExceptionHandler(SampleException.class)
    public @ResponseBody AppError sampleError(SampleException e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("Idont know");
        return appError;
    }



}

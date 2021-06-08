package me.seonbin.demospringmvc;

import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class SampleHateoasController {

    @GetMapping("/hateoas")
    public Resource<Hateoas> hateoas() {

        Hateoas hateoas = new Hateoas();
        hateoas.setPrefix("Hey,");
        hateoas.setName("seonbin");

        //링크 정보를 추가하는 방법
        Resource<Hateoas> hateoasResource = new Resource<>(hateoas);
        hateoasResource.add(linkTo(methodOn(SampleHateoasController.class).hateoas()).withSelfRel());

        return hateoasResource;
    }
}

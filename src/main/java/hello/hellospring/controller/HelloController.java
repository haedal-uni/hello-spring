package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) { // MVC 모델의 Model
        model.addAttribute("data", "hello!");
        return "hello"; // hello.html
    }
}

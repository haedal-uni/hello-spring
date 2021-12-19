package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) { // MVC 모델의 Model
        model.addAttribute("data", "hello!");
        return "hello"; // hello.html
    }


    @GetMapping("hello-mvc")// ?name=spring
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }


    // VIEW 이런게 없고 문자 자체가 그대로 내려간다.
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello spring"
    }


    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // return 값으로 문자가 아닌 객체
    }

    static class Hello{
        private String name; // key : name

        // Getter & Setter -> alt + ins(단축키)
        public String getName() { // 꺼낼 때
            return name;
        }

        public void setName(String name) { // 넣을 때
            this.name = name;
        }
    }
}

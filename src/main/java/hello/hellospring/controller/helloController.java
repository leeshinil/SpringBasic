package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class helloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!"); // 화면과 매핑되는 데이터
        return "hello";// 기본적으로 resouces/templates 밑에 폴더를 찾는다.
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = true) String name, Model model) { // required default는 true, false일 경우 파라미터 필요없다.
        model.addAttribute("name", name);
        System.out.println("Test");
        return "hello-template";
    }

}

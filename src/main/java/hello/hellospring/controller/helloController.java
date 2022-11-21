package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!"); // 화면과 매핑되는 데이터
        return "hello";// 기본적으로 resouces/templates 밑에 폴더를 찾는다.
    }

    // viewㄱResolver가 동
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = true) String name, Model model) { // required default는 true, false일 경우 파라미터 필요없다.
        model.addAttribute("name", name);
        System.out.println("Test");
        return "hello-template";
    }


    // api 방식
    @GetMapping("hello-string")
    @ResponseBody //응답 바디 부분에 직접 넣어준다.
    public String helloString(@RequestParam("name") String name) {
        return "hellp " + name;
    }

    // json 방식(객체가 넘어올시)
    // HttpMessageConverter가 동작작
    // jackson or gson 객체 처리
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

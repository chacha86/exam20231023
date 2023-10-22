package com.korea.basic1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @RequestMapping("/")
    public String main(Model model) {
        List<Blog> blogList = blogRepository.findAll();
        model.addAttribute("blogList", blogList); // model은 request scope
        return "main";
    }

    @RequestMapping("/add")
    public String view() {
        Blog blog = Blog.builder().title("제목")
                .content("내용")
                .build();

        blogRepository.save(blog);

        return "redirect:/";
    }
}

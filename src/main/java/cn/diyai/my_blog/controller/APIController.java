package cn.diyai.my_blog.controller;

import cn.diyai.my_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/api")
public class APIController {

    @Autowired
    BlogService blogService;
    static HashMap<String, String> items = new HashMap<>();

    static {
        items.put("jvm", "jvm");
        items.put("springboot", "springboot");
        items.put("springmvc", "springmvc");
        items.put("springcloud", "springcloud");
        items.put("android", "android");
        items.put("ios", "ios");
        items.put("mysql", "mysql");
    }

    @RequestMapping("/{topic}")
    public String listBlogsByOrder(@PathVariable("topic") String topic, Model model) {
        if (items.containsKey(topic)) {
            model.addAttribute("blogs", blogService.getBlogsByKeyTopic(topic));
            return "/blogs/list::blog_list";
        }

        return "/blogs/list";


    }
}

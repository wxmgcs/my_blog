package cn.diyai.my_blog.controller;

import cn.diyai.my_blog.domain.Blog;
import cn.diyai.my_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/api")
public class APIController {

    @Autowired
    BlogService blogService;

    @RequestMapping("/{topic}")
    public String listBlogsByTopic(@PathVariable("topic") String topic, Model model) {
        model.addAttribute("blogs", blogService.getBlogsByTopic(topic));
        return "/blogs/list::blog_list";
    }

    @RequestMapping("/{topic}/{keyword}")
    public String listBlogsLike(@PathVariable("topic") String topic,
                                @PathVariable("keyword") String keyword,
                                Model model) {
//            model.addAttribute("blogs", blogService.getBlogsByTopicLikeKeyword(topic, keyword));
        List<Blog> blogs = (List<Blog>) blogService.getBlogsByKeyWord("%" + keyword + "%");
        model.addAttribute("blogs", blogs);
        return "/blogs/list::blog_list";
    }


    @PostMapping("/add")
    public String addBlog(@RequestParam("topic") String topic,
                          @RequestParam("title") String title,
                          @RequestParam("content") String content,
                          @RequestParam("htmlContent") String htmlContent) {
        blogService.add(topic, title, content, htmlContent);
        return "添加成功";
    }


}

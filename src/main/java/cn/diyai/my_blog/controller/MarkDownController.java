package cn.diyai.my_blog.controller;

import cn.diyai.my_blog.service.MarkdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/md")
public class MarkDownController {
    @Autowired
    private MarkdownService service;

    @RequestMapping(value = "/parse", method = RequestMethod.POST)
    public String parseMarkDown(Model model, @RequestParam("md") String markdownText) {
        model.addAttribute("md", service.parseMarkdownString(markdownText));
        return "/md/test";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("inputName", "md");
        return "/md/index";
    }
}

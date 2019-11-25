package cn.diyai.my_blog.controller;

import cn.diyai.my_blog.domain.Blog;
import cn.diyai.my_blog.domain.Topic;
import cn.diyai.my_blog.service.BlogService;
import cn.diyai.my_blog.service.TopicService;
import cn.diyai.my_blog.util.ConstraintViolationExceptionHandler;
import cn.diyai.my_blog.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * Blog 控制器.
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
	TopicService topicService;

    static HashMap<String, String> items = new HashMap<>();

    static {
        items.put("jvm", "jvm");
        items.put("springboot", "springboot");
        items.put("springmvc", "springmvc");
        items.put("springcloud", "springcloud");
        items.put("android", "android");
        items.put("ios", "ios");
        items.put("products", "products");
        items.put("about_me", "about_me");
    }

    @GetMapping("/list")
    public String listBlogsByOrder(
            @RequestParam(value = "order", required = false, defaultValue = "new") String order,
            @RequestParam(value = "category", required = false) Long category,
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model) {

        List<Blog> blogs = new ArrayList<>();

        Page<Blog> page = new Page<Blog>() {
            @Override
            public int getTotalPages() {
                return 1;
            }

            @Override
            public long getTotalElements() {
                return blogs.size();
            }

            @Override
            public <U> Page<U> map(Function<? super Blog, ? extends U> function) {
                return null;
            }

            @Override
            public int getNumber() {
                return 0;
            }

            @Override
            public int getSize() {
                return 0;
            }

            @Override
            public int getNumberOfElements() {
                return 0;
            }

            @Override
            public List<Blog> getContent() {
                return null;
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public boolean isFirst() {
                return false;
            }

            @Override
            public boolean isLast() {
                return false;
            }

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Pageable nextPageable() {
                return null;
            }

            @Override
            public Pageable previousPageable() {
                return null;
            }

            @Override
            public Iterator<Blog> iterator() {
                return null;
            }
        };
        model.addAttribute("page", page);
        // 如果有指定的专题的内容
        if (items.containsKey(keyword)) {
            model.addAttribute("topics",topicService.findAll());
            model.addAttribute("blogs", blogService.getBlogsByTopic(keyword));
            return "/blogs/list";
        }

        return "/blogs/list";
    }

    @GetMapping("/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id, Model model) {
        Blog blog = blogService.getBlogById(id);
        model.addAttribute("topics",topicService.findAll());
        model.addAttribute("blogModel", blog);
        System.out.println("blogId:" + id);
        return "/blogs/detail";
    }

	/**
	 * 获取新增博客的界面
	 * @param model
	 * @return
	 */
	@GetMapping("/edit")
	public ModelAndView createBlog(Model model) {
		// 获取用户分类列表

		List<Topic> topics = topicService.findAll();

		model.addAttribute("topics", topics);
		model.addAttribute("fileServerUrl", null);// 文件服务器的地址返回给客户端
		model.addAttribute("blog", new Blog(null,null, null, null));
		return new ModelAndView("/blogs/edit", "blogModel", model);
	}

    @PostMapping("/edit")
    public ResponseEntity<Response> saveBlog(@RequestBody Blog blog) {
        // 对 Catalog 进行空处理
//		if (blog.getCatalog().getId() == null) {
//			return ResponseEntity.ok().body(new Response(false,"未选择分类"));
//		}
		Blog newBlog = null;
        try {

            // 判断是修改还是新增
            if (blog.getId() == null) {
				newBlog = new Blog();
				newBlog.setTitle(blog.getTitle());
				// 内部会转码
				newBlog.setContent(blog.getContent());
				newBlog.setSummary(blog.getSummary());
				newBlog.setTopic(blog.getTopic());
				newBlog.setTags(blog.getTags());
                blogService.add(newBlog);
            }

        } catch (ConstraintViolationException e) {
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        } catch (Exception e) {
            return ResponseEntity.ok().body(new Response(false, e.getMessage()));
        }

        String redirectUrl = "/blogs/" + newBlog.getId();
        return ResponseEntity.ok().body(new Response(true, "处理成功", redirectUrl));
    }

}

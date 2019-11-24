package cn.diyai.my_blog.controller;

import cn.diyai.my_blog.domain.Blog;
import cn.diyai.my_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	static HashMap<String,String> items = new HashMap<>();
	static {
		items.put("jvm","jvm");
		items.put("springboot","springboot");
		items.put("springmvc","springmvc");
		items.put("springcloud","springcloud");
		items.put("android","android");
		items.put("ios","ios");
		items.put("products","products");
		items.put("about_me","about_me");
	}

	@GetMapping("/list")
	public String listBlogsByOrder(
			@RequestParam(value="order",required=false,defaultValue="new") String order,
			@RequestParam(value="category",required=false ) Long category,
			@RequestParam(value="keyword",required=false ) String keyword,
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
		if(items.containsKey(keyword)){
			model.addAttribute("blogs", blogService.getBlogsByKeyTopic(keyword));
			return "/blogs/list";
		}

		return "/blogs/list";
	}

	@GetMapping("/{id}")
	public String listBlogsByOrder(@PathVariable("id") Long id, Model model) {
		Blog blog = blogService.getBlogById(id);

		model.addAttribute("blogModel",blog);
		System.out.println("blogId:" + id);
		return "/blogs/detail";
	}

	@GetMapping("/edit")
	public String editBlog() {
		return "/blogs/edit";
	}

}

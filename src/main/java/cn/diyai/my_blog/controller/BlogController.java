package cn.diyai.my_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Blog 控制器.
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
	
//	@GetMapping
//	public String listBlogs(@RequestParam(value="order",required=false,defaultValue="new") String order,
//			@RequestParam(value="keyword",required=false,defaultValue="" ) String keyword){
//		System.out.println("order:" +order + ";keyword:" +keyword );
////		return "redirect:/index?order="+order+"&keyword="+keyword;
//		return "/blogs/index";
//	}

//	@GetMapping("/{username}")
//	public String userSpace(@PathVariable("username") String username) {
//		System.out.println("username" + username);
//		return "/userspace/u";
//	}

	@GetMapping()
	public String listBlogsByOrder(
			@RequestParam(value="order",required=false,defaultValue="new") String order,
			@RequestParam(value="category",required=false ) Long category,
			@RequestParam(value="keyword",required=false ) String keyword) {

		// 跳转到关于我
		if("about_me".equals(order)){
			return "/me/about";
		}

		// 跳转到作品集
		if("products".equals(order)){
			return "/me/products";
		}

		if (category != null) {

			System.out.println("category:" +category );
			System.out.println("selflink:" + "redirect:/blogs?category="+category);
			return "/blogs/index";

		} else if (keyword != null && keyword.isEmpty() == false) {

			System.out.println("keyword:" +keyword );
			System.out.println("selflink:" + "redirect:/blogs?keyword="+keyword);
			return "/blogs/index";
		}

		System.out.println("order:" +order);
		System.out.println("selflink:" + "redirect:/blogs?order="+order);
		return "/blogs/index";
	}

	@GetMapping("/{id}")
	public String listBlogsByOrder(@PathVariable("id") Long id) {

		System.out.println("blogId:" + id);
		return "/blogs/blog";
	}

	@GetMapping("/edit")
	public String editBlog() {

		return "/blogs/edit";
	}

}

package cn.diyai.my_blog.service.impl;

import cn.diyai.my_blog.domain.Blog;
import cn.diyai.my_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Blog 服务.
 * 
 * @since 1.0.0 2017年4月7日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Override
	public Blog getBlogById(Long id) {
		return new Blog(id,"标题","关键词","详细内容",new Timestamp(System.currentTimeMillis()));
	}

	@Override
	public List<Blog> getBlogsByKeyTopic(String topic) {
		List<Blog> blogs = new ArrayList<>();
		blogs.add(new Blog(1L,topic+"标题1","概述1","详细内容1",new Timestamp(System.currentTimeMillis())));
		blogs.add(new Blog(2L,topic+"标题2","概述2","详细内容2",new Timestamp(System.currentTimeMillis())));
		blogs.add(new Blog(3L,topic+"标题3","概述3","详细内容3",new Timestamp(System.currentTimeMillis())));
		return blogs;
	}


}

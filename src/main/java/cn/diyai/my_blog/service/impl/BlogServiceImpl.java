package cn.diyai.my_blog.service.impl;

import cn.diyai.my_blog.domain.Blog;
import cn.diyai.my_blog.repository.BlogRepository;
import cn.diyai.my_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Blog 服务.
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog getBlogById(Long id) {
        Optional<Blog> optionalBlog = blogRepository.findById(id);
        if (optionalBlog.isPresent()) {
            return optionalBlog.get();
        }
        return null;
    }

    @Override
    public List<Blog> getBlogsByTopic(String topic) {
        List<Blog> blogs;
        blogs = blogRepository.findBlogByTopic(topic);
        return blogs;
    }

    /**
     * 根据主题，模糊查询
     *
     * @param topic
     * @param keyword
     * @return
     */
    @Override
    public Object getBlogsByTopicLikeKeyword(String topic, String keyword) {
        List<Blog> blogs = blogRepository.findBlogByTopicAndContentLike(topic, keyword);
        return blogs;
    }

    @Override
    public void add(String topic, String title,String content, String htmlContent) {
        Blog blog = new Blog(topic, title,content, htmlContent);
        blogRepository.save(blog);
    }

    @Override
    public Blog add(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Object getBlogsByKeyWord(String keyword) {
        return blogRepository.findBlogsByContentLike(keyword);
    }


}

package cn.diyai.my_blog.repository;

import cn.diyai.my_blog.domain.Blog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * User Repository 接口.
 * 
 */
public interface BlogRepository extends CrudRepository<Blog, Long>{

    /**
     * 根据专题查询
     * @param topic
     * @return
     */
    List<Blog> findBlogByTopic(String topic);

    /**
     * 根据标签查询
     * @param tags
     * @return
     */
    List<Blog> findBlogByTags(String tags);

    /**
     * 根据标签和关键字模糊查询
     * @param tags
     * @param htmlContent
     * @return
     */
    List<Blog> findBlogByTagsAndHtmlContentLike(String tags,String htmlContent);

    /**
     * 根据专题和关键字模糊查询
     * @param topic
     * @param searchText
     * @return
     */
    List<Blog> findBlogByTopicAndContentLike(String topic,String searchText);


    /**
     * 根据关键字模糊查询
     * @param searchText
     * @return
     */
    List<Blog> findBlogsByContentLike(String searchText);
}

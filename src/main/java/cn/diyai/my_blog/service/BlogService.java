package cn.diyai.my_blog.service;

import cn.diyai.my_blog.domain.Blog;

import java.util.List;

/**
 * Blog 服务接口.
 * 
 */
public interface BlogService {
//	/**
//	 * 保存Blog
//	 * @return
//	 */
//	Blog saveBlog(Blog blog);
//
//	/**
//	 * 删除Blog
//	 * @param id
//	 * @return
//	 */
//	void removeBlog(Long id);
//
	/**
	 * 根据id获取Blog
	 * @param id
	 * @return
	 */
	Blog getBlogById(Long id);

    List<Blog> getBlogsByKeyTopic(String topic);

//	/**
//	 * 根据用户进行博客名称分页模糊查询（最新）
//	 * @param user
//	 * @return
//	 */
//	Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable);
//
//	/**
//	 * 根据用户进行博客名称分页模糊查询（最热）
//	 * @param user
//	 * @return
//	 */
//	Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable);

}

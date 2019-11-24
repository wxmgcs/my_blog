package cn.diyai.my_blog.repository;

import cn.diyai.my_blog.domain.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Topic Repository 接口.
 * 
 */
public interface TopicRepository extends CrudRepository<Topic, Long>{

}

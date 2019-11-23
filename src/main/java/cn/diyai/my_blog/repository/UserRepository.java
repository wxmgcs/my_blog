package cn.diyai.my_blog.repository;

import cn.diyai.my_blog.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User Repository 接口.
 * 
 */
public interface UserRepository extends CrudRepository<User, Long>{
}

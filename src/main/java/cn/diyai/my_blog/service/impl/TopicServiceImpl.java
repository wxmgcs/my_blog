package cn.diyai.my_blog.service.impl;


import cn.diyai.my_blog.domain.Topic;
import cn.diyai.my_blog.repository.TopicRepository;
import cn.diyai.my_blog.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;

    @Override
    public List<Topic> findAll() {
        return (List<Topic>) topicRepository.findAll();
    }
}

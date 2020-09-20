package com.zhengj.service;

import com.zhengj.dao.BoardMapper;
import com.zhengj.model.Board;
import com.zhengj.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService extends AbstractService<Board> {

    @Autowired
    private BoardMapper boardMapper;

    public List<Topic> getTopicsByUser(long userId) {
        return this.boardMapper.getTopicByUserId(userId);
    }
}

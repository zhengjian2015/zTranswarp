package com.zhengj.dao;

import com.zhengj.model.Board;
import com.zhengj.model.Topic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper extends tk.mybatis.mapper.common.Mapper<Board> {

    List<Topic> getTopicByUserId(@Param("userId") Long userId);
}

package com.zhengj.dao;

import com.zhengj.model.Attachment;
import com.zhengj.model.Resource;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AttachmentMapper extends tk.mybatis.mapper.common.Mapper<Attachment> {

    Resource getResourceById(Long id);
}

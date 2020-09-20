package com.zhengj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EntityMapper {

    int updateEntityTableOrderById(@Param("tableId") String tableId,
                                   @Param("order") Long order,
                                   @Param("id") Long id);
}

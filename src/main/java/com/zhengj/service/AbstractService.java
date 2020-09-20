package com.zhengj.service;

import com.zhengj.common.ApiException;
import com.zhengj.dao.EntityMapper;
import com.zhengj.enums.ApiError;
import com.zhengj.model.AbstractEntity;
import com.zhengj.model.AbstractSortableEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractService<T extends AbstractEntity> {

    private static Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

    @Autowired
    private EntityMapper entityMapper;

    protected void sortEntities(String table,List<? extends AbstractSortableEntity> entities, List<Long> ids) {
        entities.forEach(entity -> {
            int n = ids.indexOf(entity.getId());
            if (n == (-1)) {
                throw new ApiException(ApiError.PARAMETER_INVALID, "ids", "Invalid category ids.");
            }
            entity.setDisplayOrder(Long.valueOf(n));
        });
        entities.forEach(entity -> {
            LOGGER.info("table name is:{}",entity.getClass().getName());
            this.entityMapper.updateEntityTableOrderById(table, entity.getDisplayOrder(),entity.getId());
        });
    }
}

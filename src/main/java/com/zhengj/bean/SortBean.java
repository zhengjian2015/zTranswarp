package com.zhengj.bean;

import com.zhengj.common.ApiException;
import com.zhengj.enums.ApiError;

import java.util.List;

public class SortBean extends AbstractRequestBean {

    public List<Long> ids;

    @Override
    public void validate(boolean createMode) {
        if (ids == null || ids.isEmpty()) {
            throw new ApiException(ApiError.PARAMETER_INVALID, "ids", "Invalid id list.");
        }
        for (Long id : ids) {
            if (id == null || id <= 0) {
                throw new ApiException(ApiError.PARAMETER_INVALID, "ids", "Invalid id list.");
            }
        }
    }
}

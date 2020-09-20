package com.zhengj.bean;

import com.zhengj.common.ApiException;
import com.zhengj.enums.ApiError;
import com.zhengj.model.AbstractEntity;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractRequestBean {

    private static final Pattern PATTERN_TAG = Pattern.compile("^[^\\,\\;]{1," + AbstractEntity.VAR_ENUM + "}$");

    public abstract void validate(boolean createMode);

    protected String checkName(String value) {
        return checkString("name", AbstractEntity.VAR_CHAR_NAME, value);
    }

    protected String checkDescription(String value) {
        return checkString("description", AbstractEntity.VAR_CHAR_DESCRIPTION, value);
    }

    protected String checkTag(String value) {
        if (value == null) {
            return "";
        }
        Matcher matcher = PATTERN_TAG.matcher(value);
        if (!matcher.matches()) {
            throw new ApiException(ApiError.PARAMETER_INVALID, "tag", "Invalid tag.");
        }
        return checkString("tag", AbstractEntity.VAR_ENUM, value);
    }

    private String checkString(String paramName, int maxLength, String s) {
        if (s == null) {
            throw new ApiException(ApiError.PARAMETER_INVALID, paramName,
                    "Parameter " + paramName + " must not be null.");
        }
        s = StringUtils.trimAllWhitespace(s);
        if (s.isEmpty()) {
            throw new ApiException(ApiError.PARAMETER_INVALID, paramName,
                    "Parameter " + paramName + " must not be emtpy.");
        }
        if (s.length() > maxLength) {
            throw new ApiException(ApiError.PARAMETER_INVALID, paramName, "Parameter " + paramName + " is too long.");
        }
        return s;
    }
}

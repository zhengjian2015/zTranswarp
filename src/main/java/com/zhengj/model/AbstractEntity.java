package com.zhengj.model;

import com.zhengj.bean.AbstractBean;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public abstract class AbstractEntity extends AbstractBean {

    public static final int VAR_ENUM = 32;

    public static final int VAR_CHAR_DATE = 10;

    public static final int VAR_CHAR_HASH = 64;

    public static final int VAR_CHAR_EMAIL = 100;

    public static final int VAR_CHAR_TAGS = 100;

    public static final int VAR_CHAR_NAME = 100;

    public static final int VAR_CHAR_MIME = 100;

    public static final int VAR_CHAR_AUTH_ID = 255;

    public static final int VAR_CHAR_AUTH_TOKEN = 255;

    public static final int VAR_CHAR_DESCRIPTION = 1000;

    public static final int VAR_CHAR_URL = 1000;

    public static final int VAR_CHAR_SVG = 8192; // 8K

    public static final int TEXT = 65535; // 64K

    public static final int MEDIUM_TEXT = 524287; // 512K

    @Id
    @Column(nullable = false, updatable = false)
    private long id;

    @Column(nullable = false, updatable = false)
    private long createdAt;

    @Column(nullable = false)
    private long updatedAt;

    @Column(nullable = false)
    private long version;

}

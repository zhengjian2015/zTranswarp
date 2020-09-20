package com.zhengj.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "attachments")
@Data
public class Attachment extends AbstractEntity {

    @Column(nullable = false, updatable = false)
    private long userId;

    @Column(nullable = false, updatable = false)
    private long resourceId;

    @Column(nullable = false, updatable = false)
    private long size;

    @Column(nullable = false, updatable = false)
    private int width;

    @Column(nullable = false, updatable = false)
    private int height;

    @Column(nullable = false, updatable = false, length = VAR_CHAR_NAME)
    private String name;

    @Column(nullable = false, updatable = false, length = VAR_CHAR_MIME)
    private String mime;
}

package com.zhengj.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "articles")
public class Article extends AbstractEntity {
    @Column(nullable = false, updatable = false)
    private Long userId;

    @Column(nullable = false)
    private Long categoryId;

    /**
     * Reference to attachment id.
     */
    @Column(nullable = false)
    private Long imageId;

    @Column(nullable = false)
    private Long textId;

    @Column(nullable = false)
    private Long views;

    @Column(nullable = false, length = VAR_CHAR_TAGS)
    private String tags;

    @Column(nullable = false, length = VAR_CHAR_NAME)
    private String name;

    @Column(nullable = false, length = VAR_CHAR_DESCRIPTION)
    private String description;

    @Column(nullable = false)
    private Long publishAt;
}

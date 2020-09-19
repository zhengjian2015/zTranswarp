package com.zhengj.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "categories")
@Data
public class Category extends AbstractSortableEntity {
    @Column(nullable = false, length = VAR_CHAR_NAME)
    private String name;

    @Column(nullable = false, length = VAR_ENUM)
    private String tag;

    @Column(nullable = false, length = VAR_CHAR_DESCRIPTION)
    private String description;

}

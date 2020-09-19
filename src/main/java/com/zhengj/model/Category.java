package com.zhengj.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "categories")
public class Category extends AbstractSortableEntity {
    @Column(nullable = false, length = VAR_CHAR_NAME)
    private String name;

    @Column(nullable = false, length = VAR_ENUM)
    private String tag;

    @Column(nullable = false, length = VAR_CHAR_DESCRIPTION)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.zhengj.model;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "boards")
public class Board extends AbstractSortableEntity {
    @Column(nullable = false)
    private long topicNumber;

    @Column(nullable = false)
    private boolean locked;

    @Column(nullable = false, length = VAR_ENUM)
    private String tag;

    @Column(nullable = false, length = VAR_CHAR_NAME)
    private String name;

    @Column(nullable = false, length = VAR_CHAR_DESCRIPTION)
    private String description;

}

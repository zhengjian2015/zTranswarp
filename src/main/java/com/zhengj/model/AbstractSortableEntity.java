package com.zhengj.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
public abstract class AbstractSortableEntity extends AbstractEntity {

    @Column(nullable = false)
    private Long displayOrder;

}

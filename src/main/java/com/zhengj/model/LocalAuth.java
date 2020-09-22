package com.zhengj.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "local_auths")
@Data
public class LocalAuth  extends AbstractEntity {
    @Column(nullable = false, updatable = false)
    private long userId;

    @Column(nullable = false, updatable = false, length = VAR_CHAR_HASH)
    private String passwd;

    @Column(nullable = false, updatable = false, length = VAR_CHAR_HASH)
    private String salt;

}

package com.zhengj.model;

import com.zhengj.enums.Role;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "users")
@Data
public class User extends AbstractEntity {

    @Column(nullable = false, length = VAR_ENUM)
    private Role role;

    @Column(nullable = false, updatable = false, length = VAR_CHAR_EMAIL)
    private String email;

    @Column(nullable = false, length = VAR_CHAR_NAME)
    private String name;

    @Column(nullable = false, length = VAR_CHAR_URL)
    private String imageUrl;

    @Column(nullable = false)
    private long lockedUntil;

    @Override
    public String toString() {
        return String.format("{User: id=%s, role=%s, email=%s, name=%s, locakedUntil=%s}", this.getId(), this.role,
                this.email, this.name, this.lockedUntil);
    }
}

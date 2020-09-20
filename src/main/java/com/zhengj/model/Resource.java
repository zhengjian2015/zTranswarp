package com.zhengj.model;

import com.zhengj.common.ApiException;
import com.zhengj.enums.ApiError;
import com.zhengj.enums.ResourceEncoding;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Base64;

@Table(name = "resources")
@Data
public class Resource extends AbstractEntity {

    /**
     * Hash of the binary data.
     */
    @Column(nullable = false, updatable = false, length = VAR_CHAR_HASH)
    private String hash;

    /**
     * Content encoding. e.g. "BASE64".
     */
    @Column(nullable = false, updatable = false, length = VAR_ENUM)
    private ResourceEncoding encoding;

    @Column(nullable = false, updatable = false, columnDefinition = "MEDIUMTEXT")
    private String content;

    public byte[] decode() {
        if (encoding == ResourceEncoding.BASE64) {
            return Base64.getDecoder().decode(this.content);
        }
        throw new ApiException(ApiError.OPERATION_FAILED, null, "Could not decode content data.");
    }
}

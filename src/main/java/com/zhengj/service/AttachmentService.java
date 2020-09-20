package com.zhengj.service;

import com.zhengj.bean.DownloadBean;
import com.zhengj.common.ApiException;
import com.zhengj.dao.AttachmentMapper;
import com.zhengj.enums.ApiError;
import com.zhengj.model.Attachment;
import com.zhengj.model.Resource;
import com.zhengj.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Component
public class AttachmentService extends AbstractService<Attachment> {

    @Autowired
    private AttachmentMapper attachmentMapper;

    public DownloadBean downloadAttachment(Long id, char size) {
        if ("0sml".indexOf(size) == (-1)) {
            throw new ApiException(ApiError.PARAMETER_INVALID, "size", "Invalid size.");
        }
        Attachment a = this.attachmentMapper.selectByPrimaryKey(id);
        Resource r = this.attachmentMapper.getResourceById(a.getResourceId());
        if (r == null) {
            throw new ApiException(ApiError.PARAMETER_INVALID, "id", "Resource not found.");
        }
        if (size == '0') {
            return new DownloadBean(a.getMime(), r.decode());
        }
        int originWidth = a.getWidth();
        int targetWidth = originWidth;
        boolean resize = false;
        if (size == 's') {
            if (originWidth > 160) {
                targetWidth = 160;
                resize = true;
            }
        } else if (size == 'm') {
            if (originWidth > 320) {
                targetWidth = 320;
                resize = true;
            }
        } else if (size == 'l') {
            if (originWidth > 640) {
                targetWidth = 640;
                resize = true;
            }
        }
        if (!resize) {
            return new DownloadBean(a.getMime(), r.decode());
        }
        BufferedImage resizedImage = null;
        try (InputStream input = new ByteArrayInputStream(r.decode())) {
            BufferedImage originImage = ImageIO.read(input);
            resizedImage = ImageUtil.resizeKeepRatio(originImage, targetWidth);
        } catch (IOException e) {
            throw new ApiException(ApiError.OPERATION_FAILED, null, "Could not resize image.");
        }
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            ImageIO.write(resizedImage, "jpeg", output);
            return new DownloadBean("image/jpeg", output.toByteArray());
        } catch (IOException e) {
            throw new ApiException(ApiError.OPERATION_FAILED, null, "Could not resize image.");
        }
    }
}

package com.zhengj.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {



    public static BufferedImage resizeKeepRatio(BufferedImage input, int expectedWidth) {
        int originalWidth = input.getWidth();
        int originalHeight = input.getHeight();
        if (originalWidth <= expectedWidth) {
            return input;
        }
        int expectedHeight = originalHeight * expectedWidth / originalWidth;
        if (expectedHeight < 10) {
            expectedHeight = 10;
        }
        BufferedImage output = new BufferedImage(expectedWidth, expectedHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = output.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(input, 0, 0, expectedWidth, expectedHeight, null);
        g2.dispose();
        return output;
    }

}

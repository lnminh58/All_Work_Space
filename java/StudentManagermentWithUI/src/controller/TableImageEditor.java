/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import javax.imageio.ImageIO;

/**
 *
 * @author nguyenducthao
 */
public class TableImageEditor {

    static final int FIT = 0,
            FILL = 1;

    public static BufferedImage[] loadImages(Vector<String> vFileNameAvatar) {
        String[] fileNames = vFileNameAvatar.toArray(new String[vFileNameAvatar.size()]);
//        String[] fileNames = {
//            "/temp/admin_avatar.jpg", "/temp/admin2_avatar.jpg", "/temp/admin3_avatar.jpg", "/test/user1.jpg"
//        };
        BufferedImage[] images = new BufferedImage[fileNames.length];
        for (int j = 0; j < images.length; j++) {
            try {
                URL url = TableImageEditor.class.getResource(fileNames[j]);
                images[j] = ImageIO.read(url);
            } catch (MalformedURLException mue) {
                System.err.println("url: " + mue.getMessage());
            } catch (IOException ioe) {
                System.err.println("read: " + ioe.getMessage());
            }
        }
        return images;
    }

    public static BufferedImage[] getScaledImages(BufferedImage[] in, int type) {
        int WIDTH = 100;
        int HEIGHT = 100;
        BufferedImage[] out = new BufferedImage[in.length];
        for (int j = 0; j < out.length; j++) {
            out[j] = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = out[j].createGraphics();
            g2.setColor(Color.white);
            g2.fillRect(0, 0, WIDTH, HEIGHT);
            double width = in[j].getWidth();
            double height = in[j].getHeight();
            double xScale = WIDTH / width;
            double yScale = HEIGHT / height;
            double scale = 1.0;
            switch (type) {
                case FIT:
                    scale = Math.min(xScale, yScale);  // scale to fit
                    break;
                case FILL:
                    scale = Math.max(xScale, yScale);  // scale to fill
            }
            double x = (WIDTH - width * scale) / 2;
            double y = (HEIGHT - height * scale) / 2;
            AffineTransform at = AffineTransform.getTranslateInstance(x, y);
            at.scale(scale, scale);
            g2.drawRenderedImage(in[j], at);
            g2.dispose();
        }
        return out;
    }
}

package com.ankit.QRbuild;


import com.ankit.QRbuild.decorator.ColoredQRCode;
import com.ankit.QRbuild.decorator.ImageOverlay;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class Main {
  public static final float TRANSPARENCY = 0.20f;
  public static final float OVERLAY_RATIO = 1f;
  public static final int WIDTH = 250;
  public static final int HEIGHT = 250;

  public static void main(String[] args) throws Exception {
    QRCode.ZXingBuilder.build(builder ->
        builder
            .withSize(WIDTH, HEIGHT)
            .and()
            .withData(loremIpsum)
            .and()
            .withDecorator(ColoredQRCode.colorizeQRCode(Color.BLUE.darker()))
            .and()
            .withDecorator(ImageOverlay.addImageOverlay(readImage("src/main/resources/images/logo.png"), TRANSPARENCY, OVERLAY_RATIO))
            .and()
            .withCharSet(Charset.forName("UTF-8"))
            .verify(true)

    ).toFile("./qrCode.png", "PNG");
  }

  public static BufferedImage readImage(String path) {
    try {
      return ImageIO.read(new File(path));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static String loremIpsum = "https://github.com/AnkitBhushan788/GenerateQR";
}

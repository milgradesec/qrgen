package com.paesa.qrgen;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.WriterException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRController {

    @GetMapping(value = "/qr")
    public ResponseEntity<byte[]> generate(@RequestParam(value = "data", defaultValue = "Example") final String data,
            @RequestParam(value = "size", defaultValue = "500") final String size) throws IOException, WriterException {

        final BufferedImage bimg = QRGenerator.createQRImage(data, 500);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.write(bimg, "jpg", baos);
        baos.flush();
        final byte[] bytes = baos.toByteArray();
        baos.close();

        return ResponseEntity.ok().header("Cache-Control", "public, max-age=86400").contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
}
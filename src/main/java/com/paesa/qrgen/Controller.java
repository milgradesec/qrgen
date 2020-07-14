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
public class Controller {

    @GetMapping("/qr")
    public ResponseEntity<byte[]> generateFromVar(
            @RequestParam(value = "data", defaultValue = "Example") final String data)
            throws IOException, WriterException {

        final BufferedImage bimg = QRGenerator.createQRImage(data, 400);
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ImageIO.write(bimg, "jpg", baos);
        baos.flush();
        final byte[] bytes = baos.toByteArray();
        baos.close();

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
    }
}
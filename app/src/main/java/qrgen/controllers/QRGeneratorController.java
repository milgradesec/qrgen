package qrgen.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.WriterException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import qrgen.QRGenerator;
import qrgen.models.JSONRequestModel;

@RestController
public class QRGeneratorController {

    private static final String DEFAULT_QR_VALUE = "https://blog.paesa.es/";

    @GetMapping("/qr")
    public ResponseEntity<byte[]> getFromVar(
            @RequestParam(value = "data", defaultValue = DEFAULT_QR_VALUE) final String data)
            throws IOException, WriterException {

        final BufferedImage bimg = QRGenerator.createQRImage(data, 400);
        final byte[] bytes;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(bimg, "jpg", baos);
            bytes = baos.toByteArray();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
    }

    @PostMapping(path = "/qr", consumes = "application/json", produces = "image/jpeg")
    public ResponseEntity<byte[]> getFromJSON(@RequestBody final JSONRequestModel request)
            throws WriterException, IOException {

        final BufferedImage bimg = QRGenerator.createQRImage(request.getData(), 400);
        final byte[] bytes;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(bimg, "jpg", baos);
            bytes = baos.toByteArray();
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
    }
}

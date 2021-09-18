package com.github.milgradesec.qrgen.controller;

import java.io.IOException;

import com.github.milgradesec.qrgen.QRGenerator;
import com.github.milgradesec.qrgen.model.Request;
import com.google.zxing.WriterException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QRController {

    private static final String DEFAULT_QR_VALUE = "https://blog.paesa.es/";
    private static final int DEFAULT_IMAGE_SIZE = 400;
    private static final String DEFAULT_IMAGE_FORMAT = "jpg";

    @GetMapping("/qr")
    public ResponseEntity<byte[]> getFromVar(@RequestParam(name = "data", defaultValue = DEFAULT_QR_VALUE) String data,
            @RequestParam(name = "size", required = false) Integer size) throws IOException, WriterException {

        if (size == null) {
            size = DEFAULT_IMAGE_SIZE;
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                .body(QRGenerator.generateFromString(data, size, DEFAULT_IMAGE_FORMAT));
    }

    @PostMapping(path = "/qr", consumes = "application/json", produces = "image/jpeg")
    public ResponseEntity<byte[]> getFromJSON(@RequestBody Request request) throws WriterException, IOException {

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
                .body(QRGenerator.generateFromString(request.getData(), DEFAULT_IMAGE_SIZE, DEFAULT_IMAGE_FORMAT));
    }
}

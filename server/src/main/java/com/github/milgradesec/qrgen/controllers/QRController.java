package com.github.milgradesec.qrgen.controllers;

import java.io.IOException;

import com.github.milgradesec.qrgen.QRGenerator;
import com.github.milgradesec.qrgen.models.JSONRequestModel;
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
    public ResponseEntity<byte[]> getFromVar(@RequestParam(value = "data", defaultValue = DEFAULT_QR_VALUE) String data)
            throws IOException, WriterException {

        byte[] buf = QRGenerator.generateFromString(data, DEFAULT_IMAGE_SIZE, DEFAULT_IMAGE_FORMAT);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(buf);
    }

    @PostMapping(path = "/qr", consumes = "application/json", produces = "image/jpeg")
    public ResponseEntity<byte[]> getFromJSON(@RequestBody JSONRequestModel request)
            throws WriterException, IOException {

        byte[] buf = QRGenerator.generateFromString(request.getData(), DEFAULT_IMAGE_SIZE, DEFAULT_IMAGE_FORMAT);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(buf);
    }
}

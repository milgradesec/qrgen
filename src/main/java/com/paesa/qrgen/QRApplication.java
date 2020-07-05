package com.paesa.qrgen;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.WriterException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QRApplication {

	public static void main(final String[] args) {
		SpringApplication.run(QRApplication.class, args);
	}

	@GetMapping(value = "/qr")
	public ResponseEntity<byte[]> generate(@RequestParam(value = "data", defaultValue = "Example") final String data)
			throws WriterException, IOException {

		final BufferedImage img = QRGenerator.createQRImage(data, 500);
		final ByteArrayOutputStream os = new ByteArrayOutputStream();

		ImageIO.write(img, "jpg", os);
		os.flush();
		final byte[] bytes = os.toByteArray();
		os.close();

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}
}

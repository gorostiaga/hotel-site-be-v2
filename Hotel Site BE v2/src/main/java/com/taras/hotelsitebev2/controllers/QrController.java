package com.taras.hotelsitebev2.controllers;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// the purpose of this controller is to show the qr image that is stored locally.
@CrossOrigin
@RequestMapping("/qrImages")
@RestController
public class QrController {

    private final ResourceLoader resourceLoader;

    public QrController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    //{qrImage:.+} allows to catch the extesion as well. eg: image.png
    @GetMapping("/{qrImage:.+}")
    public ResponseEntity<Resource> getQrImage (@PathVariable String qrImage) {
        Resource resource = resourceLoader.getResource("classpath:/qrImages/" + qrImage);
        if (resource.exists()) {
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

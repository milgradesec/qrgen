package com.github.milgradesec.qrgen.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class HomeController {

    @RequestMapping("/")
    public RedirectView homeHandler() {
        RedirectView rv = new RedirectView("/qr");
        rv.setStatusCode(HttpStatus.FOUND);
        return rv;
    }
}

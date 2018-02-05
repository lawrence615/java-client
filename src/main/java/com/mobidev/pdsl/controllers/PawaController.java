package com.mobidev.pdsl.controllers;

import com.mobidev.pdsl.Client;
import com.mobidev.pdsl.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PawaController {

    @Autowired
    Client client;

    @PostMapping("/token")
    public ResponseEntity<Token> purchase(@RequestBody Token token) {
        String value = client.write("b");

        return ResponseEntity.ok().body(new Token(value, 2));
    }
}

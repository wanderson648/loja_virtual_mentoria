package jdev.mentoria.lojavirtual.controller;

import jdev.mentoria.lojavirtual.model.Acesso;
import jdev.mentoria.lojavirtual.service.AcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcessoController {

    @Autowired
    private AcessoService acessoService;

    @PostMapping(value = "**/salvarAcesso")
    public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso) {
        Acesso acessoSalvo = acessoService.save(acesso);

        return new ResponseEntity<>(acessoSalvo, HttpStatus.CREATED);
    }
}

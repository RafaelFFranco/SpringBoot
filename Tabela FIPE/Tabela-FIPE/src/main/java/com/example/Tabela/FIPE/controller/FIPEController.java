package com.example.Tabela.FIPE.controller;


import com.example.Tabela.FIPE.service.FIPEService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FIPEController {

    FIPEService service = new FIPEService();

    @GetMapping("/marcas")
    public String consultarMarcas(){
        return service.consultarMarcas();
    }

    @GetMapping("/modelos/{marca}")
    public String consultarModelos(@PathVariable int marca){
        return service.consultarModelos(marca);
    }

    @GetMapping("/anos/{marca}/{modelo}")
    public String consultarAnos(@PathVariable int marca, @PathVariable int modelo){
        return service.consultarAnos(marca, modelo);
    }

    @GetMapping("/valor/{id}/{modelo}/{ano}")
    public String consultarPreco(@PathVariable int marca, @PathVariable int modelo, @PathVariable String ano){
        return service.consultarPreco(marca,modelo,ano);
    }
}

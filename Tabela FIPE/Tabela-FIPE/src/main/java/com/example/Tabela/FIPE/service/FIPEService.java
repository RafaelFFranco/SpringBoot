package com.example.Tabela.FIPE.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FIPEService {
    private String consultarUrl(String apiUrl){
        String dados ="";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            dados = responseEntity.getBody();
        }else {
            dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        return dados;
    }


    public String consultarMarcas(){
        return consultarUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas");
    }

    public String consultarModelos(int marca){
        return consultarUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+ marca +"/modelos");
    }

    public String consultarAnos(int marca, int modelo){
        return consultarUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+ marca +"/modelos/"+ modelo +"/anos");
    }

    public String consultarPreco(int marca, int modelo, String ano){
        return consultarUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/"+ marca +"/modelos/"+modelo+"/anos/"+ano);
    }



}

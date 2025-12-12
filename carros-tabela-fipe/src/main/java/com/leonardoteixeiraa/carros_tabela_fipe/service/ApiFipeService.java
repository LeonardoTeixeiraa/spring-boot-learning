package com.leonardoteixeiraa.carros_tabela_fipe.service;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.google.gson.reflect.TypeToken;
import com.leonardoteixeiraa.carros_tabela_fipe.dto.AnoDTO;
import com.leonardoteixeiraa.carros_tabela_fipe.dto.CarroFipeDTO;
import com.leonardoteixeiraa.carros_tabela_fipe.dto.ModeloDTO;
import com.leonardoteixeiraa.carros_tabela_fipe.dto.ModelosResponseDTO;
import com.leonardoteixeiraa.carros_tabela_fipe.model.Carro;
import com.leonardoteixeiraa.carros_tabela_fipe.model.Marca;

public class ApiFipeService {
    Gson gson = new Gson();

    public HttpResponse<String> getResponse(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        return client
                .send(request, HttpResponse.BodyHandlers.ofString());
    }

    public List<Marca> getCarBrands() throws IOException, InterruptedException {
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
        String json = getResponse(url).body();

        //Transforma o json de marcas em uma lista usando TypeToken
        Type listType = new TypeToken<List<Marca>>(){}.getType();
        return gson.fromJson(json, listType);
    }

    public void showCarBrands(List<Marca> marcas){
        marcas.forEach(System.out::println);
    }

    public List<ModeloDTO> findCarsByBrand(Integer marca) throws IOException, InterruptedException {
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca +"/modelos";
        String json = getResponse(url).body();

        ModelosResponseDTO dto = gson.fromJson(json, ModelosResponseDTO.class);
        return dto.modelos();
    }

    public void showModels(List<ModeloDTO> modelos) {
        modelos.forEach(m -> System.out.println(m.codigo() + " - " + m.nome()));
    }


    public List<ModeloDTO> findModelsByName(String name, List<ModeloDTO> modelos) {
        String lower = name.toLowerCase(Locale.ROOT);

        return modelos.stream()
                .filter(m -> m.nome().toLowerCase(Locale.ROOT).contains(lower))
                .toList();
    }


    public Carro getCarByYear(int marca, int modelCode, String anoCode) throws IOException, InterruptedException {
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/"
                + marca + "/modelos/" + modelCode + "/anos/" + anoCode;

        String json = getResponse(url).body();

        CarroFipeDTO dto = gson.fromJson(json, CarroFipeDTO.class);

        return new Carro(dto);
    }

    public List<AnoDTO> getYearsByModel(int marca, int modelCode) throws IOException, InterruptedException {
        String url = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca +"/modelos/" + modelCode + "/anos";
        String json = getResponse(url).body();

        Type listType = new TypeToken<List<AnoDTO>>(){}.getType();
        return gson.fromJson(json, listType);
    }

    public List<Carro> getCarsForAllYears(int marca, int modelCode)
            throws IOException, InterruptedException {

        List<AnoDTO> anos = getYearsByModel(marca, modelCode);

        List<Carro> carros = new ArrayList<>();

        for (AnoDTO ano : anos) {
            Carro carro = getCarByYear(marca, modelCode, ano.codigo());
            carros.add(carro);
        }

        return carros;
    }

    public void showAllCarsForYears(List<Carro> carros){
        carros.forEach(System.out::println);
    }
}

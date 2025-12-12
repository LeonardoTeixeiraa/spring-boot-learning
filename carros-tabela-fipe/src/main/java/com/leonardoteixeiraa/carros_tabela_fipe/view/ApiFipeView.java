package com.leonardoteixeiraa.carros_tabela_fipe.view;

import com.leonardoteixeiraa.carros_tabela_fipe.service.ApiFipeService;

import java.io.IOException;
import java.util.Scanner;

public class ApiFipeView {

    ApiFipeService service = new ApiFipeService();
    Scanner sc = new Scanner(System.in);

    public void menu() throws IOException, InterruptedException {
            System.out.println("********Consulta de carros na tabela FIPE********");

            var carBrands = service.getCarBrands();
            service.showCarBrands(carBrands);

            System.out.println("\nInforme o código da marca que deseja:");
            var brand = sc.nextInt();
            sc.nextLine();

            var models = service.findCarsByBrand(brand);
            service.showModels(models);

            System.out.println("\nInforme um trecho do nome do veículo para buscar:");
            var carName = sc.nextLine();

            var filteredModels = service.findModelsByName(carName, models);
            service.showModels(filteredModels);

            System.out.println("\nEscolha o código do modelo desejado:");
            int modelCode = sc.nextInt();
            sc.nextLine();

            var cars = service.getCarsForAllYears(brand, modelCode);
            service.showAllCarsForYears(cars);
    }
}

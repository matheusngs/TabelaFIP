package com.example.demo.main;

import com.example.demo.models.Brands;
import com.example.demo.models.DataVeicle;
import com.example.demo.models.Modelos;
import com.example.demo.service.ConvertData;
import com.example.demo.service.GetAPI;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

    private ConvertData conversor = new ConvertData();
    private final String brandAdressBase = "https://parallelum.com.br/fipe/api/v1/carros/marcas/";

    public void showMenu(){
        Scanner scanner = new Scanner(System.in);
        String adress = "";
        System.out.println("""
                ****** Opções ******
                Carro
                Moto
                Caminhão
                """);

        System.out.println("Digite uma das opções acima: ");
        String userVeicle = scanner.nextLine();
        if (userVeicle.equalsIgnoreCase("Carro") ||userVeicle.equalsIgnoreCase("Moto")) {
                adress = "https://parallelum.com.br/fipe/api/v1/" + userVeicle.toLowerCase() + "s/marcas";

        }else if (userVeicle.equalsIgnoreCase("Caminhão")){
            adress = "https://parallelum.com.br/fipe/api/v1/" + "caminhoes" + "/marcas";
        } else {
            System.out.println("Opção inválida");
        }
        String json = GetAPI.getApidata(adress);
        System.out.println(json);
        var brands = conversor.getList(json, Brands.class);
        brands.stream()
                .sorted(Comparator.comparing(Brands::code))
                .forEach(System.out::println);

        System.out.println("Digite o código correspondente à marca que deseja consultar: ");
        var codBrand = scanner.nextLine();
        json = GetAPI.getApidata(brandAdressBase + codBrand + "/modelos");
        adress = brandAdressBase + codBrand + "/modelos";

        var modelsList = conversor.getData(json, Modelos.class);
        System.out.println(modelsList);
        modelsList.modelos().stream()
                .sorted(Comparator.comparing(Brands::code))
                .forEach(System.out::println);

        System.out.println("Digite um trecho do nome do veiculo que deseja buscar: ");
        var veicleSearch = scanner.nextLine();
        List<Brands> modelsFiltereds = modelsList.modelos().stream()
                .filter(m -> m.name().toLowerCase().contains(veicleSearch.toLowerCase()))
                .collect(Collectors.toUnmodifiableList());

        System.out.println("\nModelos filtrados");
        modelsFiltereds.forEach(System.out::println);

        System.out.println("Digite o codigo do modelo da consulta: ");
        var modelCode = scanner.nextLine();
        adress = adress + "/" + modelCode + "/anos";
        json = GetAPI.getApidata(adress);
        List<Brands> years = conversor.getList(json, Brands.class);
        List<DataVeicle> veicles = new ArrayList<>();

        for (int i = 0; i < years.size(); i++) {
            var adressYears = adress + "/" + years.get(i).code();
            json = GetAPI.getApidata(adressYears);
            DataVeicle veicle = conversor.getData(json, DataVeicle.class);
            veicles.add(veicle);
        }
        System.out.println("\nTodos os veiculos encontrados por ano: ");
        veicles.forEach(System.out::println);

    }
}

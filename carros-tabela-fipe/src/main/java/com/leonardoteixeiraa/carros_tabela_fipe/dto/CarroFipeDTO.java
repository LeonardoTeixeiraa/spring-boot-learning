package com.leonardoteixeiraa.carros_tabela_fipe.dto;

import com.google.gson.annotations.SerializedName;

public class CarroFipeDTO {
    @SerializedName("TipoVeiculo")
    private Integer tipoVeiculo;

    @SerializedName("Valor")
    private String valor;

    @SerializedName("Marca")
    private String marca;

    @SerializedName("Modelo")
    private String modelo;

    @SerializedName("AnoModelo")
    private Integer anoModelo;

    @SerializedName("Combustivel")
    private String combustivel;

    @SerializedName("CodigoFipe")
    private String codigoFipe;

    @SerializedName("MesReferencia")
    private String mesReferencia;

    @SerializedName("SiglaCombustivel")
    private String siglaCombustivel;

    // getters
    public Integer getTipoVeiculo() { return tipoVeiculo; }
    public String getValor() { return valor; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public Integer getAnoModelo() { return anoModelo; }
    public String getCombustivel() { return combustivel; }
    public String getCodigoFipe() { return codigoFipe; }
    public String getMesReferencia() { return mesReferencia; }
    public String getSiglaCombustivel() { return siglaCombustivel; }

    @Override
    public String toString() {
        return "CarroFipeDTO{" +
                "tipoVeiculo=" + tipoVeiculo +
                ", valor='" + valor + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anoModelo=" + anoModelo +
                ", combustivel='" + combustivel + '\'' +
                ", codigoFipe='" + codigoFipe + '\'' +
                ", mesReferencia='" + mesReferencia + '\'' +
                ", siglaCombustivel='" + siglaCombustivel + '\'' +
                '}';
    }
}

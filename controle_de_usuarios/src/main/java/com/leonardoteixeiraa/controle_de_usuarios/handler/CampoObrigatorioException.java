package com.leonardoteixeiraa.controle_de_usuarios.handler;

public class CampoObrigatorioException extends BusinessException{
    public CampoObrigatorioException(String campo){
        super("O campo %s é obrigatório", campo);
    }
}

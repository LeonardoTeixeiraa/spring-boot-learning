package GofFacadeExample.subsistema1.crm;

public class CrmService {

    private CrmService() {
        super();
    }

    public static void gravarCliente(String nome, String cep, String cidade, String estado){
        System.out.println("Cliente salvo no sistema de CRM!"
                + "\nNome: " + nome
                + "\nCidade: " + cidade
                + "\nCEP: " + cep
                + "\nEstado: " + estado
        );


    }
}

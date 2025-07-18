package GofFacadeExample.subsistema2.cep;

public class CepApi {

    private static final CepApi cepApi =   new CepApi();

    private CepApi() {
        super();
    }

    public static CepApi getInstance(){
        return cepApi;
    }

    public String recuperarCidade(String cep){
        return "Votuporanga";
    }

    public String recuperarEstado(String estado){
        return "SP";
    }
}

package GofStrategyExample;

public class Test {
    public static void main(String[] args) {

        // Exemplo de implementação no Padrão Strategy
        ComportamentoAgressivo agressivo = new ComportamentoAgressivo();
        ComportamentoDefensivo defensivo = new ComportamentoDefensivo();
        ComportamentoNormal normal =  new ComportamentoNormal();

        Robo robo = new Robo();
        robo.setComportamento(normal);
        robo.mover();

        robo.setComportamento(agressivo);
        robo.mover();

        robo.setComportamento(defensivo);
        robo.mover();
    }
}

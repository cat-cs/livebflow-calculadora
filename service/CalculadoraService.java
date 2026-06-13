public class CalculadoraService {
    public double calcularPacoteLocacao (double aluguel, double condominio, double iptu) {

       if (aluguel <= 0) {
           throw new IllegalArgumentExeption("Valor do aluguel deve ser positivo");
       }
       if (condominio < 0) {
           throw new IllegalArgumentExeption("Condominio não pode ser negativo");
       }
       if (iptu < 0) {
           throw new IllegalArgumentExeption("IPTU não pode ser negativo");
       }

       return aluguel + condominio + iptu;
    }

    public double calcularSeguroFianca (double pacoteLocacao, double taxaPercentual){

        if (pacoteLocacao <= 0) {
            throw new IllegalArgumentExeption("Pacote de locação deve ser positivo");
        }
        if (taxaPercentual <= 0 || taxaPercentual > 15) {
            throw new IllegalArgumentExeption("Taxa deve estar entre 0 e 15%");
        }

        return pacoteLocacao * 12 * (taxaPercentual / 100);
    }

    public double calcularSeguroMensal (double valorSeguroAnual, int parcelas) {

        if (valorSeguroAnual <= 0) {
            throw new IllegalArgumentExeption("Valor do seguro anual deve ser positivo");
        }
        if (parcelas <= 0 || parcelas > 12) {
            throw new IllegalArgumentExeption ("Parcelas deve ser entre 1 e 12");
        }

        return valorSeguroAnual / parcelas;
    }

    public boolean verificarRendaMinima(double rendaBruta, double aluguel, double multiplicador) {

        if (rendaBruta <= 0 || aluguel <= 0) {
            throw new IllegalArgumentExeption("Renda e aluguel devem ser positivo");
        }
        if (multiplicador < 3.0 || multiplicador > 4.0) {
            throw new IllegalArgumentExeption("Multiplicador deve estar entre 3 e 4");
        }

        return rendaBruta >= (aluguel * multiplicador);
    }

    public boolean comprometimentoMaximoRenda(double rendaMensal, double pacoteLocacao) {
        if (rendaMensal <=0 || pacoteLocacao <= 0) {
            throw new IllegalArgumentexeption("Renda e pacote devem ser positivos");
        }
        double comprometimento = (pacoteLocacao / rendaMensal) * 100;

        return comprometimento <= 30.0;
    }
 }

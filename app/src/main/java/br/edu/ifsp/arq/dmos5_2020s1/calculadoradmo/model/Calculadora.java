package br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.model;

import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.constants.Constantes;

import static java.lang.Math.pow;

public class Calculadora {

    private static Calculadora sCalculadora = null;
    private float memoria;
    private int operacao;

    public Calculadora() {
        c();
    }

    public static Calculadora getInstance() {
        if(sCalculadora == null){
            sCalculadora = new Calculadora();
        }
        return sCalculadora;
    }

    public void c(){
        memoria = 0;
        operacao = Constantes.NULO;
    }

    public float calcular(int operacao, float valor) {
        if (this.operacao == Constantes.NULO) {
            this.operacao = operacao;
            this.memoria = valor;
        } else {
            switch (operacao) {
                case Constantes.ADICAO:
                    memoria += valor;
                    break;
                case Constantes.SUBTRACAO:
                    memoria -= valor;
                    break;
                case Constantes.MULTIPLICACAO:
                    memoria *= valor;
                    break;
                case Constantes.DIVISAO:
                    memoria /= valor;
                    break;
                case Constantes.POTENCIA:
                    memoria = (float) pow(memoria, valor);
                default:
                    break;
            }
            this.operacao = operacao;
        }
        return memoria;
    }
}

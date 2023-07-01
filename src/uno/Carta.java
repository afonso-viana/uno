package uno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rakke
 */
public class Carta {
    enum Cor {
        Vermelho, Azul, Verde, Amarelo, Especial;
        
        private static final Cor[] cores = Cor.values();
        
        public static Cor getCor(int i) {
            return Cor.cores[i];
        }
    }
    
    enum Valor {
        Zero, Um, Dois, Tres, Quatro, Cinco, Seis, Sete, Oito, Nove, MaisDois, Proibido, Inverter, MaisQuatro, MudaCor;
        
        private static final Valor[] valores = Valor.values();
        
        public static Valor getValor(int i) {
            return Valor.valores[i];
        }
    }
    
    private final Cor cor;
    private final Valor valor;
    
    public Carta (final Cor cor, final Valor valor)  {
       this.cor = cor;
       this.valor = valor;
       }
    
    public Cor getCor(){
        return this.cor;
    }
    
    public Valor getValor(){
        return this.valor;
    }
    
    public String toString(){
        return cor + "" + valor;
    }
}

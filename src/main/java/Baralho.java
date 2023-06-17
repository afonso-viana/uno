
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rakke
 */
public class Baralho {
    private Carta[] cartas;
    private int cartasNoBaralho;
    
    public Baralho(){
        cartas = new Carta[108];
    }
    
    public void reset(){
        Carta.Cor[] cores = Carta.Cor.values();
        cartasNoBaralho = 0;
        
        for(int i = 0; i<cores.length-1; i++){
            Carta.Cor cor = cores[i];
            
            cartas[cartasNoBaralho] = new Carta(cor, Carta.Valor.getValor(0)); 
            
            for(int j = 1; j < 10; j++){
                cartas[cartasNoBaralho++] = new Carta(cor, Carta.Valor.getValor(j));
                cartas[cartasNoBaralho++] = new Carta(cor, Carta.Valor.getValor(j));
            }
            
            Carta.Valor[] valores = new Carta.Valor[]{Carta.Valor.MaisDois,Carta.Valor.Proibido,Carta.Valor.Inverter}; 
            for(Carta.Valor valor : valores){
                cartas[cartasNoBaralho++] = new Carta(cor, valor);
                cartas[cartasNoBaralho++] = new Carta(cor, valor);
            }
        }
        
        Carta.Valor[] valores = new Carta.Valor[]{Carta.Valor.MudaCor, Carta.Valor.MaisQuatro};
        for(Carta.Valor valor : valores){ 
            for(int i = 0; i<4; i++){
                cartas[cartasNoBaralho++] = new Carta(Carta.Cor.Especial, valor);
            }
        }
        
    }
     
    public void atualizarBaralho(ArrayList<Carta> cartas){
        this.cartas = cartas.toArray(new Carta[cartas.size()]);
        this.cartasNoBaralho = this.cartas.length;
    }
    
    public boolean vazio(){
        return cartasNoBaralho == 0;
    }
    
    public void baralhar(){
        int n = cartas.length;
        Random random = new Random();
        
        for (int i = 0; i < cartas.length; i ++){
        
            int valorRandom = i + random.nextInt(n-i);
            Carta cartaRandom = cartas[valorRandom];
            cartas [valorRandom] = cartas[i];
            cartas[i] = cartaRandom;
        }
    }
    
    public Carta tirarCarta() throws IllegalArgumentException {
        if (vazio()) {
            throw new IllegalArgumentException("Não há mais cartas no baralho.");
        }
        
        return cartas[--cartasNoBaralho];
    }
    
    public ImageIcon tirarCartaImagem() throws IllegalArgumentException {
        if (vazio()) {
            throw new IllegalArgumentException("Não há mais cartas no baralho.");
        }
        
        return new ImageIcon(cartas[--cartasNoBaralho].toString() + ".png");
    }
    
    public Carta[] tirarCarta(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Tem de ser positivo");
        }
        
        if (n > cartasNoBaralho) {
            throw new IllegalArgumentException("Não há mais cartas no baralho.");
        }
        
        Carta[] cartasRecebidas = new Carta[n];
        
        for(int i = 0; i < n; i++){
            cartasRecebidas[i] = cartas[cartasNoBaralho];
        }
        return cartasRecebidas;
    }
}

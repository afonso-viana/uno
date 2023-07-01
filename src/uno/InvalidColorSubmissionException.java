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
public class InvalidColorSubmissionException extends Exception {
    private Carta.Cor esperada;
    private Carta.Cor atual;
    
    public InvalidColorSubmissionException (String mensagem, Carta.Cor atual, Carta.Cor esperada){
        this.atual = atual;
        this.esperada = esperada;
    }
}

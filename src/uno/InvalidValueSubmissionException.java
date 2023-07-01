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
public class InvalidValueSubmissionException extends Exception {
    private Carta.Valor esperado;
    private Carta.Valor atual;
    
    public InvalidValueSubmissionException (String mensagem, Carta.Valor atual, Carta.Valor esperado){
        this.atual = atual;
        this.esperado = esperado;
    }
}

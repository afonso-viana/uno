/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

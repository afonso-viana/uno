/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

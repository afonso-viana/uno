/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rakke
 */
class InvalidPlayerTurnException extends Exception {
    String jogadorId;
    
    public InvalidPlayerTurnException (String mensagem, String jid){
        super(mensagem);
        jogadorId = jid;
    }
    
    public String getJogadorId(){
        return jogadorId;
    }
}

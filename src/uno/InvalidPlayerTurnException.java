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
public class InvalidPlayerTurnException extends Exception {
    String jogadorId;
    
    public InvalidPlayerTurnException (String mensagem, String jid){
        super(mensagem);
        jogadorId = jid;
    }
    
    public String getJogadorId(){
        return jogadorId;
    }
}

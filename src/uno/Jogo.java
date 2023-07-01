package uno;


import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rakke
 */
public class Jogo {
    private int jogadorAtual;
    private String jogadorIds[];
    
    private Baralho baralho;
    private ArrayList<ArrayList<Carta>> maoJogador;
    private ArrayList<Carta> reserva;
    
    private Carta.Cor corValida;
    private Carta.Valor valorValido;
    
    boolean direcaoJogo;
    
    public Jogo(String[] ids){
        baralho = new Baralho();
        baralho.baralhar();
        reserva = new ArrayList<Carta>();
        
        jogadorIds = ids;
        jogadorAtual = 0;
        direcaoJogo = false;
        
        maoJogador = new ArrayList<ArrayList<Carta>>();
        
        for(int i =0; i < ids.length; i++){
            ArrayList<Carta> mao = new ArrayList<Carta>(Arrays.asList(baralho.tirarCarta(7)));
            maoJogador.add(mao);
        }
    }
    
    public void comecar(Jogo jogo){
        Carta carta = baralho.tirarCarta();
        corValida = carta.getCor();
        valorValido = carta.getValor();
        
        
        //se a primeira carta for a carta de Mudar de Cor, recomeçar o jogo.
        if(carta.getValor() == Carta.Valor.MudaCor){
            comecar(jogo);
        }
        
        //se a primeira carta for a carta de Mais Quatro ou Mais Dois, recomeçar o jogo.
        if(carta.getValor() == Carta.Valor.MaisQuatro || carta.getValor() == Carta.Valor.MaisDois){
            comecar(jogo);
        }
        
        //se a primeira carta for a carta de Proibido, o primeiro jogador não joga.
        if(carta.getValor() == Carta.Valor.Proibido){
            JLabel mensagem = new JLabel(jogadorIds[jogadorAtual] + "foi proibido");
            Font fonte = new Font("Arial", Font.BOLD, 48);
            mensagem.setFont(fonte);
            
            JOptionPane.showMessageDialog(null, mensagem);
            
            if (direcaoJogo == false){
                jogadorAtual = (jogadorAtual + 1) % jogadorIds.length;
            }
            
            else if (direcaoJogo == true) {
                jogadorAtual = (jogadorAtual - 1) % jogadorIds.length;
                if (jogadorAtual == -1) {
                    jogadorAtual = jogadorIds.length - 1;
                }
            }
        }
        
        if (carta.getValor() == Carta.Valor.Inverter){
            JLabel mensagem = new JLabel(jogadorIds[jogadorAtual] + "A direção do jogo mudou.");
            Font fonte = new Font("Arial", Font.BOLD, 48);
            mensagem.setFont(fonte);
            
            direcaoJogo ^= true;
            jogadorAtual = jogadorIds.length - 1;
        }
        
        reserva.add(carta);
    }
    
   public Carta primeiraCarta(){
       return new Carta(corValida, valorValido);
   } 
   
   public ImageIcon primeiraCartaImagem(){
       return new ImageIcon(corValida + "-" + valorValido + ".png"); 
   }
   
   public boolean jogoTerminado(){
      for (String jogador : this.jogadorIds) {
          if (maoVazia(jogador)){
              return true;
          }
      }
      return false;
   }
   
   public String getJogadorAtual(){
       return this.jogadorIds[this.jogadorAtual];
   }
   
   public String getJogadorAnterior(int i){
       int index = this.jogadorAtual - i;
       
       if (index == -1){
           index = jogadorIds.length - 1;
       }
       
       return this.jogadorIds[index];
   }
   
   public String[] getJogadores(){
       return jogadorIds;
   }
   
   public ArrayList<Carta> getMaoJogador(String jid){
       int index = Arrays.asList(jogadorIds).indexOf(jid);
       return maoJogador.get(index);
   }
   
   public int maoJogadorDimensao(String jid){
       return getMaoJogador(jid).size();
   }
   
   public Carta cartaJogador(String jid, int escolha){
       ArrayList<Carta> mao = getMaoJogador(jid);
       return mao.get(escolha);
   }
   
   public boolean maoVazia(String jid){
       return getMaoJogador(jid).isEmpty();
   }
   
   public boolean jogadaValida(Carta carta){
       return carta.getCor() == corValida || carta.getValor() == valorValido;
   }
   
   public void verificaJogadorAtual(String jid) throws InvalidPlayerTurnException{
       if (this.jogadorIds[this.jogadorAtual] != jid){
           throw new InvalidPlayerTurnException("não é a vez de " + jid, jid);
       }
   }
   
   public void tiraCartaBaralho(String jid) throws InvalidPlayerTurnException{
       verificaJogadorAtual(jid);
       
       if (baralho.vazio()){
           baralho.atualizarBaralho(reserva);
           baralho.baralhar();
       }
       
       getMaoJogador(jid).add(baralho.tirarCarta());
       
       if (direcaoJogo == false){
           jogadorAtual = (jogadorAtual + 1) % jogadorIds.length;
       }
       
       else if(direcaoJogo == true){
           jogadorAtual = (jogadorAtual - 1) % jogadorIds.length;
           if (jogadorAtual == -1){
               jogadorAtual = jogadorIds.length - 1;
           }
       }
   }
   
   public void setCorCarta(Carta.Cor cor){
       corValida = cor;
   }
   
   public void submeterJogada(String jid, Carta carta, Carta.Cor corEscolhida)
    throws InvalidColorSubmissionException, InvalidValueSubmissionException, InvalidPlayerTurnException {
       verificaJogadorAtual(jid);
       
       ArrayList<Carta> maoJ = getMaoJogador(jid);
       
       if(!jogadaValida(carta)){
           if (carta.getCor() == Carta.Cor.Especial){
               corValida = carta.getCor();
               valorValido = carta.getValor();
           }
           
           if (carta.getCor() != corValida){
               JLabel mensagem = new JLabel("Jogada inválida. Deve jogar uma carta " + corValida);
               Font fonte = new Font("Arial", Font.BOLD, 48);
               mensagem.setFont(fonte);
               JOptionPane.showMessageDialog(null, mensagem);
               
               //??????
               throw new InvalidColorSubmissionException("Jogada inválida. Deve jogar uma carta " + corValida, carta.getCor(), corValida);
           }
           
           else if (carta.getValor() != valorValido){
               JLabel mensagem2 = new JLabel("Jogada inválida. Deve jogar uma carta " + valorValido);
               Font fonte = new Font("Arial", Font.BOLD, 48);
               mensagem2.setFont(fonte);
               JOptionPane.showMessageDialog(null, mensagem2);
               
               throw new InvalidValueSubmissionException("Jogada inválida. Deve jogar uma carta " + valorValido, carta.getValor(), valorValido);
           }
       }
       
       maoJ.remove(carta);
       
       if(maoVazia(this.jogadorIds[jogadorAtual])){
            JLabel mensagem3 = new JLabel(this.jogadorIds[jogadorAtual] + " ganhou!");
               Font fonte = new Font("Arial", Font.BOLD, 48);
               mensagem3.setFont(fonte);
               JOptionPane.showMessageDialog(null, mensagem3);
               
               System.exit(0);
       }
       
       corValida = carta.getCor();
       valorValido = carta.getValor();
       
       reserva.add(carta);
       
       if(direcaoJogo == false){
           jogadorAtual = (jogadorAtual+1) % jogadorIds.length;
       }
       
       else if (direcaoJogo == true){
           jogadorAtual = (jogadorAtual-1) % jogadorIds.length;
           
           if(jogadorAtual == -1){
               jogadorAtual = jogadorIds.length;
           }
       }
       
       if (carta.getCor() == Carta.Cor.Especial){
           corValida = corEscolhida;
       }
       
       if (carta.getValor() == Carta.Valor.MaisDois){
           jid = jogadorIds[jogadorAtual];
           getMaoJogador(jid).add(baralho.tirarCarta());
           getMaoJogador(jid).add(baralho.tirarCarta());
       }
       
       if (carta.getValor() == Carta.Valor.MaisQuatro){
           jid = jogadorIds[jogadorAtual];
           getMaoJogador(jid).add(baralho.tirarCarta());
           getMaoJogador(jid).add(baralho.tirarCarta());
           getMaoJogador(jid).add(baralho.tirarCarta());
           getMaoJogador(jid).add(baralho.tirarCarta());
           
       }
       
       if (carta.getValor() == Carta.Valor.Proibido){
            JLabel mensagem4 = new JLabel(this.jogadorIds[jogadorAtual] + " foi proibido!");
               Font fonte = new Font("Arial", Font.BOLD, 48);
               mensagem4.setFont(fonte);
               JOptionPane.showMessageDialog(null, mensagem4);
               
            if (direcaoJogo == false){
                jogadorAtual = (jogadorAtual+1) % jogadorIds.length;
            }
            
            else if (direcaoJogo == true){
                jogadorAtual = (jogadorAtual-1) % jogadorIds.length;
                
                if (jogadorAtual == -1){
                    jogadorAtual = jogadorIds.length - 1;
                }
            }
       }
       
       if (carta.getValor() == Carta.Valor.Inverter){
           JLabel mensagem5 = new JLabel(jid + " mudou a direção do jogo");
               Font fonte = new Font("Arial", Font.BOLD, 48);
               mensagem5.setFont(fonte);
               JOptionPane.showMessageDialog(null, mensagem5);
               
               direcaoJogo ^= true;
               
               if (direcaoJogo == true){
                   jogadorAtual = (jogadorAtual - 2) % jogadorIds.length;
                   if (jogadorAtual == -1){
                       jogadorAtual = jogadorIds.length - 1;
                   }
                   
                   if (jogadorAtual == -2){
                       jogadorAtual = jogadorIds.length - 2;
                   }
               }
               
               else if (direcaoJogo == false){
                   jogadorAtual = (jogadorAtual + 2) % jogadorIds.length;
               }
       }
   }
   
}

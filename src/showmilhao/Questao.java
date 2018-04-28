/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showmilhao;
import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class Questao {
    
    private String enunciado;
    private ArrayList<Resposta> respostas;
    private Resposta correta;
        
    public Questao(String enunciado){
        this.enunciado = enunciado;
    }
  
    public String get_enunciado(){
        return this.enunciado;
    }
    
    public Resposta get_resposta(int posicao){
        return this.respostas.get(posicao);
    }
    
    public int get_num_respostas(){
        return this.respostas.size();
    }
    
    public ArrayList<Resposta> get_alternativas(){
        return this.respostas;
    }
    
    public void add_resposta(char letra, String texto, boolean correta){
        if(correta){
            this.correta = new Resposta(letra, texto, correta);
        }
        this.respostas.add(new Resposta(letra, texto, correta));
    }
    
    public boolean verifica_resposta(char letra){
        return letra == this.correta.get_letra();
    }
    
}

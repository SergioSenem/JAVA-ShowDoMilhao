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
    private int correta;
    private boolean respondida;
        
    public Questao(String enunciado){
        this.enunciado = enunciado;
        this.respondida = false;
        this.respostas = new ArrayList();
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
            this.correta = respostas.size();
        }
        this.respostas.add(new Resposta(letra, texto, correta));
    }
    
    public boolean verifica_resposta(char letra){
        return letra == this.respostas.get(this.correta).get_letra();
    }
    
    public int get_resposta_correta(){
        return this.correta;
    }

    public void set_respondida(){
        this.respondida = true;
    }
    
    public boolean get_respondida(){
        return this.respondida;
    }
    
}

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
    private int dificuldade;
    private ArrayList<String> alternativas;
    private char alternativa_correta; 
        
    public Questao(
                    String enunciado,
                    int dificuldade,
                    ArrayList<String> alternativas,
                    char alternativa_correta
                  )
    {
        this.enunciado = enunciado;
        this.dificuldade = dificuldade;
        this.alternativas = alternativas;
        this.alternativa_correta = alternativa_correta;
    }
    
    public char get_alternativa_correta(){
        return this.alternativa_correta;
    }
    
    public String get_enunciado(){
        return this.enunciado;
    }
    
    public String get_alternativa(int posicao){
        return this.alternativas.get(posicao);
    }
    
    public int get_dificuldade(){
        return this.dificuldade;
    }
    
    public int get_num_questoes(){
        return this.alternativas.size();
    }
    
    public ArrayList<String> get_alternativas(){
        return this.alternativas;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showmilhao;

/**
 *
 * @author udesc
 */
public class Resposta {
    
    private String texto;
    private char letra;
    private boolean correta;
    private boolean invalida;
    
    public Resposta(char letra, String texto, boolean correta){
        this.texto = texto;
        this.letra = letra;
        this.correta = correta;
        this.invalida = false;
    }
    
    public boolean esta_correta(){
        return this.correta;
    }
    
    public char get_letra(){
        return this.letra;
    }
    
    public String get_texto(){
        return this.texto;
    }
    
    public void invalidar(){
        this.invalida = true;
    }
    
    public boolean esta_invalida(){
        return this.invalida;
    }
    
    
    
}

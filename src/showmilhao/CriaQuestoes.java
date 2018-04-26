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
public class CriaQuestoes {
    
    public void cria_questoes(ArrayList<Questao> questoes){
        String enunciado;
        ArrayList<String> alt = new ArrayList();
        char correta;
        
        enunciado = "teste 1";
        alt.add("teste A");
        alt.add("teste B");
        alt.add("teste C");
        alt.add("teste D");
        correta = 'B';
        
        Questao questao = new Questao(enunciado, 1, alt, correta);
        
        questoes.add(questao);
        
        enunciado = "teste 2";
        alt = new ArrayList();
        alt.add("teste A");
        alt.add("teste B");
        alt.add("teste C");
        alt.add("teste D");
        correta = 'A';
        
        questao = new Questao(enunciado, 1, alt, correta);
        
        questoes.add(questao);
        
        enunciado = "teste 3";
        alt = new ArrayList();
        alt.add("teste A");
        alt.add("teste B");
        alt.add("teste C");
        alt.add("teste D");
        correta = 'D';
        
        questao = new Questao(enunciado, 1, alt, correta);
        
        questoes.add(questao);
        
        enunciado = "teste 4";
        alt = new ArrayList();
        alt.add("teste A");
        alt.add("teste B");
        alt.add("teste C");
        alt.add("teste D");
        correta = 'C';
        
        questao = new Questao(enunciado, 1, alt, correta);
        
        questoes.add(questao);
        
        enunciado = "teste 5";
        alt = new ArrayList();
        alt.add("teste A");
        alt.add("teste B");
        alt.add("teste C");
        alt.add("teste D");
        correta = 'B';
        
        questao = new Questao(enunciado, 2, alt, correta);
        
        questoes.add(questao);
        
        enunciado = "teste 6";
        alt = new ArrayList();
        alt.add("teste A");
        alt.add("teste B");
        alt.add("teste C");
        alt.add("teste D");
        correta = 'A';
        
        questao = new Questao(enunciado, 2, alt, correta);
        
        questoes.add(questao);
        
        enunciado = "teste 7";
        alt = new ArrayList();
        alt.add("teste A");
        alt.add("teste B");
        alt.add("teste C");
        alt.add("teste D");
        correta = 'D';
        
        questao = new Questao(enunciado, 2, alt, correta);
        
        questoes.add(questao);
    }
    
}

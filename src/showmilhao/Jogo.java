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
public class Jogo {
    
    private boolean acabou;
    private ArrayList<Questao> faceis;
    private ArrayList<Questao> medias;
    private ArrayList<Questao> dificeis;
    private int num_pulos_restantes;
    private int num_eliminacoes_restantes;
    private int pontos;
    private int num_acertos;
    
    public Jogo(){
        this.acabou = false;
        this.faceis = new ArrayList();
        this.medias = new ArrayList();
        this.dificeis = new ArrayList();
        this.num_pulos_restantes = 3;
        this.num_eliminacoes_restantes = 1;
        this.pontos = 0;
        this.num_acertos = 0;
        
        CriaQuestoes fabrica = new CriaQuestoes();
        
        fabrica.cria_questoes(faceis, medias, dificeis);
    }
    
    public int get_num_pulos(){
        return this.num_pulos_restantes;
    }
    
    public int get_num_eliminacoes(){
        return this.num_eliminacoes_restantes;
    }
    
    public int get_pontos(){
        return this.pontos;
    }
    
    public boolean get_acabou(){
        return this.acabou;
    }
    
    public int get_num_acertos(){
        return this.num_acertos;
    }
    
    public void acabar(){
        this.acabou = true;
    }
    
    private void eliminar_alternativa(Questao questao){
        long num;
        boolean ok = false;
        int op_correta;
        op_correta = questao.get_resposta_correta();
        
        num = -1;
        while(!ok){
            num = Math.round(Math.random()*3);
            if(num != op_correta){
                ok = true;
            }
        }
        
        questao.get_resposta((int)num).invalidar();
    }

    public Questao escolhe_questao(int dificuldade){
        long num;
        boolean ok = false;
        Questao questao = null;
        while(!ok){
            switch(dificuldade){
                case 1:
                    num = Math.round(Math.random() * (this.get_num_faceis() - 1));
                    questao = this.faceis.get((int)num);
                    break;
                case 2:
                    num = Math.round(Math.random() * (this.get_num_medias() - 1));
                    questao = this.medias.get((int)num);
                    break;
                case 3:
                    num = Math.round(Math.random() * (this.get_num_dificeis() - 1));
                    questao = this.dificeis.get((int)num);
                    break;
            }
            ok = !questao.get_respondida();
        }
        return questao;
    }
    
    private int get_num_faceis(){
        return this.faceis.size();
    }
    
    private int get_num_medias(){
        return this.medias.size();
    }
    
    private int get_num_dificeis(){
        return this.dificeis.size();
    }
    
    public int escolhe_dificuldade(){
        if(this.num_acertos < 4){
            return 1;
        }
        else{
            if(this.num_acertos <7){
                return 2;
            }
            else{
                return 3;
            }
        }
    }
    
    
    
    private void aumenta_pontos(){
        if(this.num_acertos < 4){
            this.pontos += 1000;
        }
        else{
            if(this.num_acertos < 7){
                this.pontos += 3000;
            }
            else{
                this.pontos += 987000;
            }
        }
    }

    public int nova_questao(Questao questao, int posicao, char resposta){
        
        int resultado = 0;
        
        if(resposta == '2' && this.num_eliminacoes_restantes > 0){
            questao.set_respondida();
            this.num_pulos_restantes--;
        }
        else{
            if(resposta=='1' && this.num_eliminacoes_restantes > 0){
                this.eliminar_alternativa(questao);
                this.num_eliminacoes_restantes--;
                resultado = 1; //Saida informando escolha de eliminar questao
            }
            else{
                if(questao.verifica_resposta(resposta)){
                    this.aumenta_pontos();
                    this.num_acertos++;
                    questao.set_respondida();
                    resultado = 2; //Saida informando acerto do usuário
                    //System.out.println("Você acertou!\n");
                }
                else{
                    if(resposta != 'A' && resposta != 'B' && resposta != 'C' && resposta != 'D' && resposta != '1' && resposta != '2'){
                        resultado = 3; //Saida informando valor inválido
                        //System.out.println("Valor inválido\n");
                    }
                    else{
                        if(resposta == '2' || resposta == '1'){
                            resultado = 4; //Saida informando falta de permissão
                            //System.out.println("Você não tem permissão!\n");
                        }
                        else{
                            resultado = 5; //Saida informando erro do usuário
                            //System.out.println("Você errou!\n");
                            this.acabou = true;
                            this.pontos = 0;
                        }
                    }

                }
            }
        }
        return resultado;
    }
    
    
    public int get_posicao_questao(Questao questao, int dificuldade){
        int i;
        int pos = -1;
        ArrayList<Questao> questoes = new ArrayList();
        switch(dificuldade){
            case 1:
                questoes = this.faceis;
                break;
            case 2:
                questoes = this.medias;
                break;
            case 3:
                questoes = this.dificeis;
                break;
        }
        for(i=0;i<questoes.size();i++){
            if(questoes.get(i) == questao){
                pos = i;
            }
        }
        return pos;
    }
    
    public void desistir(){
        this.pontos /= 2;
        this.acabou = true;
    }

}

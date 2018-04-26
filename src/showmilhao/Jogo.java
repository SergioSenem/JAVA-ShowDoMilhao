/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showmilhao;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class Jogo {
    
    private boolean acabou;
    private ArrayList<Questao> questoes;
    private int num_pulos_restantes;
    private int num_eliminacoes_restantes;
    private int pontos;
    private int num_acertos;
    
    public Jogo(){
        this.acabou = false;
        this.questoes = new ArrayList();
        this.num_pulos_restantes = 3;
        this.num_eliminacoes_restantes = 1;
        this.pontos = 0;
        
        CriaQuestoes fabrica = new CriaQuestoes();
        
        fabrica.cria_questoes(questoes);
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
    
    public Questao get_questao(int questao){
        return this.questoes.get(questao);
    }
    
    public int get_num_acertos(){
        return this.num_acertos;
    }
    
    public void desistir(){
        this.acabou = true;
    }
    
    public Questao eliminar_alternativa(Questao questao){
        long num;
        boolean ok = false;
        char correta;
        int op_correta;
        correta = questao.get_alternativa_correta();
        
        switch(correta){
            case 'A':
                op_correta = 0;
                break;
            case 'B':
                op_correta = 1;
                break;
            case 'C':
                op_correta = 2;
                break;
            case 'D':
                op_correta = 3;
                break;
            default:
                op_correta = -1;
                System.out.println("Erro!");
        }
        num = -1;
        while(!ok){
            num = Math.round(Math.random()*4);
            if(num != 0){
                if(num != op_correta){
                    ok = true;
                }
            }
        }
        
        ArrayList<String> novas_alternativas = questao.get_alternativas();
        novas_alternativas.remove((int)num);
        Questao nova_questao = new Questao(questao.get_enunciado(), questao.get_dificuldade(), novas_alternativas, correta);
        return nova_questao;
    }
    
    public void comecar(){
        while(!this.acabou){
            if(this.num_acertos != 0){
                if(this.continuar(this.escolhe_continuar())){
                    Questao questao = this.escolhe_questao(this.escolhe_dificuldade());
                    this.nova_questao(questao, this.get_posicao_questao(questao));
                }
                else{
                    this.desistir();
                    System.out.println("Você desistiu!\n");
                }
            }
            else{
                Questao questao = this.escolhe_questao(this.escolhe_dificuldade());
                this.nova_questao(questao, this.get_posicao_questao(questao));
            }
        }
        this.mostra_resultado();
    }
    
    public void mostra_questao(Questao questao){
        System.out.println("Pontos: " + this.pontos);
        System.out.println("Acertos: " + this.num_acertos + "\n");
        System.out.println((this.num_acertos+1) + ")" + questao.get_enunciado() + "\n");
        int i;
        for(i=0;i<questao.get_num_questoes();i++){
            switch(i){
                case 0:
                    System.out.println("A)" + questao.get_alternativa(i));
                    break;
                case 1:
                    System.out.println("B)" + questao.get_alternativa(i));
                    break;
                case 2:
                    System.out.println("C)" + questao.get_alternativa(i));
                    break;
                case 3:
                    System.out.println("D)" + questao.get_alternativa(i));
                    break;
                default:
                    System.out.println("Erro ao mostrar alternativas!");
                    break;
            }
        }
        System.out.println("\n");
        if(this.num_eliminacoes_restantes>0){
            System.out.println("[1] - Eliminar uma alternativa errada (" + this.num_eliminacoes_restantes + " restantes)");
        }
        if(this.num_pulos_restantes > 0){
            System.out.println("[2] - Pular questão ("+ this.num_pulos_restantes +" restantes)");
        }
        System.out.println("\n");
    }

    public Questao escolhe_questao(int dificuldade){
        long num = -1;
        Questao questao = null;
        while(num==-1 || questao.get_dificuldade() != dificuldade){
            num = Math.round(Math.random()*this.get_num_questoes());
            questao = this.questoes.get((int)num);
        }
        return questao;
    }
    
    public int get_num_questoes(){
        return this.questoes.size();
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
    
    public char escolhe_alternativa(){
        char escolha;
        Scanner sc = new Scanner(System.in);
        escolha = sc.next().charAt(0);
        return escolha;
    }
    
    public boolean verifica_resposta(Questao questao, char resposta){
        return questao.get_alternativa_correta() == resposta;
    }
    
    public void aumenta_pontos(int dificuldade){
        switch(dificuldade){
            case 1:
                this.pontos += 1000;
                break;
            case 2:
                this.pontos += 2000;
                break;
            case 3:
                this.pontos += 990000;
                break;
            default:
                System.out.println("Erro ao aumentar pontuação!");
                break;
        }
    }

    public void nova_questao(Questao questao, int posicao){
        
        this.mostra_questao(questao);
        char resposta = this.escolhe_alternativa();
        if(resposta == '2' && this.num_eliminacoes_restantes > 0){
            this.questoes.remove(posicao);
            this.num_pulos_restantes--;
        }
        else{
            if(resposta=='1' && this.num_eliminacoes_restantes > 0){
                questao = this.eliminar_alternativa(questao);
                this.num_eliminacoes_restantes--;
                this.mostra_questao(questao);
                resposta = this.escolhe_alternativa();
            }
            if(this.verifica_resposta(questao, resposta)){
                this.num_acertos++;
                this.aumenta_pontos(questao.get_dificuldade());
                this.questoes.remove(posicao);
                System.out.println("Você acertou!\n");
            }
            else{
                if(resposta != 'A' && resposta != 'B' && resposta != 'C' && resposta != 'D' && resposta != '1' && resposta != '2'){
                    System.out.println("Valor inválido\n");
                }
                else{
                    if(resposta == '2' || resposta == '1'){
                        System.out.println("Você não tem permissão!\n");
                    }
                    else{
                        System.out.println("Você errou!\n");
                        this.acabou = true;
                        this.pontos /= 2;
                    }
                }
                
            }
        }
        
    }
    
    public boolean continuar(int resposta){
        if(resposta == 1){
            return true;
        }
        else{
            if(resposta == 2){
                return false;
            }
            else{
                System.out.println("Valor inválido!");
                return false;
            }
        }
    }
    
    public int escolhe_continuar(){
        System.out.println("Continuar?\n");
        System.out.println("[1] - Sim");
        System.out.println("[2] - Não\n");
        Scanner sc = new Scanner(System.in);
        int resposta = sc.nextInt();
        return resposta;
    }
    
    public int get_posicao_questao(Questao questao){
        int i;
        int pos = -1;
        for(i=0;i<this.questoes.size();i++){
            if(questoes.get(i) == questao){
                pos = i;
            }
        }
        return pos;
    }
    
    public void mostra_resultado(){
        if(this.num_acertos == 8){
            System.out.println("Você ganhou!");
        }
        System.out.println("Você acertou " + this.num_acertos + " questões!");
        System.out.println("Você ganhou " + this.pontos + " reias em barras de ouro que valem mais que dinheiro!");
    }

}

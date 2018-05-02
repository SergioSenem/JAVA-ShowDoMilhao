/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showmilhao;

import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class IOJogo {
    private Jogo jogo;
    
    public IOJogo(){
        jogo = new Jogo();
    }
    
    public void mostra_resultado(){
        if(this.jogo.get_num_acertos() == 8){
            System.out.println("Você ganhou!");
        }
        System.out.println("Você acertou " + this.jogo.get_num_acertos() + " questões!");
        System.out.println("Você ganhou " + this.jogo.get_pontos() + " reias em barras de ouro que valem mais que dinheiro!");
    }
    
    public void comecar(){
        while(!this.jogo.get_acabou()){
            if(this.jogo.get_num_acertos() == 8){
                this.jogo.acabar();
            }
            else{
                if(this.jogo.get_num_acertos() != 0){
                    if(this.continuar(this.escolhe_continuar())){
                        int dificuldade = this.jogo.escolhe_dificuldade();
                        Questao questao = this.jogo.escolhe_questao(dificuldade);
                        this.mostra_questao(questao);
                        char resposta = this.escolhe_alternativa();
                        //Caso o resultado da função nova questao for 1, mostre a questao novamente e peça novamente a resposta do usuario
                        //Isto porque o mesmo decidiu "eliminar"(invalidar) uma alternativa da questao
                        int output_questao;
                        while((output_questao = this.jogo.nova_questao(questao, this.jogo.get_posicao_questao(questao, dificuldade), resposta)) == 1){
                            this.mostra_questao(questao);
                            resposta = this.escolhe_alternativa();
                        }
                        switch(output_questao){
                            case 2:
                                System.out.println("Você acertou!\n");
                                break;
                            case 3:
                                System.out.println("Valor inválido\n");
                                break;
                            case 4:
                                System.out.println("Você não tem permissão!\n");
                                break;
                            case 5:
                                System.out.println("Você errou!\n");
                                break;
                            default:
                                System.out.println("Erro ao verificar output (nova_questao())");
                        }
                    }
                    else{
                        this.jogo.desistir();
                        System.out.println("Você desistiu!\n");
                    }
                }
                else{
                    int dificuldade = this.jogo.escolhe_dificuldade();
                    Questao questao = this.jogo.escolhe_questao(dificuldade);
                    this.mostra_questao(questao);
                    char resposta = this.escolhe_alternativa();
                    while(this.jogo.nova_questao(questao, this.jogo.get_posicao_questao(questao, dificuldade), resposta) == 1){
                        this.mostra_questao(questao);
                        resposta = this.escolhe_alternativa();
                    }
                }
            }
        }
        this.mostra_resultado();
    }
    
    public void mostra_questao(Questao questao){
        System.out.println("Pontos: " + this.jogo.get_pontos());
        System.out.println("Acertos: " + this.jogo.get_num_acertos() + "\n");
        System.out.println((this.jogo.get_num_acertos()+1) + ")" + questao.get_enunciado() + "\n");
        int i;
        for(i=0;i<questao.get_num_respostas();i++){
            if(!questao.get_resposta(i).esta_invalida()){
                System.out.println(questao.get_resposta(i).get_letra() + ") " + questao.get_resposta(i).get_texto());       
            }
        }
        System.out.println("\n");
        if(this.jogo.get_num_eliminacoes()>0){
            System.out.println("[1] - Eliminar uma alternativa errada (" + this.jogo.get_num_eliminacoes() + " restantes)");
        }
        if(this.jogo.get_num_pulos() > 0){
            System.out.println("[2] - Pular questão ("+ this.jogo.get_num_pulos() +" restantes)");
        }
        System.out.println("\n");
    }
    
    public int escolhe_continuar(){
        System.out.println("Continuar? (Pontos: " + this.jogo.get_pontos() + ")\n");
        System.out.println("[1] - Sim");
        System.out.println("[2] - Não\n");
        Scanner sc = new Scanner(System.in);
        int resposta = sc.nextInt();
        return resposta;
    }
    
    public char escolhe_alternativa(){
        char escolha;
        Scanner sc = new Scanner(System.in);
        escolha = sc.next().charAt(0);
        return escolha;
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
    
}

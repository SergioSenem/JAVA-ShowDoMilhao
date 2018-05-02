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
    
    public void cria_questoes(ArrayList<Questao> faceis, ArrayList<Questao> medias, ArrayList<Questao> dificeis){
        Questao facil;
        Questao media;
        Questao dificil;
        
        //Criação das questões fáceis
        
        //1
        facil = new Questao("Qual é o maior planeta do sistema solar?");
        
        facil.add_resposta('A', "Júpiter", true);
        facil.add_resposta('B', "Marte", false);
        facil.add_resposta('C', "Saturno", false);
        facil.add_resposta('D', "Vênus", false);
        
        faceis.add(facil);
        
        //2
        facil = new Questao("Qual o nome do cientista que descobriu o processo de pasteurização e a vacina contra a raiva?");
        
        facil.add_resposta('A', "Marie Curie", false);
        facil.add_resposta('B', "Louis Pasteur", true);
        facil.add_resposta('C', "Blaise Pascal", false);
        facil.add_resposta('D', "Antoine Lavoisier", false);
        
        faceis.add(facil);
        
        //3
        facil = new Questao("As pessoas de que tipo sanguíneo são considerados doadores universais?");
        
        facil.add_resposta('A', "Tipo A", false);
        facil.add_resposta('B', "Tipo B", false);
        facil.add_resposta('C', "Tipo 0", true);
        facil.add_resposta('D', "Tipo AB", false);
        
        faceis.add(facil);
        
        //4
        facil = new Questao("Onde fica Machu Picchu?");
        
        facil.add_resposta('A', "Uruguai", false);
        facil.add_resposta('B', "Colômbia", false);
        facil.add_resposta('C', "Chile", false);
        facil.add_resposta('D', "Peru", true);
        
        faceis.add(facil);
        
        //5
        facil = new Questao("Qual é a estrela que fica mais próxima do planeta terra?");
        
        facil.add_resposta('A', "Sol", true);
        facil.add_resposta('B', "Lua", false);
        facil.add_resposta('C', "Alfa Centauri", false);
        facil.add_resposta('D', "Estrela de Barnard", false);
        
        faceis.add(facil);
        
        //6
        facil = new Questao("Qual o menor país do mundo?");
        
        facil.add_resposta('A', "Nauru", false);
        facil.add_resposta('B', "Vaticano", true);
        facil.add_resposta('C', "Malta", false);
        facil.add_resposta('D', "Mônaco", false);
        
        faceis.add(facil);
        
        //7
        facil = new Questao("O violoncelo é um instrumento de:");
        
        facil.add_resposta('A', "Sopro", false);
        facil.add_resposta('B', "Percussão", false);
        facil.add_resposta('C', "Corda", true);
        facil.add_resposta('D', "Repercussão", false);
        
        faceis.add(facil);
        
        //8
        facil = new Questao("Como Joana d’Arc foi morta?");
        
        facil.add_resposta('A', "Afogada", false);
        facil.add_resposta('B', "Decapitada", false);
        facil.add_resposta('C', "Enforcada", false);
        facil.add_resposta('D', "Queimada", true);
        
        faceis.add(facil);
        
        //Criação das questões médias
        
        //1
        media = new Questao("De quem é a frase “penso logo existo”?");
        
        media.add_resposta('A', "Descartes", true);
        media.add_resposta('B', "Sócrates", false);
        media.add_resposta('C', "Platão", false);
        media.add_resposta('D', "Galileu Galilei", false);
        
        medias.add(media);
        
        //2
        media = new Questao("Qual era o nome de Aleijadinho?");
        
        media.add_resposta('A', "Francisco Antonio Lisboa", false);
        media.add_resposta('B', "Antonio Francisco Lisboa", true);
        media.add_resposta('C', "Manuel Francisco Lisboa", false);
        media.add_resposta('D', "Alexandre Antonio Lisboa", false);
        
        medias.add(media);
        
        //3
        media = new Questao("Qual o segundo livro mais vendido do mundo?");
        
        media.add_resposta('A', "Bíblia", false);
        media.add_resposta('B', "O Pequeno Príncipe", false);
        media.add_resposta('C', "Dom Quixote", true);
        media.add_resposta('D', "O Senhor dos Anéis", false);
        
        medias.add(media);
        
        //4
        media = new Questao("Qual o pico mais alto do Brasil?");
        
        media.add_resposta('A', "Pico Paraná", false);
        media.add_resposta('B', "Monte Roraima", false);
        media.add_resposta('C', "Pico da Bandeira", false);
        media.add_resposta('D', "Pico da Neblina", true);
        
        medias.add(media);
        
        //5
        media = new Questao("Quem pintou o quadro 'La Gioconda'?");
        
        media.add_resposta('A', "Leonardo da Vinci", true);
        media.add_resposta('B', "Rafael", false);
        media.add_resposta('C', "Michelangelo", false);
        media.add_resposta('D', "Donatello", false);
        
        medias.add(media);
        
        //6
        media = new Questao("Quando começou e terminou a primeira guerra mundial?");
        
        media.add_resposta('A', "1939 - 1945", false);
        media.add_resposta('B', "1914 - 1919", true);
        media.add_resposta('C', "1921 - 1932", false);
        media.add_resposta('D', "1912 - 1915", false);
        
        medias.add(media);
        
        //7
        media = new Questao("A que categoria pertence o cavalo-marinho?");
        
        media.add_resposta('A', "Crustáceo", false);
        media.add_resposta('B', "Mamífero", false);
        media.add_resposta('C', "Peixe", true);
        media.add_resposta('D', "Molusco", false);
        
        medias.add(media);
        
        //8
        media = new Questao("Em qual espécie o macho choca os ovos e a fêmea procura alimento?");
        
        media.add_resposta('A', "Marreco", false);
        media.add_resposta('B', "Andorinha", false);
        media.add_resposta('C', "Pato Selvagem", false);
        media.add_resposta('D', "Pinguim", true);
        
        medias.add(media);
        
        //Criação das questões difíceis
        
        //1
        dificil = new Questao("Atualmente, quantos elementos químicos a tabela periódica possui?");
        
        dificil.add_resposta('A', "118", true);
        dificil.add_resposta('B', "120", false);
        dificil.add_resposta('C', "116", false);
        dificil.add_resposta('D', "115", false);
        
        dificeis.add(dificil);
        
        //2
        dificil = new Questao("De onde é a invenção do chuveiro elétrico?");
        
        dificil.add_resposta('A', "EUA", false);
        dificil.add_resposta('B', "Brail", true);
        dificil.add_resposta('C', "Reino Unido", false);
        dificil.add_resposta('D', "França", false);
        
        dificeis.add(dificil);
        
        //3
        dificil = new Questao("Em quais países está localizado o mar morto?");
        
        dificil.add_resposta('A', "Egito e Iraque", false);
        dificil.add_resposta('B', "Irã e Turquia", false);
        dificil.add_resposta('C', "Israel e Jordânia", true);
        dificil.add_resposta('D', "Israel e Egito", false);
        
        dificeis.add(dificil);
        
        //4
        dificil = new Questao("Em que ano ocorreu o incêndio do edifício joelma, em São Paulo?");
        
        dificil.add_resposta('A', "1992", false);
        dificil.add_resposta('B', "1954", false);
        dificil.add_resposta('C', "1982", false);
        dificil.add_resposta('D', "1974", true);
        
        dificeis.add(dificil);
    }
    
}
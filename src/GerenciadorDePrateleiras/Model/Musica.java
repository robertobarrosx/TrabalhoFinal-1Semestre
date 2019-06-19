package GerenciadorDePrateleiras.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Musica implements Serializable {
    private String nome;
    private ArrayList<String> compositores;
    private double duracao;

    public Musica(String nome,ArrayList<String> compositores,double duracao){
        this.nome = nome;
        this.compositores = compositores;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getCompositores() {
        return compositores;
    }

    public double getDuracao() {
        return duracao;
    }

    @Override
    public String toString(){

        String past = nome+" - ";
        boolean entrou = false;
        boolean entrou2 = false;

        for(String comp:compositores){
            if(entrou) {
                if(!entrou2) {
                    past += " ft. ";
                    entrou2 = true;
                }else{
                    past += ", ";
                }
            }
            past+= comp;
            entrou = true;
        }
        return past;
    }
//    public String toString() {
//        String past;
//        past = "Musica: "+nome;
//        boolean entrou = false;
//        if(compositores.size()>1)
//            past += " Compositores: ";
//        else past += " Compositor: ";
//        for(String comp:compositores){
//            if(entrou)
//                past+= ", ";
//            past+= comp;
//            entrou = true;
//        }
//            past += " Duração: "+duracao;
//
//
//       return past;
//    }
}

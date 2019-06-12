package GerenciadorDePalavras;

import GerenciadorDePalavras.Control.Gerenciador;
import GerenciadorDePalavras.Model.Album;
import GerenciadorDePalavras.Model.Autor;
import GerenciadorDePalavras.Model.Musica;
import GerenciadorDePalavras.Model.Prateleira;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gerenciador l = new Gerenciador();
        l.criarprateleiras();
//        for(Prateleira a:l.getPrateleiras()){
//            //System.out.println("Prateleira de "+a.getTipoItem()+ " N "+a.getNumero());
//           // a.imprimirLista();
//        }
        System.out.println("Buscar Album");
        ArrayList<Album> albuns = l.buscatAlbum("pedro");
        for(Album al:albuns)
            System.out.println(al);
        System.out.println("\nBuscar Musica");
        ArrayList<Musica> musicas = l.buscarMusica("lucio");
        for(Musica ms:musicas)
            System.out.println(ms);
        System.out.println("\nBuscar Autor");
        ArrayList<Autor> autores = l.buscarAutor("carlos");
        for(Autor at:autores)
            System.out.println(at);
    }
}

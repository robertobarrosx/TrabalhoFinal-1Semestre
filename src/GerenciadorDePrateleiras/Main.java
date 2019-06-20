package GerenciadorDePrateleiras;

import GerenciadorDePrateleiras.Model.Grip;
import GerenciadorDePrateleiras.Model.Prateleira;

public class Main {
    public static void main(String[] args) {
       // Grip l = new Grip();
       // l.criarprateleiras();
        for(Prateleira a: Grip.getInstance().getPrateleiras()){//
            System.out.println("Prateleira de "+a.getTipoItem()+ " N "+a.getNumero());
           // a.imprimirLista();
        }
//        System.out.println("Buscar Album");
//        ArrayList<Album> albuns = l.buscatAlbum("pedro");
//        for(Album al:albuns)
//            System.out.println(al);
//        System.out.println("\nBuscar Musica");
//        ArrayList<Musica> musicas = l.buscarMusica("lucio");
//        for(Musica ms:musicas)
//            System.out.println(ms);
//        System.out.println("\nBuscar Autor");
//        ArrayList<Autor> autores = l.buscarAutor("carlos");
//        for(Autor at:autores)
//            System.out.println(at);
    }
}

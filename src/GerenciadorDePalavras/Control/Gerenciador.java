package GerenciadorDePalavras.Control;

import GerenciadorDePalavras.Model.Autor;
import GerenciadorDePalavras.Model.Lugar;
import javafx.collections.ObservableList;

import java.io.Serializable;

public class Gerenciador implements Serializable {
    private ObservableList<Lugar> lugares;

    public void adicionarPrateleira(Lugar lugar){
        this.lugares.add(lugar);
    }
    public void removerPrateleira(Lugar lugar){
        this.lugares.remove(lugar);
    }
//    Manter (adicionar e remover) autor/banda: (Nome, Cidade de Origem, Ano de Nascimento)
//    Manter (adicionar e remover) de álbum: (Nome, Ano de Lançamento, Número de Músicas, Músicas, Autor/Banda)
//    Manter (adicionar e remover) de música: (Nome, Compositores, Duração)
//    Manter (adicionar,remover e atualizar) item: (Tipo (CD, k7, Vinil), Álbum, Posição nas Prateleiras)
//    Buscar autor/banda por nome
//    Buscar álbum por nome ou por autor/banda
//    Buscar música por nome ou compositores
//    Deve ser possível salvar e recuperar os dados de arquivo binário
//    Deve ser possível importar um conjunto inicial de dados a partir de um arquivo txt. O formato deve ser definido por você.

//    Chico possui 10 lugars que acomodam 100 vinis cada, 10 lugars que acomodam 200 cds cada e 10 lugars que acomodam 150 k7s cada.
//    A posição de cada item deve ser calculada automaticamente, indicando o número da prateleira (1..10) e também
//    a posição dentro da prateleira (1..n). A ordem dos itens deve ser a alfabética por nome do autor/banda, nome do álbum, ano de lançamento.

    public void AdicionarAutor(Autor autor){

    }
}

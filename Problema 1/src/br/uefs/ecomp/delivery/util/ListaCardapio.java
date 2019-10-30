/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  08/04/2019
 *
 * Declaro que este código foi elaborado por mim de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package br.uefs.ecomp.delivery.util;

import br.uefs.ecomp.delivery.model.Cardapio;

/** Classe que armazena em uma lista os itens que estão no cardápio do delivery. 
 * Esta classe possui métodos que adicionam e removem novos elementos, retorna o 
 * tamanho e se a lista está vazia, retorna um elemento específico da lista de 
 * itens do cardápio e mostra todos os elemetos da lista do cardápio.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class ListaCardapio extends MyLinkedList{

    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public ListaCardapio() {
    }
    
    /** Método que adiciona um novo elemento à lista de itens do cardápio.
     * 
     * @param card Cardapio - Elemento a ser adicionado na lista.
     */
    public void add(Cardapio card) {
        No atual;
        if(isEmpty()){
            No no = new No();
            no.setCd(card);
            primeiro = no;
            tamanho++;
        }
        else{
            No no = new No();
            no.setCd(card);
            atual = primeiro;
            while(atual.getProximo() != null){
                atual = atual.getProximo();
            }
            atual.setProximo(no);
            no.setProximo(null);
            tamanho++;
        }
    }
    
    /** Método que retorna um item do cardápio específico da lista do cardápio.
     * 
     * @param cd int - Número do item do cardápio que deseja ser buscado.
     * @return null - Se a lista estiver vazia, ou se o número digitado não
     * corresponder a nenhum item do cardápio; Cardapio - O item do cardápio 
     * desejado de acordo com o número inteiro passado como parâmetro.
     */
    @Override
    public Cardapio get(int cd) {
        if(isEmpty()|| cd < 0 || cd > this.tamanho - 1){
            return null;
        }
        else{
            No support = primeiro;
            int i = 0;
            while(support.getProximo() != null && i != cd){
                support = support.getProximo();
                i++;
            }
            return support.getCd();
        }
    }
    
    /** Método que mostra todos os elementos da lista de itens do cardápio.
     * 
     * @return String - Todos os elementos que estão na lista de itens do 
     * cardápio.
     */
    public String showCardapio(){
        No support = primeiro;
        String juntar;
        
        if(size() == 0 || size() < 0) 
            return null;
        else if(size() == 1){
            return support.getCd().getDescricao();
        }
        else{
            juntar = support.getCd().getDescricao();
            int i = 1;
            while(i < size() && support.getProximo() != null){
                support = support.getProximo();
                juntar = juntar + "\n" +support.getCd().getDescricao();
                i++;
            }
            return juntar;
        }
    }
}

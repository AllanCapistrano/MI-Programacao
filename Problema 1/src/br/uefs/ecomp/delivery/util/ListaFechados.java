/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  03/04/2019
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

import br.uefs.ecomp.delivery.model.Pedido;

/** Classe que armazena em uma lista os pedidos que já foram concluídos. Esta 
 * classe possui métodos que adiciona novos elementos, retorna um pedido que já
 * foi concluído específico, e retorna o tamanho e se a lista está vazia.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class ListaFechados extends MyLinkedList{
    
    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public ListaFechados(){
    }

    /** Método que adiciona um novo elemento à lista de pedidos concluídos.
     * 
     * @param ped Pedido - Elemento a ser adicionado na lista.
     */
    public void add(Pedido ped) {
        No atual;
        if(isEmpty()){
            No no = new No();
            no.setPed(ped);
            primeiro = no;
            tamanho++;
        }
        else{
            No no = new No();
            no.setPed(ped);
            atual = primeiro;
            while(atual.getProximo() != null){
                atual = atual.getProximo();
            }
            atual.setProximo(no);
            no.setProximo(null);
            tamanho++;
        }
    }

    /** Método que retorna um pedido concluído específico da lista de pedidos 
     * fechados.
     * 
     * @param ped int - Número do pedido que deseja ser buscado.
     * @return null - Se a lista estiver vazia, ou se o número digitado não
     * corresponder a nenhum pedido; Pedido - O pedido concluído desejado de 
     * acordo com o número inteiro passado como parâmetro.
     */
    @Override
    public Pedido get(int ped) {
        if(isEmpty() || ped < 0 || ped > this.tamanho - 1){
            return null;
        }
        else{
            No support = primeiro;
            int i = 0;
            while(support.getProximo() != null && i != ped){
                support = support.getProximo();
                i++;
            }
            return support.getPed();
        }
    }
}

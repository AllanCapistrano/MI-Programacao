/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  07/04/2019
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

import br.uefs.ecomp.delivery.model.ItemPedido;

/** Classe que armazena os itens que foram pedidos pelos clientes e os coloca em 
 * ordem, onde o primeiro a ser adicionado é o primeiro a sair. Esta classe 
 * possui métodos que adicionam novos elementos à fila, retorna o tamanho atual 
 * da fila e se a fila está vazia, retorna um elementos específico da fila de 
 * pedidos e o seu primeiro elemento.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class FilaItemPedido extends MyQueue{
    
    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public FilaItemPedido(){
    }
    
    /** Método que adiciona sempre um novo item pedido no final da fila.
     * 
     * @param ip ItemPedido - Elemento a ser adicionado na fila.
     */
    public void enqueue(ItemPedido ip){
        No aux;
        if(isEmpty()){
            No no = new No();
            no.setIpd(ip);
            primeiro = no;
            tamanho++;
        }
        else{
            No no = new No();
            no.setIpd(ip);
            aux = primeiro;
            while(aux.getProximo() != null){
                aux = aux.getProximo();
            }
            aux.setProximo(no);
            no.setProximo(null);
            tamanho++;
        }
    }
    
    /** Método que retorna um item pedido específico da fila dos pedidos.
     * 
     * @param item int - Número do item pedido que deseja ser buscado.
     * @return null - Se a fila estiver vazia, ou se o número digitado não
     * corresponder a nenhum item pedido; ItemPedido - O item pedido desejado 
     * de acordo com o número inteiro passado como parâmetro.
     */
    public ItemPedido get(int item) {
        if(isEmpty()|| item < 0 || item > tamanho - 1){
            return null;
        }
        else{
            No support = primeiro;
            int i = 0;
            while(support.getProximo() != null && i != item){
                support = support.getProximo();
                i++;
            }
            return support.getIpd();
        }
    }
    
    /** Método que retorna o primeiro elemento da fila dos pedidos.
     * 
     * @return No - O primeiro elemento da fila dos pedidos.
     */
    public No getFirst(){
        return primeiro;
    }
}

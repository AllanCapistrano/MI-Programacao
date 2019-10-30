/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  04/04/2019
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

/** Classe que armazena os pedidos que ainda estão sendo produzidos e os coloca 
 * em ordem, onde o primeiro pedido a ser adicionado é o primeiro a sair. Esta 
 * classe possui métodos que adicionam e removem elementos, retorna o primeiro 
 * e o último elemento da fila, retorna o tamanho da fila e se ela está vazia, 
 * além de acessar e alterar a fila de pedidos fechados.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class FilaPedidosAbertos extends MyQueue{
    private ListaFechados listaFechados;
    
    /**
     * Método construtor padrão que não recebe parâmetros, que instancia a lista
     * dos pedidos que já foram concluídos.
     */
    public FilaPedidosAbertos() {
        this.listaFechados = new ListaFechados();
    }

    /** Método que adiciona um novo elemento à fila dos pedidos.
     * 
     * @param ped Pedido - Elemento a ser adicionado na fila.
     */
    public void enqueue(Pedido ped) {
        if(isEmpty()){
            No no = new No();
            no.setPed(ped);
            primeiro = no;
            tamanho++;
        }
        else{
            No no = new No();
            no.setPed(ped);
            No support = primeiro;
            while(support.getProximo() != null){
                support = support.getProximo();
            }
            support.setProximo(no);
            no.setProximo(null);
            tamanho++;
        }
        
    }

    /** Método que remove o primeiro elemento da fila.
     * 
     * @return Pedido - O elemento que foi retirado da fila.
     */
    @Override
    public Pedido dequeue() {
        No support = primeiro;
        if(isEmpty() == true)
            return null;
        else{
            primeiro = primeiro.getProximo();
            tamanho--;
            return support.getPed();
        }
    }

    /** Método que retorna o primeiro elemento da fila.
     * 
     * @return Pedido - Primeiro elemento da fila.
     */
    @Override
    public Pedido peek() {
        return primeiro.getPed();
    }

    /** Método que retona o último elemento da fila.
     * 
     * @return Pedido - Último elemento da fila.
     */
    @Override
    public Pedido last() {
        No support = primeiro;
        while(support.getProximo() != null){
            support = support.getProximo();
        }
        return support.getPed();
    }

    /** Método que retorna a lista dos pedidos que já foram concluídos.
     * 
     * @return ListaFechados - Lista dos pedidos que já foram concluídos.
     */
    public ListaFechados getListaFechados() {
        return listaFechados;
    }
    
    /** Método que altera a lista dos pedidos que já foram concluídos.
     * 
     * @param listaFechados ListaFechados - Lista dos pedidos que já foram 
     * concluídos.
     */
    public void setListaFechados(ListaFechados listaFechados) {
        this.listaFechados = listaFechados;
    }
    
    /** Método que quando chamado, ou seja, quando o pedido já está pronto, 
     * retira-o da fila de pedidos aberto e adiciona-o na lista dos pedidos que 
     * já foram concluídos. 
     * 
     * @return No - O novo primeiro elemento da fila dos pedidos abertos.
     */
    public No setNexttoPedidoFechado(){
        No support = primeiro;
        int y = 0;
        
        while(support != null && y != 1){
            if(support.getPed().getSituacao()){ /*Se o pedido estiver aberto*/
                support.getPed().setFechado();
                listaFechados.add(support.getPed());
                dequeue();
                y++;
            }
            support = support.getProximo();
        }
        return primeiro;
    }
}

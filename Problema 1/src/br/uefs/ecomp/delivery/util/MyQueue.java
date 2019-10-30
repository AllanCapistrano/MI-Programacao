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

/** Classe que cria uma fila genérica. Esta classe possui métodos que adiciona
 * (enfileira) novos elementos, remove o primeiro elemento da fila 
 * (desenfileira), retorna o primeiro elemento da fila, retorna o último 
 * elemento da fila, retorna o tamanho e se a fila está vazia.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class MyQueue implements IQueue{
    protected No primeiro;
    protected int tamanho;
    
    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public MyQueue(){
    }
    
    /** Método que adiciona sempre um novo item pedido no final da fila.
     * 
     * @param data Object - Elemento a ser adicionado na fila.
     */
    @Override
    public void enqueue(Object data) {
        if(isEmpty()){
            No no = new No();
            no.setConteudo(data);
            primeiro = no;
            tamanho++;
        }
        else{
            No no = new No();
            no.setConteudo(data);
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
     * @return Object - O elemento que foi retirado da fila.
     */
    @Override
    public Object dequeue() {
        No support = primeiro;
        if(isEmpty() == true)
            return null;
        else{
            primeiro = primeiro.getProximo();
            tamanho--;
            return support.getConteudo();
        }
    }
    
    /** Método que retorna o primeiro elemento da fila.
     * 
     * @return Object - Primeiro elemento da fila.
     */
    @Override
    public Object peek() {
        return primeiro.getConteudo();
    }

    /** Método que retona o último elemento da fila.
     * 
     * @return Object - Último elemento da fila.
     */
    @Override
    public Object last() {
        No support = primeiro;
        while(support.getProximo() != null){
            support = support.getProximo();
        }
        return support.getConteudo();
    }

    /** Método que retorna o tamanho da fila.
     * 
     * @return int - Tamanho da lista.
     */
    @Override
    public int size() {
        return this.tamanho;
    }

    /** Método que indica se a fila está vazia.
     * 
     * @return true - caso a fila esteja vazia; false - caso contrário
     */
    @Override
    public boolean isEmpty() {
        return (tamanho == 0);
    }
}

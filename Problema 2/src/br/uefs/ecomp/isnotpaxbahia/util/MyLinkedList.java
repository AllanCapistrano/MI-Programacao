/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  20/06/2019
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
package br.uefs.ecomp.isnotpaxbahia.util;

import java.util.Iterator;

/** Classe que cria uma lista encadeada genéria. Esta classe possui métodos que
 * retorna o tamanho atual da lista, adiciona novos elementos no final da lista 
 * ou em uma posição específica, remove um elemento de uma posição específica, 
 * retorna um elemento de uma posição específica e retorna se a lista está vazia 
 * ou não, além do método iterator.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class MyLinkedList {
    protected No primeiro; /*Nó que tem referência para o primeiro elemento da lista*/
    protected No cauda; /*Nó que tem referência para o último elemento da lista*/
    protected int tamanho; /*Tamanho atual da lista*/
    
    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public MyLinkedList(){
    }

    /** Método que retorna o tamanho da lista.
     * 
     * @return int - Tamanho da lista.
     */
    public int size() {
        return this.tamanho;
    }

    /** Método que insere objeto ao final da lista.
     * 
     * @param obj Object - Elemento a ser inserido ao final da lista.
     */
    public void add(Object obj) {
        No no = new No();
        no.setConteudo(obj);
        
        if(isEmpty()){
            this.primeiro = no;
            this.cauda = no;
        }
        else{
            this.cauda.setProximo(no);
            this.cauda = no;
        }
        this.tamanho++;
    }

    /** Método que insere um objeto em uma determinada posição da lista, 
     * empurrando demais elementos para direita.
     * 
     * Posição 0 refere-se a primeira posição da lista.
     * 
     * @param pos int - A posição do objeto na lista, após a inserção. Deve ser 
     * um valor entre 0 e o tamanho da lista.
     * @param obj Object - Elemento a ser inserido na lista.
     * @return true - caso o objeto tenha sido inserido com sucesso; false- caso 
     * contrário.
     */
    public boolean add(int pos, Object obj) {
        No no = new No();
        no.setConteudo(obj);
        if(tamanho >= pos){
            if(isEmpty()){
                primeiro = no;
                tamanho++;
                return true;
            }
            else if(pos == 0){
                no.setProximo(primeiro);
                primeiro = no;
                tamanho++;
                return true;
            }
            else{
                No support = primeiro;
                No support2;
                int contador = 1;
                while(contador!= pos){
                    support = support.getProximo();
                    contador++;
                }
                support2 = support.getProximo();
                support.setProximo(no);
                no.setProximo(support2);
                tamanho++;
                return true;
                
            }
        }
        else{
            return false;
        }
    }

    /** Método que remove um objeto de uma determinada posição, deslocando 
     * demais elementos seguintes para esquerda.
     * 
     * @param pos int - A posição do objeto a ser removido.
     * @return null - Caso a lista esteja vazia ou pos seja menor que 0 (zero) 
     * e maior que o tamanho da lista; Object - o objeto removido.
     */
    public Object remove(int pos) {
        if(isEmpty() || pos < 0 || pos > tamanho - 1){
            return null;
        }
        else{
            No support = primeiro;
            No support2;
            if(pos == 0){
                primeiro = primeiro.getProximo();
                tamanho--;
                return support.getConteudo();
            }
            else{
                int contador = 1;
                while(contador != pos){
                    support = support.getProximo();
                    contador++;
                }
                support2 = support.getProximo();
                support.setProximo(support2.getProximo());
                tamanho--;
                return support2.getConteudo();
            }
        }
    }

    /** Método que retorna o objeto em uma determinada posição da lista, sem 
     * remove-lo.
     * 
     * @param index int - Número do objeto a ser recuperado.
     * @return Object - o objeto recuperado; null - caso a lista esteja vazia 
     * ou pos seja menor que 0 (zero) ou maior que o tamanho da lista.
     */
    public Object get(int index) {
        /*Caso a lista esteja vazia ou o número passado seja inválido*/
        if(isEmpty()|| index < 0 || index > this.tamanho - 1){
            return null;
        }
        else{
            No support = primeiro;
            int i = 0;
            while(support.getProximo() != null && i != index){
                support = support.getProximo();
                i++;
            }
            return support.getConteudo();
        }
    }

    /** Método que indica se a lista está vazia.
     * 
     * @return true - caso a lista esteja vazia; false - caso contrário
     */
    public boolean isEmpty() {
        return (tamanho == 0);
    }

    /** Método iterator que percorre a lista de clientes.
     * 
     * @return Iterator - O próprio iterator.
     */
    public Iterator iterator() {
        Iterator it = new Iterator() {
            No support = primeiro;
            No support2;
            
            /** Método que verifica se há um próximo elemento.
             * 
             * @return true - Se existir um próximo elemento; false - Se o 
             * próximo for nulo, ou seja, não existir próximo elemento.
             */
            @Override
            public boolean hasNext() {
                if(primeiro == null)
                    return false;
                else{
                    return support != null;
                }
            }

            /** Método que retorna o elemento atual que o iterator está 
             * apontando, e em seguida anda para o próximo elemento da lista.
             * 
             * @return Cliente - O cliente atual que o iterator está apontando.
             */
            @Override
            public Object next() {
                if(support == null) /*Se o atual já estiver no nulo*/
                    return null;
                else{
                    support2 = support;
                    support = support.getProximo();
                    return support2.getConteudo();
                }
            }
        };
        return it;
    }
}

/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  20/07/2019
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

import br.uefs.ecomp.isnotpaxbahia.model.Lote;

/** Classe que armazena os lotes em que os procedimentos e suas determinadas 
 * vagas estão contidos, e suas informações em uma lista. Esta classe possui 
 * métodos que adicionam novos lotes à lista, retornam e procuram um lote 
 * específico.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class ListaLote extends MyLinkedList{

    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public ListaLote() {
    }
    
    /** Método que adiciona um novo lote de forma ordenada pela data.
     * 
     * @param lote Lote - Elemento a ser adicionado na lista.
     */
    public void add(Lote lote){
        No no = new No();
        no.setLote(lote);
        
        /*Caso a lista esteja vazia*/
        if(isEmpty())
            this.primeiro = no;
        /*Caso a lista possua apenas um lote*/
        else if(this.tamanho == 1){
            No support = this.primeiro;
            
            /*Se a data do lote que deseja inserir seja maior que a data do lote
            que está na lista*/
            if(support.getLote().getData() <= no.getLote().getData()){
                support.setProximo(no);
                no.setProximo(null);
            }
            else{
                this.primeiro = no;
                no.setProximo(support);
            }
        }
        /*Caso o lote a ser adicionado possua uma data menor que a do primeiro
        lote atual*/
        else if(this.primeiro.getLote().getData() > no.getLote().getData()){
            No support = this.primeiro;
            
            this.primeiro = no;
            no.setProximo(support);
        }
        else{
            No support = this.primeiro;
            No support2 = support.getProximo();
            
            while(support2.getProximo() != null && support.getLote().getData() 
                    <= no.getLote().getData()){
                support2 = support2.getProximo();
                support = support.getProximo();
            }
            /*Se encontrou o último lote, e a data dele seja menor que a data
            do lote que será inserido*/
            if(support2.getProximo() == null && support2.getLote().getData() 
                    <= no.getLote().getData()){
                support2.setProximo(no);
                no.setProximo(null);
            }
            else{
                support.setProximo(no);
                no.setProximo(support2);
            }
        }
        this.tamanho++;
    }
    
    /** Método que retorna o lote em uma determinada posição da lista de lotes, 
     * sem remove-lo.
     * 
     * @param index int - Posição do lote na lista.
     * @return Lote - o lote recuperado; null - caso a lista esteja vazia 
     * ou a posição passada seja menor que 0 (zero), ou maior que o tamanho da 
     * lista.
     */
    @Override
    public Lote get(int index){
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
            return support.getLote();
        }
    }
    
    /** Método que busca na lista de lotes, um lote específico com base no id do 
     * procedimento desejado e a data do mesmo.
     * 
     * @param id int - Identificador do procedimento desejado.
     * @param data int - Data do procedimento desejado.
     * @return Lote - Lote que possui as informações passadas como parâmetro.
     */
    public Lote search(int id, int data){
        No support = this.primeiro;
        
        while(support != null){
            if(support.getLote().getId() == id && support.getLote().getData() == data){
                return support.getLote();
            }
            support = support.getProximo();
        }
        
        return null;
    }
    
}

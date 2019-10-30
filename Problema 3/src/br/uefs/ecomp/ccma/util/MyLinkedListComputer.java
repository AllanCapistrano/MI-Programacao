/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autores: <Kevin Cerqueira Gomes e Allan Capistrano de Santana Santos>
 * Data: <06/08/2019>
 *
 * Declaro que este código foi elaborado por nós de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */
package br.uefs.ecomp.ccma.util;

import br.uefs.ecomp.ccma.model.Computer;

/**
 * Classe responsável por armazenar os computadores cadastrados do sistema.
 *
 * @author Kevin e Allan
 */
public class MyLinkedListComputer extends MyLinkedList{
    
    /**
     * Retorna um objeto do tipo Computer em uma determinada posição na lista, 
     * sem remove-lo.
     * @param index posição do objeto a ser retornado.
     * @return Objeto recuperado da lista, ou null caso a lista esteja vazia ou 
     * se index (posição referente a lista) for maior que o size da lista ou 
     * menor que 0 (zero).
     */
    @Override
    public Computer get(int index) {
        if(firstLink == null || index > size -1 || index < 0) 
            return null;
        else if(index == 0)
            return (Computer) firstLink.getObj();
        else{
            Link aux = firstLink;
            for(int i = 0; i < index - 1; i++)
                aux = aux.getNext();
            return (Computer) aux.getNext().getObj();
        }
    }
    
    /**
     * Retorna um link em uma determinada posição na lista, sem remove-lo.
     * @param index posição do link a ser retornado.
     * @return Link recuperado da lista, ou null caso a lista esteja vazia ou 
     * se index (posição referente a lista) for maior que o size da lista ou 
     * menor que 0 (zero).
     */
    public Link getLink(int index) {
        if(firstLink == null || index > size - 1 || index < 0) 
            return null;
        else if(index == 0)
            return firstLink;
        else{
            Link aux = firstLink;
            for(int i = 0; i < index - 1; i++)
                aux = aux.getNext();
            return aux.getNext();
        }
    }
    
    /**
     * Remove um nó e o computador contido nele que está em uma determiada posição 
     * na lista.
     * @param pos posição do nó a ser removido.
     * @return Computador contido no nó removido ou null caso a lista esteja vazia 
     * ou se pos (posição referente a lista) for menor que 0 (zero) ou maior que
     * o size da lista.
     */
    @Override
    public Computer remove(int pos) {
        if(firstLink == null || pos > size - 1 || pos < 0)
            return null;
        else if(pos == 0){
            Object obj = firstLink.getObj();
            firstLink = firstLink.getNext();
            size--;
            return (Computer) obj;
        }else{
            Link current = firstLink;
            Link previous  = current;
            
            for(int i = 0; i < pos; i++){
                previous = current;
                current = current.getNext();
            }
            previous.setNext(current.getNext());
            size--;
            return (Computer) current.getObj();
        }
    }
    
    /**
     * Chama o metódo de ordenação (Selection Sort) da classe.
     */
    public void ordena(){
        this.selectionSort(this);
    }
    
    /**
     * Metódo de ordenação desta lista. Ordena de forma decrescente, usando como
     * parametro o espaço livre, os computadores que estão na lista.
     * @param list Lista encadeada a ser ordenada.
     */
    private void selectionSort(MyLinkedListComputer list) {
        for (int fixo = 0; fixo < list.size - 1; fixo++) {
            int menor = fixo;

            for (int i = menor + 1; i < list.size(); i++)
                if (list.get(i).getFreeSize() > list.get(menor).getFreeSize())
                    menor = i;
                
            if (menor != fixo) {
                Computer t = list.get(fixo);
                list.getLink(fixo).setObj(list.get(menor));
                list.getLink(menor).setObj(t);
            }
        }
    }
    
    /**
     * Procura um computador na lista pelo seu Hostname.
     * @param hostname hostname do computador a ser procurado.
     * @return null, caso a lista esteja vazia ou se o hostname não for 
     * encontrado, caso contrário, retorna o objeto computador.
     */
    public Computer search(String hostname){
        if(this.isEmpty()) return null;
        Link aux = this.firstLink;
        while(aux != null){
            if(((Computer) aux.getObj()).getHostName().equals(hostname))
                return (Computer) aux.getObj();
            aux = aux.getNext();
        }
        return null;
    }
}

/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autores: <Kevin Cerqueira Gomes e Allan Capistrano de Santana Santos>
 * Data:  <11/08/2019>
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

/**
 * Classe responsável por gerenciar a lista de nomes de images do computador.
 *
 * @author Kevin e Allan
 */
public class MyLinkedListImage extends MyLinkedList{
    
    /**
     * Adiciona um novo nome de imagem a um nó que será adicionado no final 
     * da lista.
     * @param nameImage novo nome a ser adcionado ao nó.
     */
    public void add(String nameImage) {
        Link newLink = new Link(nameImage);

        if(this.isEmpty()){
            this.firstLink = newLink;
            this.lastLink = newLink;
        }
        else{
            this.lastLink.setNext(newLink);
            this.lastLink = newLink;
        }
        this.size++;
    }
    
    /**
     * Retorna um objeto do tipo String em uma determinada posição na lista, 
     * sem remove-lo.
     * @param index posição do objeto a ser retornado.
     * @return Objeto recuperado da lista, ou null caso a lista esteja vazia ou 
     * se index (posição referente a lista) for maior que o size da lista ou 
     * menor que 0 (zero).
     */
    @Override
    public String get(int index) {
        if(firstLink == null || index > size -1 || index < 0) 
            return null;
        else if(index == 0)
            return (String) firstLink.getObj();
        else{
            Link aux = firstLink;
            for(int i = 0; i < index - 1; i++)
                aux = aux.getNext();
            return (String) aux.getNext().getObj();
        }
    }
    
    /**
     * Remove um nó e a String contido nele que está em uma determiada posição 
     * na lista.
     * @param name nome da imagem a ser removida da lista.
     * @return String contido no nó removido ou null caso a lista esteja vazia 
     * ou se pos (posição referente a lista) for menor que 0 (zero) ou maior que
     * o size da lista.
     */
    public String remove(String name){
        if(isEmpty() || this.firstLink == null)
            return null;
        else{
            Link support = this.firstLink;
            Link support2 = this.firstLink.getNext();
            
            if(name.equals((String)support.getObj())){
                
                this.firstLink = this.firstLink.getNext();
                this.size--;
                return (String)support.getObj();
            }
            else{
                while(support2 != null){
                    if(name.equals((String)support2.getObj())){
                        support.setNext(support2.getNext());
                        this.size--;
                        return (String)support.getObj();
                    }
                    support2 = support2.getNext();
                }
            }
        }
        return null;
    }
    
    /**
     * Procura um nome de image na lista.
     * @param name nome da imagem a ser procurada.
     * @return false, caso a lista esteja vazia ou se o nome não for 
     * encontrado. true, caso contrário.
     */
    public boolean search(String name){
        if(this.isEmpty()) 
            return false;
        
        Link aux = this.firstLink;
        while(aux != null){
            if(((String) aux.getObj()).equals(name))
                return true;
            aux = aux.getNext();
        }
        return false;
    }
}

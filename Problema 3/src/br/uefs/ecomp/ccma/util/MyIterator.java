/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autores: <Kevin Cerqueira Gomes e Allan Capistrano>
 * Data:  <02/07/2019>
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
package br.uefs.ecomp.ccma.util;

import java.util.Iterator;

/**
 * Classe responsável por percorrer uma lista de forma sequencial, sempre 
 * retornando o objeto referenciado pelo nó.
 * @author Kevin e Allan
 */
public class MyIterator implements Iterator {
    private Link current;
    
    /**
     * Construtor da classe, que inicializa o valor do atributo.
     * @param firstLink primeiro nó da lista que será percorrida.
     */
    public MyIterator(Link firstLink){
        current = firstLink;
    }
    
    /**
     * Verifica se há um próximo nó na lista.
     * @return true, caso haja um próximo nó ou false, se não houver.
     */
    @Override
    public boolean hasNext() {
        return current != null;
    }
    
    /**
     * Retorna o objeto que está contido no nó, e avança um nó à frente.
     * @return O objeto referenciado pelo nó.
     */
    @Override
    public Object next() {
        if(current == null) return null;
        Object obj = current.getObj();
        current = current.getNext();
        return obj;
    }
}

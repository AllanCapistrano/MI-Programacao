/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autores: <Kevin Cerqueira Gomes e Allan Capistrano>
 * Data:  <18/08/2019>
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
 * Classe de exceção responsável pelo erro de tentar inserir uma imagem após 
 * a capacidade de disco dos computadores estarem esgotadas.
 *
 * @author Kevin e Allan
 */
public class FullDiskException extends Exception{
    
    /**
     * Construtor da classe de exceção. Chama a função "super()", que chama o 
     * construtor da classe pai dessa.
     */
    public FullDiskException(){
        super();
    }
    
    /**
     * Metódo que retorna o erro da exceção.
     * @return "Capacidade de disco esgotada!" caso aconteça a exceção.
     */
    @Override
    public String toString(){
        return "Capacidade de disco esgotada!";
    }
}

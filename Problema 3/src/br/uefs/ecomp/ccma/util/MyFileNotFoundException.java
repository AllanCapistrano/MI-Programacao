/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autores: <Kevin Cerqueira Gomes e Allan Capistrano>
 * Data:  <05/08/2019>
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

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  Classe responsável por fazer a exceção do erro de Arquivo não encontrado.
 * @author Kevin e Allan
 */
public class MyFileNotFoundException extends IOException{
    
    public MyFileNotFoundException(){
        super();
    }
    
    @Override
    public String toString(){
        return "Arquivo não encontrado!";
    }
}

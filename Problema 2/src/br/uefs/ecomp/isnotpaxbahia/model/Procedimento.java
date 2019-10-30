/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  11/07/2019
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

package br.uefs.ecomp.isnotpaxbahia.model;

/** Classe abstrata usada para fazer herança nas classes Conslta e Exame, pois
 * ambas as classes citadas anteriormente possuem informações em comum.
 *
 * @author Allan Capistrano de Santana Santos
 */
public abstract class Procedimento {
    protected int id; /*Identificador único do procedimento*/
    protected Medico medico; /*Médico que realizou o procedimento*/

    /** Método que retorna o identificador de um procedimento.
     * 
     * @return int - Indentificador único de uma consulta ou exame.
     */
    public int getId() {
        return id;
    }

    /** Método que retorna o médico que realizou o procedimento.
     * 
     * @return Medico - Médico que realizou uma consulta ou exame.
     */
    public Medico getMedico() {
        return medico;
    }
    
}

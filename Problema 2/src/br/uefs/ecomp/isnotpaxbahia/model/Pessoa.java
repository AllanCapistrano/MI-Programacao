/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  10/07/2019
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

/** Classe abstrata usada para fazer herança nas classes Paciente, Atendente e 
 * Médico, pois ambas as classes citadas anteriormente possuem informações em
 * comum.
 *
 * @author Allan Capistrano de Santana Santos
 */
public abstract class Pessoa {
    protected String nome; /*Nome da pessoa*/
    protected int anoNascimento; /*Ano de nascimento da pessoa*/
    protected String sexo; /*Sexo da pessoa*/
    protected String telefone; /*Telefone para contato da pessoa*/

    /** Método que retorna o nome da pessoa (paciente, médico ou atendente).
     * 
     * @return String - Nome da pessoa.
     */
    public String getNome() {
        return nome;
    }

    /** Método que retorna o ano de nascimento da pessoa (paciente, médico ou 
     * atendente).
     * 
     * @return int - Ano de nascimento.
     */
    public int getAnoNascimento() {
        return anoNascimento;
    }

    /** Método que retorna o sexo da pessoa (paciente, médico ou atendente).
     * 
     * @return String - Sexo da pessoa.
     */
    public String getSexo() {
        return sexo;
    }

    /** Método que retorna o telefone para contato da pessoa (paciente, médico 
     * ou atendente).
     * 
     * @return String - Telefone da pessoa.
     */
    public String getTelefone() {
        return telefone;
    }
    
    
    
}

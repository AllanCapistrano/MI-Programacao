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

/** Classe que contêm as informações da consulta, tais como médico(a) que 
 * realizou, identificador (único) da consulta.
 * Além de possuir métodos para comparar essas informações e para retornar a 
 * especialidade do médico que realizou a consultata. 
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Consulta extends Procedimento{
    
    /** Método construtor que incializa as variáveis id e medico.
     * 
     * @param id int - Identificador único de uma consulta.
     * @param medico Medico - Médico(a) que relizou esta consulta.
     */
    public Consulta(int id, Medico medico){
        this. id = id;
        this.medico = medico;
    }

    /** Método que retorna a especialidade do médico(a) que relizou a consulta.
     * 
     * @return String - Especialidade do médico(a) que realizou a consulta.
     */
    public String getEspecialidade() {
        return medico.getEspecialidade();
    }
    
    /** Método que compara o identificador da consulta e o/a médico(a) da 
     * consulta com os da consulta que é passada como parâmetro.
     * 
     * @param c Consulta - Consulta contendo suas informações.
     * @return true - Se a comparação for verdadeira; false - Se a comparação 
     * for falsa.
     */
     public boolean equals(Consulta c){
         return this.id == c.getId() &&
                 this.medico.equals(medico);
     } 
}

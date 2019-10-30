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

/** Classe que contêm as informações da consulta, tais como médico(a) 
 * que realizou, identificador (único), recomendação e restrição do examme.
 * Além de possuir métodos para comparar essas informações, e de retornar e 
 * modificar as recomendações e restrições do exame.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Exame extends Procedimento{
    private String recomendacao;
    private String restricao;

    /** Método construtor que incializa as variáveis recomendacao, restricao, 
     * id e medico.
     * 
     * @param recomendacao String - Recomendação para a realização de um exame 
     * passado por um médico.
     * @param restricao String - Restrição para a realização de um exame passado
     * por um médico.
     * @param id int - Identificador único de um exame.
     * @param medico Medico - Médico(a) que relizou esse exame.
     */
    public Exame(String recomendacao, String restricao, int id, Medico medico){
        this.recomendacao = recomendacao;
        this.restricao = restricao;
        this. id = id;
        this.medico = medico;
    }
    
    /** Método que retorna a recomendação passada por um(a) médico(a).
     * 
     * @return String - Recomendação passada por um(a) médico(a), 
     * para a realização do exame.
     */
    public String getRecomendacao() {
        return this.recomendacao;
    }

    /** Método que modifica a recomendação passada por um(a) médico(a).
     * 
     * @param recomendacao String - Recomendação passada por um(a) médico(a), 
     * para a realização do exame.
     */
    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    /** Método que retorna a restrição passada por um(a) médico(a).
     * 
     * @return String - Restrição passada por um(a) médico(a), 
     * para a realização do exame.
     */
    public String getRestricao() {
        return this.restricao;
    }

    /** Método que modifica a restrição passada por um(a) médico(a).
     * 
     * @param restricao String - Restrição passada por um(a) médico(a), 
     * para a realização do exame.
     */
    public void setRestricao(String restricao) {
        this.restricao = restricao;
    }
    
    /** Método que compara o identificador do exame, o/a médico(a), a 
     * recomendação e a restrição do exame, com os do exame que é passado como 
     * parâmetro.
     * 
     * @param ex Exame - Exame contendo suas informações.
     * @return true - Se a comparação for verdadeira; false - Se a comparação 
     * for falsa.
     */
    public boolean equals(Exame ex){
         return this.id == ex.getId() &&
                 this.medico.equals(medico) &&
                 this.recomendacao.equals(ex.recomendacao) &&
                 this.restricao.equals(ex.restricao);
     }
}

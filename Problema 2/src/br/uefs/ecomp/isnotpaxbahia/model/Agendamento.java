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

/** Classe que contêm as informações do agendamento, tais como a data para a 
 * realização do procedimento desejado, as informações do paciente, as 
 * informações da atendente que realizou o agendamento, o procedimento desejado, 
 * e posteriormente guarda as informações de se o paciente estava presente do 
 * dia de realizar o procedimento, e a prioridade do mesmo.
 * Possuindo métodos para retornar e mudar essas informações
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Agendamento {
    private int data;
    private Paciente paciente;
    private Atendente atendente;
    private Procedimento procedimento;
    private boolean situacao; /*Situação se o paciente estava presente (true)
            ou não (false) no dia marcado para a realização do procedimento*/
    private int prioridade; /*Prioridade do/da paciente*/

    /** Método construtor que inicializa as variáveis data, paciente, atendente,
     * procedimento, além de iniciar a prioridade como 0 (zero) e a situação 
     * como falsa (false).
     * 
     * @param data int - Data para a realização do procedimento.
     * @param paciente Paciente - Paciente que será agendado.
     * @param atendente Atendente - Atendente que realizou o agendamento.
     * @param procedimento Procedimento - O procedimento que o paciente irá 
     * realizar, podendo ser uma consulta ou um exame.
     */
    public Agendamento(int data, Paciente paciente, Atendente atendente, 
            Procedimento procedimento) {
        this.data = data;
        this.paciente = paciente;
        this.atendente = atendente;
        this.procedimento = procedimento;
        this.prioridade = 0;
        this.situacao = false;
    }

    /** Método que retorna a data que irá ser realizado o procedimento.
     * 
     * @return int - Data para a realização do procedimento.
     */
    public int getData() {
        return this.data;
    }

    /** Método que retorna o paciente que será agendado.
     * 
     * @return Paciente - Paciente que será agendado.
     */
    public Paciente getPaciente() {
        return this.paciente;
    }

    /** Método que retorna a atendente que realizou o agendamento.
     * 
     * @return Atendente - Atendente que realizou o agendamento.
     */
    public Atendente getAtendente() {
        return atendente;
    }
    
    /** Método que retorna o procedimento que o paciente deseja realizar.
     * 
     * @return Procedimento - O procedimento que o paciente irá realizar, 
     * podendo ser uma consulta ou um exame.
     */
    public Procedimento getProcedimento() {
        return procedimento;
    }
    
    /** Método que retorna a situação do agendamento.
     * 
     * @return true - Paciente estava presente no dia | false - Paciente não 
     * compareceu.
     */
    public boolean isSituacao() {
        return situacao;
    }
    
    /** Método que modifica a situação do agendamento.
     * 
     * @param situacao true - Paciente estava presente no dia | false - paciente 
     * não compareceu.
     */
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    /** Método que retorna a prioridade do paciente.
     * 
     * @return 5 - Idosos com mais de 80 anos | 4 - Deficientes | 3 - Idosos |
     * 2 - Grávidas | 1 - Todos que não se enquadram em nenhum grupo prioritário
     */
    public int getPrioridade() {
        return prioridade;
    }

    /** Método que modifica a prioridade do paciente.
     * 
     * @param prioridade 5 - Idosos com mais de 80 anos | 4 - Deficientes 
     * | 3 - Idosos | 2 - Grávidas | 1 - Todos que não se enquadram em nenhum 
     * grupo prioritário
     */
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    
}

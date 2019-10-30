/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  19/07/2019
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
package br.uefs.ecomp.isnotpaxbahia.util;

import br.uefs.ecomp.isnotpaxbahia.model.Agendamento;
import br.uefs.ecomp.isnotpaxbahia.model.Lote;
import br.uefs.ecomp.isnotpaxbahia.model.Paciente;

/** Classe que cria o nó para as listas encadeadas, além de possuir métodos que 
 * auxiliam no momento de acessar e modificar os elementos nas listas.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class No {
    private No proximo; /*Referência para o próximo elemento da lista*/
    private Object conteudo; /*Conteúdo que será adicionado na lista genérica 
    (MyLinkedList)*/
    private Lote lote; /*Conteúdo que será adicionado na lista de lotes*/
    private Agendamento agendamento; /*Conteúdo que será adicionado na lista de 
    agendamentos, lista de espera e lista do histórico*/
    private Paciente paciente; /*Conteúdo que será adicionado na lista de 
    pacientes cadastrados*/
    
    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public No(){
    }

    /** Método que retorna o próximo elemento da lista.
     * 
     * @return No - Próximo elemento da lista.
     */
    public No getProximo() {
        return proximo;
    }

    /** Método que altera o próximo elemento da lista.
     * 
     * @param proximo No - Próximo elemento da lista.
     */
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    /** Método que retorna um itenm da lista genérica (MyLinkedList).
     * 
     * @return Object - Item da lista genérica.
     */
    public Object getConteudo() {
        return conteudo;
    }

    /** Método que altera um itenm da lista genérica (MyLinkedList).
     * 
     * @param conteudo Object - Item da lista genérica.
     */
    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    /** Método que retorna um lote da lista de lotes.
     * 
     * @return Lote - Elemento da lista de lotes.
     */
    public Lote getLote() {
        return lote;
    }

    /** Método que altera um lote da lista de lotes.
     * 
     * @param lote Lote - Elemento da lista de lotes.
     */
    public void setLote(Lote lote) {
        this.lote = lote;
    }

    /**Método que retorna um agendamento da lista de agendamentos ou da lista de
     * espera ou da lista do histórico, depende de onde é chamado.
     * 
     * @return Agendamento - Agendamento da lista de agendamentos ou da lista de
     * espera ou da lista do histórico, depende de onde é chamado.
     */
    public Agendamento getAgendamento() {
        return agendamento;
    }

    /**Método que altera um agendamento da lista de agendamentos ou da lista de
     * espera ou da lista do histórico, depende de onde é chamado.
     * 
     * @param agendamento Agendamento - Agendamento da lista de agendamentos ou 
     * da lista de espera ou da lista do histórico, depende de onde é chamado.
     */
    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    /** Método que retorna um paciente da lista de pacientes cafastrados.
     * 
     * @return Paciente - Paciente da lista de pacientes.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /** Método que altera um paciente da lista de pacientes cafastrados.
     * 
     * @param paciente Paciente - Paciente da lista de pacientes.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
}

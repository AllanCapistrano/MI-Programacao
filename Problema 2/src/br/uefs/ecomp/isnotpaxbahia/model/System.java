/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  15/07/2019
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

import br.uefs.ecomp.isnotpaxbahia.util.ListaAgendamento;
import br.uefs.ecomp.isnotpaxbahia.util.ListaEspera;
import br.uefs.ecomp.isnotpaxbahia.util.ListaHistorico;
import br.uefs.ecomp.isnotpaxbahia.util.ListaLote;
import br.uefs.ecomp.isnotpaxbahia.util.ListaPaciente;


/** Classe que contêm as informações a respeito de todas as listas encadeadas 
 * utilizadas para armazenar as informações do programa, tais como lista com os 
 * lotes, lista com os agendamentos, lista da espera do dia, lista com o 
 * histórico dos procedimentos realizados e lista com os pacientes cadastrados 
 * no sistema.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class System {
    private ListaLote lote; /*Lista com os lotes disponíveis*/
    private ListaAgendamento agendamentos; /*Lista com todos os agendamentos*/
    private ListaEspera listaEspera; /*Lista de espera do dia*/
    private ListaHistorico historico; /*Lista com o histórico dos procedimentos realizados até o momento*/
    private ListaPaciente pacientes; /*Lista com os pacientes cadastrados no sistema*/
    
    /**
     * Método construtor padrão que não recebe parâmetros, que instancia as 
     * lista com os lotes, lista com os agendamentos, lista da espera do dia, 
     * lista com o histórico dos procedimentos realizados e a lista com os 
     * pacientes cadastrados no sistema.
     * 
     */
    public System(){
        lote = new ListaLote();
        agendamentos = new ListaAgendamento();
        listaEspera = new ListaEspera();
        historico = new ListaHistorico();
        pacientes = new ListaPaciente();
    }

    /** Método que retorna a lista de lotes dos procedimentos.
     * 
     * @return ListaLote - Lista com os lotes dos procedimentos.
     */
    public ListaLote getLote() {
        return lote;
    }

    /** Método que retorna a lista de agendamentos.
     * 
     * @return ListaAgendamento - Lista com todos os agendamentos.
     */
    public ListaAgendamento getAgendamentos() {
        return agendamentos;
    }

    /** Método que retorna a lista de espera daquele dia.
     * 
     * @return ListaEspera - Lista com os agendamentos marcados para aquele dia.
     */
    public ListaEspera getListaEspera() {
        return listaEspera;
    }

    /** Método que retorna a lista de histórico.
     * 
     * @return ListaHistorico - Lista com o agendamento dos pacientes que 
     * realizaram algum procedimento.
     */
    public ListaHistorico getHistorico() {
        return historico;
    }
    

    /** Método que retorna a lista de pacientes.
     * 
     * @return ListaPaciente - Lista com todos os pacientes cadastrados.
     */
    public ListaPaciente getPacientes() {
        return pacientes;
    }
    
    /** Método que agenda um paciente cadastrado no sistema em um procedimento 
     * desejado e na data desejada, caso exista vagas disponíveis.
     * 
     * @param data int - Data que o paciente deseja realizar o procedimento.
     * @param pac Paciente - Paciente cadastrado no sitema.
     * @param atd Atendente - Atendente que realizou o agendamento.
     * @param id int - Identificador da consulta ou exame que o paciente deseja.
     * @return String - "Procedimento indisponível para data escolhida" caso a 
     * data desejada não possua o procedimento desejado, ou seja inválida. | 
     * String - "Procedimento esgotado" caso não existam mais vagas para o 
     * procedimento desejado. | String - "Procedimento confirmado!" caso seja 
     * possível agendar o procedimento na data desejada pelo paciente.
     */
    public String agendarPaciente(int data, Paciente pac, Atendente atd, int id){
        /*Data inválida ou não exista o procedimento naquela data*/
        if(this.lote.search(id, data) == null){
            return "Procedimento indisponível para data escolhida";
            
        }
        /*Não há mais vagas para aquele procedimentos*/
        else if(this.lote.search(id, data).getQuantidade() == 0){
            return "Procedimento esgotado";
        }
        /*Tudo certo para realizar o agendamento*/
        else{
            Agendamento novoAgd = new Agendamento(data, pac, atd, this.lote
                    .search(id, data).getProcedimento());
            this.agendamentos.add(novoAgd);
            this.lote.search(id, data).setQuantidade(this.lote.search(id, data)
                    .getQuantidade() - 1);
            return "Procedimento confirmado!";
        }
        
    }
    
    /** Método que agenda um paciente NÃO cadastrado no sistema em um 
     * procedimento desejado e na data desejada, caso exista vagas disponíveis.
     * 
     * @param nome String - Nome do/da paciente.
     * @param anoNascimento int - Ano de nascimento.
     * @param sexo String - Sexo do/da paciente.
     * @param telefone String - Telefone para contato.
     * @param numeroPlano  int - Número do plano do/da paciente.
     * @param data int - Data que o paciente deseja realizar o procedimento.
     * @param atd Atendente - Atendente que realizou o agendamento.
     * @param id int - Identificador da consulta ou exame que o paciente deseja.
     * @return String - "Procedimento indisponível para data escolhida" caso a 
     * data desejada não possua o procedimento desejado, ou seja inválida. | 
     * String - "Procedimento esgotado" caso não existam mais vagas para o 
     * procedimento desejado. | String - "Procedimento confirmado!" caso seja 
     * possível agendar o procedimento na data desejada pelo paciente.
     */
    public String agendarPaciente(String nome, int anoNascimento, String sexo, 
            String telefone, int numeroPlano, int data, Atendente atd, int id){
        Paciente pac = new Paciente(nome, anoNascimento, sexo, telefone, 
                numeroPlano);
        
        this.pacientes.add(pac); /*Adiciona o paciente na lista de pacientes*/
        
        /*Data inválida ou não exista o procedimento naquela data*/
        if(this.lote.search(id, data) == null){
            return "Procedimento indisponível para data escolhida";
            
        }
        /*Não há mais vagas para aquele procedimentos*/
        else if(this.lote.search(id, data).getQuantidade() == 0){
            return "Procedimento esgotado";
        }
        /*Tudo certo para realizar o agendamento*/
        else{
            Agendamento novoAgd = new Agendamento(data, pac, atd, this.lote
                    .search(id, data).getProcedimento());
            this.agendamentos.add(novoAgd);
            this.lote.search(id, data).setQuantidade(this.lote.search(id, data)
                    .getQuantidade() - 1);
            return "Procedimento confirmado!";
        }
        
    }
    
    /** Método que chama o próximo paciente da lista de espera de um 
     * procedimento específico; retira o paciente que estava sendo atendido, da 
     * lista de espera do dia; coloca o agendamento do paciente no histórico.
     * 
     * @param id int - Identificador do procedimento que deseja chamar o próximo
     * paciente.
     * @param data int - Data do dia que está ocorrendo os exames e as consultas
     * @return Agendamento - O Agendamento do paciente que estava sendo atendido
     */
    public Agendamento proximoPaciente(int id, int data){
        Agendamento agd = this.listaEspera.chamarPaciente(id, data);
        if(agd == null)
            return null;
        this.historico.add(agd);
        return agd;
    }
    
}

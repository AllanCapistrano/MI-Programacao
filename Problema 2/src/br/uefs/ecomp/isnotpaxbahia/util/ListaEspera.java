/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  21/07/2019
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

/** Classe que armazena os pacientes que irão realizar algum procedimento e suas
 * informações em uma lista, e são ordenados com base na sua prioridade (fila de
 * prioridade). Esta classe possui métodos que adiconam novos pacientes à lista,
 * removem um paciente da lista e chamam os pacientes que são os próximos a 
 * realizarem algum procedimento.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class ListaEspera extends MyLinkedList{

    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public ListaEspera() {
    }
    
    /** Método que adiciona de forma ordenada com base na prioridade (fila de
     * prioridade) os agendamentos na lista.
     * 
     * @param agd Agendamento - Agendamento que deseja inserir na lista.
     * @param prioridade int - Prioridade do paciente do novo agendamento que 
     * será inserido. 5 - Idosos com mais de 80 anos | 4 - Deficientes 
     * | 3 - Idosos | 2 - Grávidas | 1 - Todos que não se enquadram em nenhum 
     * grupo prioritário.
     */
    public void add(Agendamento agd, int prioridade){
        No no = new No();
        no.setAgendamento(agd);
        agd.setPrioridade(prioridade);
        
        if(isEmpty()) /*Se a lista estiver vazia*/
            this.primeiro = no;
        else if(this.tamanho == 1){ /*Se tiver apenas um paciente*/
            No support = this.primeiro;
            
            /*Caso o paciente que deseja inserir tenha prioridade menor ou igual 
            do que a do paciente que já está na lista*/
            if(support.getAgendamento().getPrioridade() >= no.getAgendamento()
                    .getPrioridade()){
                support.setProximo(no);
                no.setProximo(null);
            }
            /*Caso o paciente que deseja inserir tenha prioridade maior do que o
            do paciente que já está na lista*/
            else{
                this.primeiro = no;
                no.setProximo(support);
            }
        }
        /*Se o paciente que deseja inserir tenha prioridade maior do que o do
        primeiro paciente da lista*/
        else if(this.primeiro.getAgendamento().getPrioridade() < 
                no.getAgendamento().getPrioridade()){
            No support = this.primeiro;
                
            this.primeiro = no;
            no.setProximo(support);
        }
        else{
            No support = this.primeiro;
            No support2 = support.getProximo();
            
            while(support2.getProximo() != null && support2.getAgendamento()
                    .getPrioridade() >= no.getAgendamento().getPrioridade()){
                support2 = support2.getProximo();
                support = support.getProximo();
            }
            
            /*Se encontrou o último pacicente e a priorade dele é maior ou igual
            a do paciente que deseja inserir*/
            if(support2.getProximo() == null && support2.getAgendamento()
                    .getPrioridade() >= no.getAgendamento().getPrioridade()){
                support2.setProximo(no);
                no.setProximo(null);
            }
            else{
                support.setProximo(no);
                no.setProximo(support2);
            }
        }
        this.tamanho++;
    }
    
    /** Método que retira um determinado paciente e seu agendamento da lista de 
     * espera.
     * 
     * @param agd Agendamento - Agendamento do paciente que se deseja remover da
     * lista de espera.
     * @return Agendamento - O agendamento do paciente que acabou de ser 
     * retirado da lista.
     */
    private Agendamento remove(Agendamento agd){
        No support = this.primeiro;
        
        if(isEmpty())
            return null;
        else if(this.primeiro.getAgendamento() == agd){
            this.primeiro = this.primeiro.getProximo();
            this.tamanho--;
            return support.getAgendamento();
        }
        else{
            No support2 = support.getProximo();
            
            while(support2 != null && support2.getAgendamento() != agd){
                support2 = support2.getProximo();
                support = support.getProximo();
            }
            
            if(support2 == null){
                return null;
            }
            support.setProximo(support2.getProximo());
            this.tamanho--;
            return support2.getAgendamento();
        }
    }
    
    /** Método que chama o próximo paciente da lista de espera do procedimento 
     * que acabou de ser liberado, e remove esse paciente da lista de espera.
     * 
     * @param id int - Identificador único do procedimento que foi liberado.
     * @param data int - Data do dia que está acontecendo os procedimentos.
     * @return Agendamento - O agendamento em que o próximo paciente da lista de
     * espera está.
     */
    public Agendamento chamarPaciente(int id, int data){
        No support = this.primeiro;
        
        if(isEmpty()) /*Se a lista estiver vazia*/
            return null;
        
        while(support != null){
            if(support.getAgendamento().getData() == data && support.
                    getAgendamento().getProcedimento().getId() == id){
                support.getAgendamento().setSituacao(true);
                /*Retira o paciente da lista de espera e retorna o seu agendamento*/
                return this.remove(support.getAgendamento()); 
            }
            support = support.getProximo();
        }
        return null;
    }
    
}

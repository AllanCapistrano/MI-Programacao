/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  20/07/2019
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
import br.uefs.ecomp.isnotpaxbahia.model.Medico;
import br.uefs.ecomp.isnotpaxbahia.model.Paciente;
import br.uefs.ecomp.isnotpaxbahia.model.Procedimento;
import java.util.Iterator;

/** Classe que armazena os agendamentos que foram realizados em uma lista. Esta
 * classe possui métodos que adicionam novos agendamentos realizados à lista, 
 * procuram esses agendamentos com base no paciente ou no procedimento realizado
 * ou no médico que realizou o procedimento e retornam um agendamento específico,
 * com base na sua posição na lista, além do método iterator.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class ListaHistorico extends MyLinkedList{

    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public ListaHistorico() {
    }
    
    /** Método que insere um agendamento que foi relizado ao final da lista.
     * 
     * @param agd Agendamento - Elemento a ser inserido ao final da lista.
     */
    public void add(Agendamento agd) {
        No no = new No();
        no.setAgendamento(agd);
        
        if(isEmpty()){
            this.primeiro = no;
            this.cauda = no;
        }
        else{
            this.cauda.setProximo(no);
            this.cauda = no;
        }
        this.tamanho++;
    }
    
    /** Método que retorna um agendamento que foi realizado de uma determinada 
     * posição da lista do histórico, sem remove-lo.
     * 
     * @param index int - Posição do agendamento na lista.
     * @return Agendamento - O agendamento recuperado; null - caso a lista esteja 
     * vazia ou a posição passada seja menor que 0 (zero), ou maior que o 
     * tamanho da lista.
     */
    @Override
    public Agendamento get(int index){
        /*Caso a lista esteja vazia ou o número passado seja inválido*/
        if(isEmpty()|| index < 0 || index > this.tamanho - 1){
            return null;
        }
        else{
            No support = primeiro;
            int i = 0;
            while(support.getProximo() != null && i != index){
                support = support.getProximo();
                i++;
            }
            return support.getAgendamento();
        }
    }
    
    /** Método que busca na lista de histórico um paciente específico.
     * 
     * @param pac Paciente - Paciente que deseja buscar no histórico.
     * @return Agendamento - Agendamento que está na lista de histórico que  
     * possui o paciente passado no parâmetro e as informações do(s) 
     * agendamento(s) em que mesmo está presente.
     */
    public Iterator search(Paciente pac){
        No support = this.primeiro;
        ListaHistorico temp = new ListaHistorico();
        
        while(support != null){
            if(support.getAgendamento().getPaciente() == pac && support
                    .getAgendamento().isSituacao() == true){
                temp.add(support.getAgendamento());
            }
            support = support.getProximo();
        }
        return temp.iterator();
    }
    
    /** Método que busca na lista de histórico um procedimento específico.
     * 
     * @param proc Procedimento - Procedimento que deseja buscar no histórico.
     * @return Agendamento - Agendamento que está na lista de histórico que  
     * possui o procedimento passado no parâmetro e as informações do(s) 
     * agendamento(s) em que o mesmo está presente.
     */
    public Iterator search(Procedimento proc){
        No support = this.primeiro;
        ListaHistorico temp = new ListaHistorico();
        
        while(support != null){
            if(support.getAgendamento().getProcedimento() == proc && support
                    .getAgendamento().isSituacao() == true){
                temp.add(support.getAgendamento());
            }
            support = support.getProximo();
        }
        return temp.iterator();
    }
    
    /** Método que busca na lista de histórico um médico específico.
     * 
     * @param med Medico - Médico que deseja buscar no histórico.
     * @return Agendamento - Agendamento que está na lista de histórico que  
     * possui o médico passado no parâmetro e as informações do(s) 
     * agendamento(s) que o mesmo está presene.
     */
    public Iterator search(Medico med){
        No support = this.primeiro;
        ListaHistorico temp = new ListaHistorico();
        
        while(support != null){
            if(support.getAgendamento().getProcedimento().getMedico() == med){
                temp.add(support.getAgendamento());
            }
            support = support.getProximo();
        }
        return temp.iterator();
    }
    
    /** Método iterator que percorre a lista de agendamentos.
     * 
     * @return Iterator - O próprio iterator.
     */
    @Override
    public Iterator iterator() {
        Iterator it = new Iterator() {
            No support = primeiro;
            No support2;
            
            /** Método que verifica se há um próximo elemento.
             * 
             * @return true - Se existir um próximo elemento; false - Se o 
             * próximo for nulo, ou seja, não existir próximo elemento.
             */
            @Override
            public boolean hasNext() {
                if(primeiro == null)
                    return false;
                else{
                    return support != null;
                }
            }

            /** Método que retorna o elemento atual que o iterator está 
             * apontando, e em seguida anda para o próximo elemento da lista.
             * 
             * @return Agendamento - O agendamento atual que o iterator está 
             * apontando.
             */
            @Override
            public Object next() {
                if(support == null) /*Se o atual já estiver no nulo*/
                    return null;
                else{
                    support2 = support;
                    support = support.getProximo();
                    return support2.getAgendamento();
                }
            }
        };
        return it;
    }
    
}

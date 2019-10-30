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
import java.util.Iterator;

/** Classe que armazena os agendamentos e suas informações em uma lista. Esta 
 * classe possui métodos que adicionam novos agendamentos à lista, procuram um 
 * agendamento que o paciente não pôde comparecer, além do método iterator.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class ListaAgendamento extends MyLinkedList{

    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public ListaAgendamento() {
    }
    
    /** Método que insere um agendamento ao final da lista.
     * 
     * @param agd Agendamento - Agendamento a ser inserido ao final da lista.
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
    
    /** Método que busca agendamento(s) em que os pacientes não puderam 
     * comparecer com base na data, e lista-o(s).
     * 
     * @param data int - Data que deseja procurar.
     * @return Iterator - Lista com o(s) agendamento(s) dos pacientes ausentes 
     * que tiver/tiverem marcado(s) para aquela data.
     */
    public Iterator searchPacientesAusentes(int data){
        No support = this.primeiro;
        ListaAgendamento temp = new ListaAgendamento(); /*Lista Temporária*/
        
        while(support != null){
            if(support.getAgendamento().getData() == data && support.
                    getAgendamento().isSituacao() == false){
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

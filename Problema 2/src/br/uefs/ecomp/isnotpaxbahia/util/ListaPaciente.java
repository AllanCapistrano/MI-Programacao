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

import br.uefs.ecomp.isnotpaxbahia.model.Paciente;

/**Classe que armazena os pacientes e suas informações em uma lista. Esta classe
 * possui métodos que adicionam novos pacientes à lista, retornam um paciente 
 * com base na sua posição na lista, e procura um paciente específico com base 
 * no número do plano do mesmo.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class ListaPaciente extends MyLinkedList{

    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public ListaPaciente() {
    }
    
    /** Método que insere um novo paciente ao final da lista.
     * 
     * @param pac Paciente - Paciente a ser inserido ao final da lista.
     */
    public void add(Paciente pac) {
        No no = new No();
        no.setPaciente(pac);
        
        if(isEmpty()){ /*Se a lista estiver vazia*/
            this.primeiro = no;
            this.cauda = no;
        }
        else{ /*Caso contrário adiciona sempre no final da lista.*/
            this.cauda.setProximo(no);
            this.cauda = no;
        }
        this.tamanho++;
    }
    
    /** Método que retorna um paciente de uma determinada posição da lista de 
     * pacientes, sem remove-lo.
     * 
     * @param index int - Posição do paciente na lista.
     * @return Paciente - O paciente recuperado; null - caso a lista esteja vazia 
     * ou a posição passada seja menor que 0 (zero), ou maior que o tamanho da 
     * lista.
     */
    @Override
    public Paciente get(int index) {
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
            return support.getPaciente();
        }
    }
    
    /** Método que busca na lista de pacientes um paciente específico com base 
     * no número do plano do mesmo.
     * 
     * @param numPlano int - Número do plano do paciente que deseja buscar na 
     * lista.
     * @return Paciente - Paciente que possui o número do plano igual ao que foi
     * passado como parâmetro.
     */
    public Paciente search(int numPlano){
        No support = this.primeiro;
        
        while(support != null){
            if(support.getPaciente().getNumeroPlano() == numPlano)
                return support.getPaciente();
            support = support.getProximo();
        }
        return null;
    }
    
}

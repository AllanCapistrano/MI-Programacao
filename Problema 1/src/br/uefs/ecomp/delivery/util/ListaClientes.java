/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  20/06/2019
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
package br.uefs.ecomp.delivery.util;

import java.util.Iterator;
import br.uefs.ecomp.delivery.model.Cliente;

/** Classe que armazena os clientes e suas informações em uma lista. Esta classe 
 * possui métodos que adicionam novos elementos, retorna um elemento específico 
 * da lista de clientes, retorna o tamanho e se a lista está vazia, retorna o 
 * primeiro elemento da lista, remove o cliente da lista com base no seu número
 * de telefone e busca um cliente pelo seu nome ou número de telefone, além do 
 * método iterator.
 * 
 * @author Allan Capistrano de Santana Santos
 */
public class ListaClientes extends MyLinkedList{
    
    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public ListaClientes(){
    }

    /** Método que adiciona um novo elemento à lista de clientes.
     * 
     * @param cl Cliente - Elemento a ser adicionado na lista.
     */
    public void add(Cliente cl) {
        No atual;
        if(isEmpty()){
            No no = new No();
            no.setCl(cl);
            primeiro = no;
            tamanho++;
        }
        else{
            No no = new No();
            no.setCl(cl);
            atual = primeiro;
            while(atual.getProximo() != null){
                atual = atual.getProximo();
            }
            atual.setProximo(no);
            no.setProximo(null);
            tamanho++;
        }
    }

    /** Método que retorna um cliente específico da lista de clientes.
     * 
     * @param cl int - Número do cliente que deseja ser buscado.
     * @return null - Se a lista estiver vazia, ou se o número digitado não
     * corresponder a nenhum cliente; Cliente - O cliente desejado de acordo com 
     * o número inteiro passado como parâmetro.
     */
    @Override
    public Cliente get(int cl) {
        if(isEmpty()|| cl < 0 || cl > this.tamanho - 1){
            return null;
        }
        else{
            No support = primeiro;
            int i = 0;
            while(support.getProximo() != null && i != cl){
                support = support.getProximo();
                i++;
            }
            return support.getCl();
        }
    }
    
    /** Método iterator que percorre a lista de clientes.
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
             * @return Cliente - O cliente atual que o iterator está apontando.
             */
            @Override
            public Object next() {
                if(support == null) /*Se o atual já estiver no nulo*/
                    return null;
                else{
                    support2 = support;
                    support = support.getProximo();
                    return (Cliente) support2.getCl();
                }
            }
        };
        return it;
    }
    
    /** Método que retorna o primeiro elemteno da lista de clientes.
     * 
     * @return No - Primeiro elemento da lista.
     */
    public No getFirst(){
        return primeiro;
    }

    /** Método que remove um cliente da lista com base no seu número de 
     * telefone. Obs: Remove apenas se o cliente não tiver nenhum pedido
     * associado no momento.
     * 
     * @param phone String - Número do telefone do cliente que deseja remover.
     */
    public void removeByPhone(String phone){
        No support = primeiro;
        No support2 = primeiro.getProximo();
        
        if(support.getPed() == null){ /*Se não houverem pedidos associados*/
            if(phone.equals(primeiro.getCl().getPhone())){
                primeiro = primeiro.getProximo();
                tamanho--;
            }
            else{
                while(support2 != null){
                    if(phone.equals(support2.getCl().getPhone())){
                        support.setProximo(support2.getProximo());
                        tamanho--;
                    }
                    support = support.getProximo();
                    support2 = support2.getProximo();
                }
            }
        }
        
    }
    
    /** Método que busca cliente(s) com base no nome, e lista todos os
     * clientes que tiverem esse nome.
     * 
     * @param name String - Nome que deseja procurar.
     * @return Iterator - Lista com o(s) cliente(s) que possui/possuem aquele 
     * nome.
     */
    public Iterator searchClientebyName(String name){
        No support = primeiro;
        ListaClientes temp = new ListaClientes(); /*Lista temporária*/
        
        while(support.getProximo() != null){
            if(support.getCl().getName().contains(name)){
                temp.add(support.getCl());
            }
            support = support.getProximo();
        }
        return temp.iterator();
        
    }
    
    /** Método que busca cliente(s) com base no número de telefone, e lista 
     * todos os clientes que tiverem esse número de telefone.
     * 
     * @param phone String - Número de telefone que deseja procurar.
     * @return Iterator - Lista com o(s) cliente(s) que possui/possuem aquele 
     * número de telefone.
     */
    public Iterator searchClientebyPhone(String phone){
        No support = primeiro;
        ListaClientes temp = new ListaClientes(); /*Lista temporária*/
        
        while(support != null){
            if(support.getCl().getPhone().contains(phone)){
                temp.add(support.getCl());
            }
            support = support.getProximo();
        }
        return temp.iterator();
    }
}

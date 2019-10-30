/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  07/04/2019
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
package br.uefs.ecomp.delivery.model;

import br.uefs.ecomp.delivery.util.No;
import java.util.Iterator;

import br.uefs.ecomp.delivery.util.ListaCardapio;
import br.uefs.ecomp.delivery.util.ListaFechados;
import br.uefs.ecomp.delivery.util.FilaPedidosAbertos;
import br.uefs.ecomp.delivery.util.ListaClientes;

/** Classe que chama e retorna as listas e filas do cardápio, clientes e 
 * pedidos, para posteriormente as mesmas possam ser alteradas, com adição e 
 * remoção de itens por exemplo. Além de possuir métodos que retornam listas e 
 * filas, esta classe possui o método iterador.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class System {
    private No primeiro;
    private ListaClientes clientes;
    private ListaCardapio cardapio;
    private FilaPedidosAbertos pedidosAbertos;
    private ListaFechados pedidosFechados;

    /**
     * Método construtor padrão que não recebe parâmetros, que instancia a lista
     * de clientes, a lista de cardápios, a fila dos pedidos que estão sendo
     * preparados, e a lista dos pedidos que estão prontos.
     */
    public System() {
        this.clientes = new ListaClientes();
        this.cardapio = new ListaCardapio();
        this.pedidosAbertos = new FilaPedidosAbertos();
        this.pedidosFechados = new ListaFechados();
    }
    
    /** Método que retorna a lista de clientes.
     * 
     * @return ListaClientes - Lista de clientes do delivery.
     */
    public ListaClientes getClientes() {
        return clientes;
    }
    
    /** Método que retorna a lista de itens do cardápio.
     * 
     * @return ListaCardapio - Lista de itens do cardápio do delivery.
     */
    public ListaCardapio getCardapio() {
        return cardapio;
    }
    
    /** Método que retorna a fila dos pedidos que ainda estão sendo preparados.
     * 
     * @return FilaPedidosAbertos - Fila dos pedidos que estão sendo preparados.
     */
    public FilaPedidosAbertos getPedidosAbertos() {
        return pedidosAbertos;
    }

    /** Método que retorna a lista dos pedidos que foram conluídos.
     * 
     * @return ListaFechados - Lista dos pedidos que já estão prontos.
     */
    public ListaFechados getPedidosFechados() {
        pedidosFechados = pedidosAbertos.getListaFechados();
        return pedidosFechados;
    }
    
    /** Método iterator que percorre a lista de clientes.
     * 
     * @return Iterator - O próprio iterator.
     */
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
}

/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  01/04/2019
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

import br.uefs.ecomp.delivery.model.ItemPedido;
import br.uefs.ecomp.delivery.model.Cliente;
import br.uefs.ecomp.delivery.model.Cardapio;
import br.uefs.ecomp.delivery.model.Pedido;

/** Classe que cria o nó tanto para as listas quanto para as filas, além de 
 * possuir métodos que auxiliam na hora de acessar e modificar os elementos nas 
 * listas e nas filas.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class No {
    private Object conteudo;
    private No proximo;
    private ItemPedido ipd;
    private Cliente cl;
    private Cardapio cd;
    private Pedido ped;
    
    /**
     * Método construtor padrão que não recebe parâmetros.
     */
    public No(){
    }
    
    /** Método que retorna os itens da lista ou fila, depende de onde é chamado.
     * 
     * @return Object - Itens da lista ou da fila.
     */
    public Object getConteudo() {
        return conteudo;
    }

    /** Método que altera os itens da lista ou da fila, depende de onde é 
     * chamado.
     * 
     * @param conteudo Object - Itens da lista ou da fila.
     */
    public void setConteudo(Object conteudo) {
        this.conteudo = conteudo;
    }

    /** Método que retorna o próximo elemento da lista ou da fila, depende de 
     * onde é chamado.
     * 
     * @return No - Próximo elemento da lista ou da fila.
     */
    public No getProximo() {
        return proximo;
    }

    /** Método que altera o próximo elemento da lista ou da fila, depende de 
     * onde é chamado.
     * 
     * @param proximo No - Novo próximo elemento da lista ou da fila.
     */
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    /** Método que retorna o item da fila dos itens pedidos.
     * 
     * @return ItemPedido - Item da fila dos itens pedidos.
     */
    public ItemPedido getIpd() {
        return ipd;
    }

    /** Método que altera o item da fila dos itens pedidos.
     * 
     * @param ipd ItemPedido - Item da fila dos itens pedidos.
     */
    public void setIpd(ItemPedido ipd) {
        this.ipd = ipd;
    }

    /** Método que retorna o cliente da lista dos clientes.
     * 
     * @return Cliente - Cliente da lista dos clientes.
     */
    public Cliente getCl() {
        return cl;
    }

    /** Método que altera o cliente da lista dos clientes.
     * 
     * @param cl Cliente - Cliente da lista dos clientes.
     */
    public void setCl(Cliente cl) {
        this.cl = cl;
    }

    /** Método que retorna o item do cardápio que está na lista do cardápio.
     * 
     * @return Cardapio - Item do cardápio que está na lista do cardápio.
     */
    public Cardapio getCd() {
        return cd;
    }

    /** Método que altera o item do cardápio que está na lista do cardápio.
     * 
     * @param cd Cardapio - Item do cardápio que está na lista do cardápio.
     */
    public void setCd(Cardapio cd) {
        this.cd = cd;
    }

    /** Método que retorna o pedido que está na fila dos pedidos abertos ou na 
     * lista dos pedidos concluídos (fechados), depende de onde é chamado.
     * 
     * @return Pedido - Pedido que está na fila dos pedidos abertos ou na lista
     * dos pedidos concluídos.
     */
    public Pedido getPed() {
        return ped;
    }

    /** Método que altera o pedido que está na fila dos pedidos abertos ou na 
     * lista dos pedidos concluídos (fechados), depende de onde é chamado.
     * 
     * @param ped Pedido - Pedido que está na fila dos pedidos abertos ou na 
     * lista dos pedidos concluídos (fechados).
     */
    public void setPed(Pedido ped) {
        this.ped = ped;
    }
}

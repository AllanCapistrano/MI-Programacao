/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  23/04/2019
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

import java.util.Date;
import br.uefs.ecomp.delivery.util.FilaItemPedido;
import br.uefs.ecomp.delivery.util.No;

/** Classe que contêm as informações do pedido do cliente, como as próprias 
 * informações do cliente, data e hora do pedido, endereço para a entrega,
 * situação do pedido e o valor total ser pago pelo cliente. Possuindo métodos
 * que retornam e alteram essas informações.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Pedido {
    private Cliente cliente;
    private Date dataHora;
    private String endereco;
    private boolean situacao;
    private FilaItemPedido itens;
    private double valorTotal;
    private boolean fechado;

    /** Método construtor que inicializa as variáveis cliente, dataHora, 
     * endereco e situacao;
     * 
     * @param cliente Cliente - Cliente que realizou o pedido.
     * @param dataHora Date - Data e hora que o pedido foi realizado.
     * @param endereco String - Endereço para onde o pedido será entregue.
     * @param situacao boolean - Situação em que o pedido está (true - O pedido 
     * está sendo feito; false - O pedido está pronto).
     */
    public Pedido(Cliente cliente, Date dataHora, String endereco, 
            boolean situacao) {
        this.cliente = cliente;
        this.dataHora = dataHora;
        this.endereco = endereco;
        this.situacao = situacao;
        this.itens = new FilaItemPedido();
    }

    /** Método que retorna o cliente e as suas informações.
     * 
     * @return Cliente - Cliente e suas informações.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /** Método que retorna a data e hora que o pedido foi feito.
     * 
     * @return Date - Data e hora em que o pedido foi feito.
     */
    public Date getDataHora() {
        return dataHora;
    }

    /** Método que retorna o endereço para onde será entegue o pedido.
     * 
     * @return String - Endereço para onde o pedido será entregue.
     */
    public String getEndereco() {
        return endereco;
    }

    /** Método que altera o endereço para onde o pedido será entregue.
     * 
     * @param endereco String - Endereço para onde o pedido será entregue.
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /** Método que retorna a situação atual do pedido.
     * 
     * @return true - Pedido em andamento; false - Pedido está pronto.
     */
    public boolean getSituacao() {
        return situacao;
    }

    /** Método que altera a situação atual do pedido.
     * 
     * @param situacao true - Pedido em andamento; false - Pedido está pronto.
     */
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    /** Método que retorna os pedidos que estão na fila de pedidos.
     * 
     * @return FilaPedidos - Pedidos que estão na fila.
     */
    public FilaItemPedido getItens(){
        return this.itens;
    }

    /** Método que retorna o valor total a ser pago pelo cliente.
     * 
     * @return double - Valor a ser pago pelo cliente.
     */
    public double getValorTotal() {
        No support = itens.getFirst();
        double soma = 0.0;
        while(support != null){
            valorTotal = support.getIpd().getQuantidade() * support.getIpd()
                    .getOpcaoMenu().getValor();
            soma = soma + valorTotal;
            support = support.getProximo();
        }
        return soma;
    }

    /**
     * Método que altera a situação do pedido, ou seja, quando chamado, altera
     * a situação de "Pedido em andamento" para "Pedido está pronto".
     */
    public void setFechado() {
        if(getSituacao()){
            setSituacao(false);
        }
    }
}

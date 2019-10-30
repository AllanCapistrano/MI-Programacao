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

/** Classe que contêm as informações do item pedido pelo cliente, como o as 
 * informações do pedido; a opção do menu onde este item está; a quantidade; e 
 * se o cliente deseja fazer alguma observação a respeito deste item, como por  
 * exemplo, o cliente deseja retirar algum ingrediente específico ou algo do 
 * tipo. Possuindo métodos que retornam e alteram essas informações.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class ItemPedido {
    private Pedido pedido;
    private Cardapio opcaoMenu;
    private int quantidade;
    private String observacao;

    /** Método construtor que inicializa as variáveis opcaoMenu, quantidade e 
     * observacao.
     * 
     * @param opcaoMenu Cardapio - Opção do cardápio onde este item está 
     * localizado.
     * @param quantidade int - quantidade do item pedido.
     * @param observacao String - Observação a respeito do item pedido.
     */
    public ItemPedido(Cardapio opcaoMenu, int quantidade, 
            String observacao) {
        this.opcaoMenu = opcaoMenu;
        this.quantidade = quantidade;
        this.observacao = observacao;
    }

    /** Método que retorna o pedido feito pelo cliente.
     * 
     * @return Pedido - Pedido do cliente.
     */
    public Pedido getPedido() {
        return pedido;
    }

    /** Método que altera o pedido feito pelo cliente, além de adicionar esse
     * pedido à fila de pedidos.
     * 
     * @param pedido Pedido - Pedido do cliente.
     */
    public void setPedido(Pedido pedido){
        this.pedido = pedido;
        pedido.getItens().enqueue(this);
    }

    /** Método que retorna a opção do cardápio onde o item pedido pelo cliente 
     * está localizado.
     * 
     * @return Cardapio - Opção onde se encontra o item pedido.
     */
    public Cardapio getOpcaoMenu() {
        return opcaoMenu;
    }

    /** Método que retorna a quantidade do item pedido pelo cliente.
     * 
     * @return int - Quantidade do item pedido.
     */
    public int getQuantidade() {
        return quantidade;
    }

    /** Método que altera a quantidade do item pedido pelo cliente.
     * 
     * @param quantidade int - Quantidade do item pedido.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /** Método que retorna a observação a respeito do item pedido pelo cliente.
     * 
     * @return String - Observação sobre o item pedido.
     */
    public String getObservacao() {
        return observacao;
    }

    /** Método que altera a observação a respeito do item pedido pelo cliente.
     * 
     * @param observacao String - Observação sobre o item pedido.
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}

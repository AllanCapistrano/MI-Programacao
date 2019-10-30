/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  30/03/2019
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

/** Classe que contêm as informações dos itens do cardápio, como a descrição e 
 * o valor do prato. Possuindo métodos que podem retornar, alterar e comparar 
 * essas informações.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Cardapio {
    private String descricao;
    private double valor;
    
    /** Método construtor que inicializa as variáveis descricao e valor.
     * 
     * @param descricao String - Descrição do prato.
     * @param valor double - Valor do prato.
     */
    public Cardapio(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
    
    /** Método que retorna a descrição do prato que está no cardápio.
     * 
     * @return String - Descrição do prato.
     */
    public String getDescricao() {
        return descricao;
    }
    
    /** Método que altera a descrição do prato que está no cardápio.
     * 
     * @param descricao String - Descrição do prato.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /** Método que retorna o valor do prato que está no cardápio.
     * 
     * @return double - Valor do prato.
     */
    public double getValor() {
        return valor;
    }

    /** Método que altera o valor do prato que está no cardápio.
     * 
     * @param valor double - Valor do prato.
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    /** Método que compara a descrição e o valor do prato com as do cardápio 
     * passado como parâmetro.
     * 
     * @param c Cardapio - Cardápio contendo a descrição e o valor dos pratos.
     * @return true - Se a comparação for verdadeira; false - Se a comparação 
     * for falsa.
     */
    public boolean equals(Cardapio c){
        return this.descricao.equals(c.getDescricao()) 
                && this.valor == c.getValor();
    }
}

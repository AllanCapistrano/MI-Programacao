/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  11/07/2019
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

package br.uefs.ecomp.isnotpaxbahia.model;


/** Classe contendo as informações do lote, tais como a quantidade de vagas, 
 * data, identificador (único) de um exame ou consulta, e o procedimento (exame 
 * ou consulta).
 * Além de possuir métodos para retornar e modificar essas informações.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Lote {
    private int quantidade;
    private int data; /*mês data ex: 0714(14 de julho), 0723(23 de julho)*/
    private int id;
    private Procedimento procedimento;

    /** Método construtor que inicializa as variáveis quantidade, data, id e 
     * procedimento.
     * 
     * @param quantidade int - Quantidade de vagas disponíveis para determinado
     * procedimento (exame ou consulta).
     * @param data int - Data para a realização do procedimento (exame ou 
     * consulta).
     * @param id int - Indentificador único de uma consulta ou exame.
     * @param procedimento Procedimento - Procedimento que será disponibilizado,
     * podendo ser um exame ou uma consulta.
     */
    public Lote(int quantidade, int data, int id, Procedimento procedimento) {
        this.quantidade = quantidade;
        this.data = data;
        this.id = id;
        this.procedimento = procedimento;
    }

    /** Método que retorna a quantidade de vagas.
     * 
     * @return int - Quantidade de vagas disponíveis para determinado
     * procedimento (exame ou consulta).
     */
    public int getQuantidade() {
        return quantidade;
    }

    /** Método que modifica a quantidade de vagas.
     * 
     * @param quantidade int - Quantidade de vagas disponíveis para determinado
     * procedimento (exame ou consulta).
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /** Método que retorna a data que o procedimento está disponível para 
     * realização.
     * 
     * @return int - Data para a realização de determinado procedimento (exame 
     * ou consulta).
     */
    public int getData() {
        return data;
    }

    /** Método que retorna o identificador de um procedimento.
     * 
     * @return int - Indentificador único de uma consulta ou exame.
     */
    public int getId() {
        return id;
    }

    /** Método que retorna o procedimento.
     * 
     * @return Procedimento - Procedimento que será disponibilizado, podendo 
     * ser um exame ou uma consulta.
     */
    public Procedimento getProcedimento() {
        return procedimento;
    }
    
}

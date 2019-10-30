/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  10/07/2019
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

/** Classe que contêm as informações do/da atendente, tais como nome, ano de 
 * nascimento, sexo, telefone e um número de identificação único.
 * Possuindo métodos para retornar e comparar essas informações.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Atendente extends Pessoa{
    private int identificacao;
    
    /** Método construtor que inicializa as variáveis nome, anoNascimento, sexo,
     * telefone e identificação.
     * 
     * @param nome String - Nome do/da atendente.
     * @param anoNascimento int - Ano de nascimento.
     * @param sexo String - Sexo do/da atendente.
     * @param telefone String - Telefone para contato.
     * @param identificacao int - Número de identificação (único) do/da atendente
     */
    public Atendente(String nome, int anoNascimento, String sexo, 
            String telefone, int identificacao) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.identificacao = identificacao;
    }

    /** Método que retorna o número de identificação do/da atendente.
     * 
     * @return int - Número de identificação (único) do/da atendente.
     */
    public int getIdentificacao() {
        return identificacao;
    }
    
    /** Método que compara o nome, ano de nascimento, sexo, telefone e número
     * de identificação do/da atendente com os do/da atendente que é passado 
     * como parâmetro.
     * 
     * @param a Atendente - Atendente contendo suas informações.
     * @return true - Se a comparação for verdadeira; false - Se a comparação 
     * for falsa.
     */
    public boolean equals(Atendente a){
        return this.nome.equals(a.getNome()) && 
                this.anoNascimento == a.getAnoNascimento() && 
                this.sexo.equals(a.getSexo()) &&
                this.telefone.equals(a.getTelefone()) &&
                this.identificacao == identificacao;
    }
}

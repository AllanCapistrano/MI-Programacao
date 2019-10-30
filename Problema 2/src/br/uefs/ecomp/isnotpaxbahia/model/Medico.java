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

/** Classe que contêm as informações do/da médico(a), tais como nome, ano de 
 * nascimento, sexo, telefone para contato, especialidade e número de 
 * identificação único.
 * Possuindo métodos para retornar e comparar essas informações.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Medico extends Pessoa{
    private String especialidade;
    private int identificacao;

    /** Método construtor que inicializa as variáveis nome, anoNascimento, sexo,
     * telefone, especialidade e identificação.
     * 
     * @param nome String - Nome do/da médico(a).
     * @param anoNascimento int - Ano de nascimento.
     * @param sexo String - Sexo do/da médico(a).
     * @param telefone String - Telefone para contato.
     * @param especialidade String - Especialidade do/da médico(a).
     * @param identificacao int - Número de identificação (único) do/da médico(a)
     */
    public Medico(String nome, int anoNascimento, String sexo, 
            String telefone, String especialidade, int identificacao){
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.identificacao = identificacao;
    }

    /** Método que retorna a especialidade do/da médico(a).
     * 
     * @return String - Especialidade do/da médico(a).
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /** Método que modifica a especialidade do/da médico(a).
     * 
     * @param especialidade String - Especialidade do/da médico(a).
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /** Método que retorna o número de identificação do/da médico(a).
     * 
     * @return int - Número de identificação (único) do/da médico(a).
     */
    public int getIdentificacao() {
        return identificacao;
    }
    
    /** Método que compara o nome, ano de nascimento, sexo, telefone, 
     * especialidade e númerode identificação do/da médico(a) com os do/da 
     * médico(a) que é passado como parâmetro.
     * 
     * @param m Medico - Médico(a) contendo suas informações.
     * @return true - Se a comparação for verdadeira; false - Se a comparação 
     * for falsa.
     */
    public boolean equals(Medico m){
        return this.nome.equals(m.getNome()) && 
                this.anoNascimento == m.getAnoNascimento() && 
                this.sexo.equals(m.getSexo()) &&
                this.telefone.equals(m.getTelefone()) &&
                this.especialidade.equals(m.getEspecialidade()) &&
                this.identificacao == identificacao;
    }
}

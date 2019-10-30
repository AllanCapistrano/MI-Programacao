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

/** Classe que contêm as informações do/da paciente, tais como nome, ano de 
 * nascimento, sexo, telefone e o número do plano.
 * Possuindo métodos para retornar e comparar essas informações.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Paciente extends Pessoa{
    private int numeroPlano;

    /** Método construtor que inicializa as variáveis nome, anoNascimento, sexo,
     * telefone e identificação.
     * 
     * @param nome String - Nome do/da paciente.
     * @param anoNascimento int - Ano de nascimento.
     * @param sexo String - Sexo do/da paciente.
     * @param telefone String - Telefone para contato.
     * @param numeroPlano  int - Número do plano do/da paciente.
     */
    public Paciente(String nome, int anoNascimento, String sexo, 
            String telefone, int numeroPlano) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.sexo = sexo;
        this.telefone = telefone;
        this.numeroPlano = numeroPlano;
    }

    /** Método que retorna o número do plano do/da paciente.
     * 
     * @return int - Número do plano do/da paciente.
     */
    public int getNumeroPlano() {
        return this.numeroPlano;
    }
    
    /** Método que compara o nome, ano de nascimento, sexo, telefone e número
     * do plano do/da paciente com os do/da paciente que é passado como 
     * parâmetro.
     * 
     * @param p Paciente - Paciente contendo suas informações.
     * @return true - Se a comparação for verdadeira; false - Se a comparação 
     * for falsa.
     */
    public boolean equals(Paciente p){
        return this.nome.equals(p.getNome()) && 
                this.anoNascimento == p.getAnoNascimento() && 
                this.sexo.equals(p.getSexo()) &&
                this.telefone.equals(p.getTelefone()) &&
                this.numeroPlano == numeroPlano;
    }
    
}

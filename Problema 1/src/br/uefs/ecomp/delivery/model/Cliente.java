/**
 * Componente Curricular: Módulo Integrado de Programação
 * Autor: Allan Capistrano de Santana Santos
 * Data:  31/03/2019
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

/** Classe que contêm as informações dos clientes, como nome, telefone e e-mail.
 * Possuindo métodos que podem retornar e comparar essas informações.
 *
 * @author Allan Capistrano de Santana Santos
 */
public class Cliente {
    private String name;
    private String phone;
    private String email;

    /** Método construtor que inicializa as variáveis name, phone e email. 
     * 
     * @param name String - Nome do cliente.
     * @param phone String - Telefone do cliente.
     * @param email String - E-mail do cliente.
     */
    public Cliente(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    /** Método que retorna o nome do cliente.
     * 
     * @return String - Nome do cliente.
     */
    public String getName() {
        return name;
    }

    /** Método que retorna o telefone do cliente.
     * 
     * @return String - Telefone do cliente.
     */
    public String getPhone() {
        return phone;
    }

    /** Método que retorna o e-mail do cliente.
     * 
     * @return String - E-mail do cliente.
     */
    public String getEmail() {
        return email;
    }
    
    /** Método que compara o nome, telefone e e-mail do cliente com os do 
     * cliente que é passado como parâmetro.
     * 
     * @param c Cliente - Cliente contendo suas informações como nome, telefone
     * e e-mail.
     * @return true - Se a comparação for verdadeira; false - Se a comparação 
     * for falsa.
     */
    public boolean equals(Cliente c){
        return this.name.equals(c.getName()) && 
                this.phone.equals(c.getPhone()) && 
                this.email.equals(c.getEmail());
    }
}

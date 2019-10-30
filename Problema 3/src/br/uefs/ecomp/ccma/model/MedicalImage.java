/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autores: <Kevin Cerqueira Gomes e Allan Capistrano>
 * Data:  <11/08/2019>
 *
 * Declaro que este código foi elaborado por nós de forma individual e
 * não contém nenhum trecho de código de outro colega ou de outro autor, 
 * tais como provindos de livros e apostilas, e páginas ou documentos 
 * eletrônicos da Internet. Qualquer trecho de código de outra autoria que
 * uma citação para o  não a minha está destacado com  autor e a fonte do
 * código, e estou ciente que estes trechos não serão considerados para fins
 * de avaliação. Alguns trechos do código podem coincidir com de outros
 * colegas pois estes foram discutidos em sessões tutorias.
 */

package br.uefs.ecomp.ccma.model;

/**
 * Classe responsável por gerenciar os atributos e métodos das Imagens médicas
 * do sistema.
 *
 * @author Kevin e Allan
 */
public class MedicalImage {
    private String name;
    private double size;
    private Computer computer;
    
    /**
     * Contrutor da classe MedicalImage. Inicializa os atributos da classe.
     * @param name nome da imagem.
     * @param size tamanho da imagem em double MB.
     */
    public MedicalImage(String name, double size) {
        this.name = name;
        this.size = size;
    }
    
    /**
     * Retorna o nome da imagem.
     * @return String com o nome da imagem.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Atualiza o nome da imagem.
     * @param name novo nome da imagem.
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * Retorna o tamanho da imagem.
     * @return Double com o tamanho da imagem.
     */
    public double getSize() {
        return size;
    }
    
    /**
     * Atualiza o tamanho da imagem.
     * @param size novo tamanho da imagem.
     */
    public void setSize(double size){
        this.size = size;
    }
    
    /**
     * Retorna o Computador a qual a imagem está inserida.
     * @return Computador a qual a imagem está inserida.
     */
    public Computer getComputer() {
        return computer;
    }
    
    /**
     * Atualiza o computador a qual a imagem está inserida.
     * @param computer novo computador que a imagem será inserida.
     */
    public void setComputer(Computer computer) {
        this.computer = computer;
    }
    
    /**
     * Metódo equals da classe Computador. Compara um objeto com este da classe.
     * @param image Objeto a ser comparado.
     * @return true, caso os atributos do objeto for igual. false, caso 
     * contrário.
     */
    public boolean equals(MedicalImage image){
        return image.getComputer() == this.getComputer() &&
                image.getName().equals(this.name) &&
                image.getSize() == this.size;
    }
}

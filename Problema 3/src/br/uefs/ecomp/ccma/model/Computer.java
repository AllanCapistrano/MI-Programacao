/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autores: <Kevin Cerqueira Gomes e Allan Capistrano de Santana Santos>
 * Data: <11/08/2019>
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

import br.uefs.ecomp.ccma.util.DuplicateImageException;
import br.uefs.ecomp.ccma.util.FullDiskException;
import br.uefs.ecomp.ccma.util.MyLinkedListImage;

/**
 *  Classe resposável por gereciar todo o comportamento dos computadores e das
 * imagens nele contido.
 * @author Kevin e Allan
 */
public class Computer {
    private double capacity;
    private double freeSize;
    private String hostName;
    private MyLinkedListImage imageList;
    
    /**
     * Construtor da classe Computer. Inicializa os atributos da classe.
     * @param hostName hostname do computador.
     * @param capacity capacidade de armazenamento do computador.
     */
    public Computer(String hostName, double capacity) {
        this.hostName = hostName;
        this.capacity = capacity;
        this.freeSize = capacity; // O espaço livre do computador inicializa com sua capacidade total.
        this.imageList = new MyLinkedListImage();
    }
    
    /**
     * Retorna a capacidade do computador.
     * @return Double com a capacidade do computador.
     */
    public double getCapacity() {
        return capacity;
    }
    
    /**
     * Retorna o espaço livre do computador.
     * @return Double com o espaço livre do computador.
     */
    public double getFreeSize() {
        return freeSize;
    }
    
    /**
     * Atualiza o espaço livre do computador.
     * @param freeSize novo espaço livre do computador.
     */
    public void setFreeSize(Double freeSize) {
        this.freeSize = freeSize;
    }
    
    /**
     * Atualiza a capacidade do computador.
     * @param capacity nova capacidade do computador.
     */
    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }
    
    /**
     * Retorna o Hostname do computador.
     * @return String com o Hostname do computador.
     */
    public String getHostName() {
        return hostName;
    }
    
    /**
     * Atualiza o Hostname do computador.
     * @param hostName novo nome para o computador.
     */
    public void setHostName(String hostName){
        this.hostName = hostName;
    }
    
    /**
     * Adiciona uma nova imagem a lista de imagens do computador.
     * @param image Nova imagem a ser adicionada a lista do computador.
     * @throws br.uefs.ecomp.ccma.util.DuplicateImageException
     * @throws br.uefs.ecomp.ccma.util.FullDiskException
     */
    public void addImage(MedicalImage image) throws DuplicateImageException, 
            FullDiskException{
        if(this.imageList.search(image.getName()))
            throw new DuplicateImageException();
        
        if(this.freeSize == 0 || this.freeSize < 9 || this.freeSize < 
                image.getSize())
            throw new FullDiskException();
        
        this.imageList.add(image.getName() + ": " + image.getSize());
        this.freeSize -= image.getSize();
    }
    
    /**
     * Remove uma imagem da lista de imagens do computador.
     * @param name nome da imagem a ser removida.
     */
    public void removeImage(String name){
        this.imageList.remove(name);
    }
    
    /**
     * Retorna a lista de imagens do computador.
     * @return Lista de imagens do computador.
     */
    public MyLinkedListImage getImageList() {
        return imageList;
    }
    
    /**
     * Metódo equals da classe Computador. Compara um objeto com este da classe.
     * @param computer Objeto a ser comparado.
     * @return true, caso os atributos do objeto for igual. false, caso 
     * contrário.
     */
    public boolean equals(Computer computer){
        return this.freeSize == computer.getFreeSize() && 
                this.capacity == computer.getCapacity()
                && this.hostName.equals(computer.getHostName());
    }
    
}

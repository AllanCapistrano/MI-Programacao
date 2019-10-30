/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autores: <Kevin Cerqueira Gomes e Allan Capistrano de Santana Santos>
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

import br.uefs.ecomp.ccma.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe responsável por gerenciar todo o sistema (classes e objetos) do 
 * programa.
 * @author Kevin e Allan
 */
public class System {
    private MyLinkedListComputer computerList;
    private MyTreeImages imagesTree;
    private File computersFile = new File("computers.txt");
    private File imagesFile = new File("medical_images.txt");
    
    /**
     * Construtor da classe System. Inicializa os atributos da classe.
     */
    public System() {
        computerList = new MyLinkedListComputer();
        imagesTree = new MyTreeImages();
    }
    
    /**
     * Retorna a lista de computadores do sistema.
     * @return Lista com os computadores cadastrados.
     */
    public MyLinkedListComputer getComputerList(){
        return this.computerList;
    }
    
    /**
     * Retorna a árvore AVL com as imagens armazenadas no sistema.
     * @return Árvore com as imagens armazenadas no sistema.
     */
    public MyTreeImages getImagesTree() {
        return imagesTree;
    }
    
    /**
     * Atualiza o nome do arquivo dos computadores.
     * @param computersFile novo nome para o arquivo dos computadores.
     */
    public void setComputersFile(String computersFile){
        this.computersFile = new File(computersFile);
    }
    
    /**
     * Atualiza o nome do arquivo das imagens.
     * @param imagesFile novo nome para o arquivo das imagens.
     */
    public void setImagesFile(String imagesFile){
        this.imagesFile = new File(imagesFile);
    }
    
    /**
     * Cadastra um novo computador na lista de computadores, lendo do arquivo
     * "computers.txt" dentro da pasta do projeto.
     * @return "Dados inválidos e/ou incompreensíveis no arquivo!" caso o 
     * arquivo esteja organizado de forma errada ou com dados errados. "Arquivo
     * leitura não encontrado" caso o arquivo com o nome não exista na pasta. 
     * "Computadores adicionados!" caso dê tudo certo.
     */
    public String addComputer(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.computersFile));
            try{
                String nomeComputador = br.readLine();
                String capacity;

                while((capacity = br.readLine()) != null){
                    Computer pc = new Computer(nomeComputador, Double.parseDouble(capacity));

                    this.computerList.add(pc);
                    nomeComputador = br.readLine();
                }
            }catch(NumberFormatException | IOException error){
               return "Dados inválidos e/ou incompreensíveis no arquivo!";
            }
        }catch(FileNotFoundException error){
            return "Arquivo de leitura não encontrado";
        }
        return "Computadores adicionados!";
    }
    
    /**
     * Insere uma nova imagem ao sistema, lendo do arquivo "medical_images.txt", 
     * verificando se há espaço livre nos computadores cadatrados.
     * @return "Capacidade de disco esgotada!" caso não haja espaço livre nos
     * computadores para armazenar a imagem."Imagem já está adicionada no 
     * sistema!" caso a imagem já exista no sistema. "Dados inválidos e/ou 
     * incompreensíveis no arquivo!" caso o arquivo esteja organizado de forma 
     * errada ou com dados errados. "Arquivo leitura não encontrado" caso o 
     * arquivo com o nome não exista na pasta. "Imagens inseridas!", caso 
     * dê tudo certo.
     */
    public String addImages(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(this.imagesFile));
            
            try{
                String nomeImg = br.readLine();
                String tamMB;
            
                while((tamMB = br.readLine()) != null){
                    MedicalImage image = new MedicalImage(nomeImg, Double.parseDouble(tamMB));

                    this.computerList.ordena();

                    try{
                        this.computerList.get(0).addImage(image);
                        this.imagesTree.inserir(image);
                    }catch(DuplicateImageException errorDuplicate){
                        return errorDuplicate.toString();
                    }catch(FullDiskException errorFDisk){
                        return errorFDisk.toString();
                    }

                    this.computerList.ordena();
                    image.setComputer(this.computerList.get(0));
                    nomeImg = br.readLine();
                }   
            }catch(NumberFormatException | IOException error){
               return "Dados inválidos e/ou incompreensíveis no arquivo!";
            }
        }catch(FileNotFoundException error){
            return "Arquivo de leitura não encontrado";
        }
        return "Imagens inseridas";
    }
    
    /**
     * Procura uma determinada imagem no sistema.
     * @param name nome da imagem a ser procurada.
     * @return null, caso a árvore de imagens esteja vazia. Computador em que 
     * a imagem está sendo armazenada, caso contrário.
     */
    public Computer searchImage(String name){
        if(this.imagesTree.isEmpty())
            return null;
        
        return this.imagesTree.searchAndReturn(name);
    }
    
    /**
     * Deleta uma imagem do sistema, verificando primeiramente se ela existe.
     * @param name nome da imagem a ser deletada.
     * @return true, caso a imagem exista e seja removida. false, caso a imagem
     * não exista.
     */
    public boolean deleteImage(String name){
        Computer aux = this.searchImage(name);
        if(aux == null)
            return false;
        
        this.computerList.search(aux.getHostName()).removeImage(name);
        this.computerList.search(aux.getHostName()).setFreeSize(aux.getFreeSize() 
                + this.imagesTree.getSizeImage(name));
        this.imagesTree.delete(name);
        
        return true;
    }
    
    /**
     * Mostra todos os computadores cadastrados e suas capacidades.
     * @return null, caso a lista de computadores esteja vazia. String com o 
     * nome e capacidade de todos os computadores.
     */
    public String displayCapacity(){
        if(this.computerList.isEmpty()) 
            return null;
        else if(this.computerList.size() == 1)
            return "1 > " + this.computerList.get(0).getHostName()+": " + this.computerList.get(0).getCapacity();
        
        MyIterator it;
        int pos;
        String computers;
        for(computers = "", it = this.computerList.iterator(), pos = 1; it.hasNext(); pos++){
            Computer comp = (Computer) it.next();
            computers += pos + " - " + comp.getHostName() + ": " + comp.getCapacity() + " | ";
        }
        return computers;
    }
    
    /**
     * Mostra todos os computadores cadastrados e seus espaço livre.
     * @return null, caso a lista de computadores esteja vazia. String com o 
     * nome e espaço livre de todos os computadores, caso contrário.
     */
    public String displayFreeSize(){
        if(this.computerList.isEmpty()) 
            return null;
        else if(this.computerList.size() == 1)
            return "1 - " + this.computerList.get(0).getHostName()+": " + this.computerList.get(0).getFreeSize();
        
        MyIterator it;
        int pos;
        String computers;
        for(it = this.computerList.iterator(), pos = 1, computers = ""; it.hasNext(); pos++){
            Computer comp = (Computer) it.next();
            computers += pos + " - " + comp.getHostName() + ": " + comp.getFreeSize() + " | ";
        }
        return computers;
    }
    
    /**
     * Mostra todas as imagens de um determinado computador.
     * @param hostname hostname do computador a ser procurado e listado.
     * @return null, caso a lista de computadores esteja vazia, se o 
     * hostname do computador não existir no sistema ou se a lista de imagens
     * do computador procurado estiver vazia. String com todas as imagens, 
     * caso o computador seja encotrado e a sua lista de imagens não estiver 
     * vazia.
     */
    public String displayImagesOnComputer(String hostname){
        if(this.computerList.isEmpty()) return null;
        
        Computer comp = this.computerList.search(hostname);
        if(comp == null) return null;
        else if(comp.getImageList().isEmpty()) return null;
        
        MyIterator it;
        String images;
        for(images = "", it = comp.getImageList().iterator(); it.hasNext(); images += (String) it.next() + " "){}
        return images;
    }
    
    /**
     * Mostra todas as imagens armazenadas do sistema.
     * @return null, caso a árvore de imagens esteja vazia. String com com todas
     * as imagens armazenadas do sistema, caso contrário.
     */
    public String displayAllImages(){
        if(this.imagesTree.isEmpty()) return null;
        
        String allImages = this.imagesTree.percorrer("in");
        return allImages;
    }
}

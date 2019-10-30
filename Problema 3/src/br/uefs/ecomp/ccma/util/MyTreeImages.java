/**
 * Componente Curricular: Módulo Integrado de Programação II
 * Autores: <Kevin Cerqueira Gomes e Allan Capistrano de Santana Santos>
 * Data:  <05/08/2019>
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
package br.uefs.ecomp.ccma.util;

import br.uefs.ecomp.ccma.model.Computer;
import br.uefs.ecomp.ccma.model.MedicalImage;

/** Classe que criar uma árvore AVL de imagens médicas, e guarda cadaa 
 * informação em um nó diferente, não sendo possível a árvore possuir dois nós 
 * com uma mesma chave. Além de conter métodos que adicionam e remover os nós, 
 * buscar determinadas informações e percorrer todos os nós da árvore em uma 
 * ordem específica.
 *
 * @author Kevin e Allan
 */
public class MyTreeImages extends MyTree{
    
    /** Método que chama o método de adicionar novas imagens na árvore.
     * 
     * @param image MedicalImage - Imagem que deseja inserir na árvore.
     * @return NodeTree - Raiz da árvore ou sub-árvore.
     * @throws br.uefs.ecomp.ccma.util.DuplicateImageException
     */
    public NodeTree inserir(MedicalImage image) throws DuplicateImageException{
        if(this.search(image.getName()))
            throw new DuplicateImageException();
        
        return root = this.inserir(root, image);
    }

    /** Método que adiciona novas imagens na árvore.
     * 
     * @param node NodeTree - Nó raiz da árvore ou da sub-árvore.
     * @param image MedicalImage - Imagem que deseja inserir na árvore.
     * @return NodeTree - Raiz da árvore.
     */
    private NodeTree inserir(NodeTree node, MedicalImage image) { 
  
        if (node == null) 
            return (new NodeTree(image)); 
  
        if (image.getName().compareTo(node.getImage().getName()) < 0) 
            node.setLeft(inserir(node.getLeft(), image)); 
        else if (image.getName().compareTo(node.getImage().getName()) > 0) 
            node.setRight(inserir(node.getRight(), image)); 
        else // duplicação de chaves não é permitida
            return node; 
  
        /*Atualiza altura*/
        node.setHeight(1 + max(altura(node.getLeft()), 
                              altura(node.getRight()))); 
  
        /*Obtém o fator de balanceamento deste nó pai*/
        int balance = getBalanceamento(node); 
  
        // Se o nó está desbalanceado, então existe 4 casos de rotações possíveis
        
        // Simples à direita
        if (balance > 1 && image.getName().compareTo(node.getLeft().getImage()
                                                     .getName()) < 0) 
            return rotacaoDireita(node); 
  
        // Simples à esquerda  
        if (balance < -1 && image.getName().compareTo(node.getRight().getImage()
                                                      .getName()) > 0) 
            return rotacaoEsquerda(node); 
  
        // Dupla à direita (esquerda - diteita)
        if (balance > 1 && image.getName().compareTo(node.getLeft().getImage()
                                                     .getName()) > 0)
            return rotacaoLR(node);
  
        // Dupla à esquerda (direita - esquerda)
        if (balance < -1 && image.getName().compareTo(node.getRight().getImage()
                                                      .getName()) < 0)
            return rotacaoRL(node);
  
        return node; 
    }
    
    /** Método que chama o método de remover uma imagem da árvore.
     * 
     * @param image String - Nome da imagem que se deseja remover.
     */
    public void delete(String image){
        delete(this.root, image);
    }
    
    /** Método que remove uma imagem da árvore.
     * 
     * @param node NodeTree - Nó raiz da árvore ou sub-árvore.
     * @param image String - Nome da imagem que se deseja remover.
     * @return NodeTree - Raiz da árvore ou sub-árvore.
     */
    private NodeTree delete(NodeTree node, String image) {
        /*Se a árvore estiver vazia*/
        if(node == null)
            return node;
      /*Se o elemento que quer remover tem chave menor do que a do nó que está*/
        if(image.compareTo(node.getImage().getName()) < 0)
            node.setLeft(delete(node.getLeft(), image));
      /*Se o elemento que quer remover tem chave maior do que a do nó que está*/
        else if(image.compareTo(node.getImage().getName()) > 0)
            node.setRight(delete(node.getRight(), image));
    /*Se o elemento que quer remover tem chave igual a do que a do nó que está*/
        else {
            /*Caso tenha um ou nenhum filho*/
            if(node.getLeft() == null || node.getRight() == null){
                /*Se tiver apenas um filho e ele está na esquerda*/
                if(node.getLeft() != null)
                    node = node.getLeft();
                /*Se tiver apenas um filho e ele está na direita*/
                else
                    node = node.getRight();
            }
            /*Caso tenha dois filhos*/
            else{
                NodeTree temp = menorValor(node.getRight()); /*Procura o menor 
                                            valor dentre os que estão na direita*/
                
                /*Troca o valor da chave do nó que deseja remover pela chave do 
                nó que é o menor dentre os que estão na direita*/
                node.getImage().setName(temp.getImage().getName());
                /*Remove o nó que a chave foi copiada*/
                node.setRight(delete(node.getRight(), temp.getImage().getName()));
            }
        }
        
        /*Se após a remoção a árvore não tiver mais nenhum nó*/
        if(node == null)
            return node;
        
        /*Atualiza o tamanho da árvore*/
        node.setHeight(1 + max(altura(node.getLeft()), altura(node.getRight())));
        
        /*Variável para verificar o balanceamento*/
        int balance = getBalanceamento(node);
        
        /*Se o balanceamento do nó raiz atual da árvore/sub-árvore for maior que
        um e o balanceamento da sub-árvore da esquerda dessa raiz for maior ou 
        igual a zero, faz rotação simples à direita (rotação LL)*/
        if(balance > 1 && getBalanceamento(node.getLeft()) >= 0)
            return rotacaoDireita(node);
        
        /*Se o balanceamento do nó raiz atual da árvore/sub-árvore for maior que
        um e o balanceamento da sub-árvore da esquerda dessa raiz for menor que 
        zero, faz rotação dupla à direita (rotação LR)*/
        if(balance > 1 && getBalanceamento(node.getLeft()) < 0)
            return rotacaoLR(node);
        
        /*Se o balanceamento do nó raiz atual da árvore/sub-árvore for menor que
        menos um e o balanceamento da sub-árvore da direita dessa raiz for menor 
        que ou igual a zero, faz rotação simples à esquerda (rotação RR)*/
        if(balance < -1 && getBalanceamento(node.getRight()) <= 0)
            return rotacaoEsquerda(node);
        
        /*Se o balanceamento do nó raiz atual da árvore/sub-árvore for menor que
        menos um e o balanceamento da sub-árvore da direita dessa raiz for maior 
        zero, faz rotação dupla à esquerda (rotação RL)*/
        if(balance < -1 && getBalanceamento(node.getRight()) > 0)
            return rotacaoRL(node);
        
        return node;
    }
    
    /** Método que chama o método de buscar uma determinada imagem da árvore.
     * 
     * @param image String - Nome da imagem que se deseja procurar.
     * @return true - Se encontrou a imagem | false - Se não encontou a imagem.
     */
    public boolean search(String image){
        return search(this.root, image);
    }
    
    /** Método que busca determinada imagem da árvore.
     * 
     * @param node NodeTree - Nó raiz da árvore ou sub-árvore.
     * @param name String - Nome da imgaem que se deseja procurar.
     * @return true - Se encontrou a imagem | false - Se não encontou a imagem.
     */
    private boolean search(NodeTree node, String name){
        if(node != null){
            boolean find = false;
            
            if(name.compareTo(node.getImage().getName()) == 0)
                return true;
            if(name.compareTo(node.getImage().getName()) < 0)
                find = search(node.getLeft(), name);
            else if(name.compareTo(node.getImage().getName()) > 0)
                find = search(node.getRight(), name);
            return find;
        }
        return false;
    }
    
    /** Método que chama o método que retorna o tamanho da imagem que se deseja
     * buscar.
     * 
     * @param name String- Nome da imagem que se deseja conhecer o tamanho.
     * @return double - Tamanho da imagem.
     */
    public double getSizeImage(String name){
        return getSizeImage(this.root, name);
    }
    
    /** Método que retorna o tamanho da imagem que é passado o nome como 
     * parâmetro.
     * 
     * @param node NodeTree - Nó raiz da árvore ou sub-árvore.
     * @param name String - String- Nome da imagem que se deseja conhecer o 
     * tamanho.
     * @return double - Tamanho da imagem.
     */
    private double getSizeImage(NodeTree node, String name){
        double aux;
        
        if(node !=null){
            aux = 0.0;
            
            if(name.compareTo(node.getImage().getName()) == 0)
                return node.getImage().getSize();
            if(name.compareTo(node.getImage().getName()) < 0)
                aux = getSizeImage(node.getLeft(), name);
            else if(name.compareTo(node.getImage().getName()) > 0)
                aux = getSizeImage(node.getRight(), name);
            return aux;
        }
        return 0.0;
    }
    
    /** Método que chama o método que retorna o computaodor onde está localizada 
     * uma determinada imagem.
     * 
     * @param name String - Nome da imagem que se deseja retornar o tamanho.
     * @return Computer - Computador em que a imagem desejada está localizada.
     */
    public Computer searchAndReturn(String name){
        return searchAndReturn(this.root, name);
    }
    
    /** Método que retorna o computador onde uma determinada imagem está 
     * localizada.
     * 
     * @param node NodeTree - Nó raiz da árvore ou sub-árvore.
     * @param name String - Nome da imagem que se deseja conhecer o computador 
     * onde ela esá localizada.
     * @return Computer - Computador em que a imagem desejada está localizada.
     */
    private Computer searchAndReturn(NodeTree node, String name){
        Computer aux;
        if(node !=null){
            aux = null;
            
            if(name.compareTo(node.getImage().getName()) == 0)
                return node.getImage().getComputer();
            if(name.compareTo(node.getImage().getName()) < 0)
                aux = searchAndReturn(node.getLeft(), name);
            else if(name.compareTo(node.getImage().getName()) > 0)
                aux = searchAndReturn(node.getRight(), name);
            return aux;
        }
        return null;
    }
    
    /** Método que percorre todos os nós da árvore mostrando primeiro o conteúdo 
     * do nó pai, do filho da esquerda e depois do filho da direita.
     * 
     * @param node NodeTree - Nó raiz da árvore.
     * @return String - Uma String que contém as informações dos nós da árvore, 
     * organizados em pré-ordem.
     */
    @Override
    protected String preOrder(NodeTree node){
        String show = "";
        
        if(node != null){
            show += node.getImage().getName() + " ";
            show += preOrder(node.getLeft());
            show += preOrder(node.getRight());
        }
        return show;
    }
    
    /** Método que percorre todos os nós da árvore mostrando primeiro o conteúdo 
     * do nó da esquerda, o pai e depois o filho da direita.
     * 
     * @param node NodeTree - Nó raiz da árvore.
     * @return String - Uma String que contém as informações dos nós da árvore, 
     * organizados em ordem.
     */
    @Override
    public String inOrder(NodeTree node){
        String show = "";
        
        if(node != null){
            show += inOrder(node.getLeft());
            show += node.getImage().getName() + "\n";
            show += inOrder(node.getRight());
        }
        return show;
    }
    
    /** Método que percorre todos os nós da árvore mostrando primeiro os nós da 
     * esquerda, da direita e depois o pai.
     * 
     * @param node NodeTree - Nó raiz da árvore.
     * @return String - Uma String que contém as informações dos nós da árvore, 
     * organizados em pós-ordem.
     */
    @Override
    protected String postOrder(NodeTree node){
        String show = "";
        
        if(node != null){
            show += postOrder(node.getLeft());
            show += postOrder(node.getRight());
            show += node.getImage().getName() + " ";
        }
        return show;
    }
}

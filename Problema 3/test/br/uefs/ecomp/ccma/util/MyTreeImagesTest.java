package br.uefs.ecomp.ccma.util;

import br.uefs.ecomp.ccma.model.MedicalImage;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Testes de unidade para a classe ({@link MyTreeImages}).
 */
public class MyTreeImagesTest {
    MyTreeImages tree;
    MedicalImage image1, image2, image3, image4, image5;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception{
        tree = new MyTreeImages();
        image1 = new MedicalImage("aa.TIFF", 13.2);
        image2 = new MedicalImage("aab.TIFF", 11.6);
        image3 = new MedicalImage("babcdefghij.TIFF", 12.5);
        image4 = new MedicalImage("cabc.TIFF", 11.7);
        image5 = new MedicalImage("cabcdefghijklmn.TIFF", 10.1);
    }
    
    /**
     * Teste de unidade que verifica se as imagens estão sendo inseridas 
     * corretamente na árvore AVL.
     * @throws br.uefs.ecomp.ccma.util.DuplicateImageException Exceção caso a 
     * imagem esteja duplicada
     */
    @Test
    public void inserir() throws DuplicateImageException{
        assertTrue(tree.isEmpty());
        
        tree.inserir(image1);
        tree.inserir(image2);
        tree.inserir(image3);
        tree.inserir(image4);
        tree.inserir(image5);
        
        assertFalse(tree.isEmpty());
        assertEquals(5, tree.countNodes());
        
    }
    
    /**
     * Teste de unidade que verifica se as imagens estão sendo removidas 
     * corretamente da árvore AVL.
     * @throws br.uefs.ecomp.ccma.util.DuplicateImageException Exceção caso a 
     * imagem esteja duplicada
     */
    @Test
    public void remover() throws DuplicateImageException{
        assertTrue(tree.isEmpty());
        
        tree.inserir(image1);
        tree.inserir(image2);
        tree.inserir(image3);
        tree.inserir(image4);
        tree.inserir(image5);
        
        assertFalse(tree.isEmpty());
        assertEquals(5, tree.countNodes());
        
        assertTrue(tree.search("aa.TIFF")); // imagem1
        assertTrue(tree.search("cabc.TIFF")); // imagem4
        assertTrue(tree.search("babcdefghij.TIFF")); // imagem3
        
        tree.delete("aa.TIFF");
        tree.delete("babcdefghij.TIFF");
        
        assertEquals(3, tree.countNodes());
        
        assertFalse(tree.search("babcdefghij.TIFF")); // imagem3
        assertFalse(tree.search("aa.TIFF")); // imagem1
    }
    
    /**
     * Teste de unidade que verifica se os métodos de percorrer (pré-ordem, 
     * em ordem, pós-ordem) da árovre AVL está funcionando corretamente.
     * @throws br.uefs.ecomp.ccma.util.DuplicateImageException Exceção caso a 
     * imagem esteja duplicada
     */
    @Test

    public void percorrer() throws DuplicateImageException{
        assertTrue(tree.isEmpty());
        
        tree.inserir(image1);
        tree.inserir(image2);
        tree.inserir(image3);
        tree.inserir(image4);
        tree.inserir(image5);
        
        assertFalse(tree.isEmpty());
        assertEquals(5, tree.countNodes());
        
        assertEquals("aab.TIFF aa.TIFF cabc.TIFF babcdefghij.TIFF cabcdefghijklmn.TIFF ", tree.percorrer("pre"));
        assertEquals("aa.TIFF\naab.TIFF\nbabcdefghij.TIFF\ncabc.TIFF\ncabcdefghijklmn.TIFF\n", tree.percorrer("in"));
        assertEquals("aa.TIFF babcdefghij.TIFF cabcdefghijklmn.TIFF cabc.TIFF aab.TIFF ", tree.percorrer("post"));
        assertEquals("Escolha inválida!", tree.percorrer("percorrer"));
    }
    
    /**
     * Teste de unidade que verifica se o método de procurar uma determinada 
     * imagem na árvore AVL está funcionando corretamente.
     * @throws br.uefs.ecomp.ccma.util.DuplicateImageException Exceção caso a 
     * imagem esteja duplicada
     */
    @Test
    public void procurar() throws DuplicateImageException{
        assertTrue(tree.isEmpty());
        
        tree.inserir(image1);
        tree.inserir(image2);
        tree.inserir(image5);
        
        assertFalse(tree.isEmpty());
        assertEquals(3, tree.countNodes());
        
        assertTrue(tree.search("aa.TIFF"));
        assertTrue(tree.search("cabcdefghijklmn.TIFF"));
        assertTrue(tree.search("aab.TIFF"));
        
        assertFalse(tree.search("babcdefghij.TIFF"));
        assertFalse(tree.search("cabc.TIFF"));
    }
    
}
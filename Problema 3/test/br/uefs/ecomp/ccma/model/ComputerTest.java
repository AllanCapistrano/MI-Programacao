package br.uefs.ecomp.ccma.model;

import br.uefs.ecomp.ccma.model.Computer;
import br.uefs.ecomp.ccma.util.DuplicateImageException;
import br.uefs.ecomp.ccma.util.FullDiskException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes de unidade para a classe ({@link Computer}).
 */
public class ComputerTest {
    
    private Computer computer;
    private MedicalImage mi1, mi2, mi3, mi4;
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        computer = new Computer("hostCleriston", 500.0);
        
        mi1 = new MedicalImage("sistemavascular.TIFF", 12.0);
        mi2 = new MedicalImage("sistemanervoso.RAW", 11.0);
        mi3 = new MedicalImage("pancreas.TIFF", 11.0);
        mi4 = new MedicalImage("nervociatico.TIFF", 11.0);
        
        
    }

    /**
     * Teste de unidade que verifica se os atributos de uma opção de cardápio são atribuídos e
     * modificados corretamente.
     * @throws br.uefs.ecomp.ccma.util.FullDiskException Exceção caso o espaço
     * esteja cheio ou insuficiente.
     * @throws br.uefs.ecomp.ccma.util.DuplicateImageException Exceção caso a 
     * imagem esteja duplicada
     */
    @Test
    public void testBasic() throws FullDiskException, DuplicateImageException{
        assertEquals("hostCleriston", computer.getHostName());
        assertEquals(500.0, computer.getCapacity(),.0001);
        assertEquals(500.0, computer.getFreeSize(),.0001);
        assertTrue(computer.getImageList().isEmpty());
        

        computer.setHostName("hostEistein");
        computer.setCapacity(300.0);
        computer.setFreeSize(300.0);
        computer.addImage(mi1);
        computer.addImage(mi2);
        computer.addImage(mi3);
        computer.addImage(mi4);
        
        assertEquals("hostEistein", computer.getHostName());
        assertEquals(300.0, computer.getCapacity(),.0001);
        assertEquals(255.0, computer.getFreeSize(),.0001);
        
        assertFalse(computer.getImageList().isEmpty());
        
        assertEquals("sistemavascular.TIFF: 12.0", computer.getImageList().remove("sistemavascular.TIFF: 12.0"));
        assertEquals("sistemanervoso.RAW: 11.0", computer.getImageList().remove("sistemanervoso.RAW: 11.0"));
        assertEquals("pancreas.TIFF: 11.0", computer.getImageList().remove("pancreas.TIFF: 11.0"));
        assertEquals("nervociatico.TIFF: 11.0", computer.getImageList().remove("nervociatico.TIFF: 11.0"));
        
        assertTrue(computer.getImageList().isEmpty());
    }
    
    /**
     * Testa se o método equals foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        Computer temp = new Computer("hostCleriston", 300.0);
        assertFalse(temp.equals(computer));

        temp.setCapacity(500.0);
        temp.setFreeSize(500.0);
        assertTrue(temp.equals(computer));

        temp = new Computer("hostEistein", 300.0);
        assertFalse(temp.equals(computer));
    }
}

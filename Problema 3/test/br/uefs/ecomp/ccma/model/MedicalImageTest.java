package br.uefs.ecomp.ccma.model;

import br.uefs.ecomp.ccma.model.MedicalImage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes de unidade para a classe ({@link MedicalImage}).
 */
public class MedicalImageTest {

    private MedicalImage medicalImage;
    private Computer computer1, computer2;

    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir), 
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception {
        computer1 = new Computer("hostCleriston", 519.3);
        computer2 = new Computer("hostEistein", 412.9);
        
        medicalImage = new MedicalImage("sistemavascular.TIFF", 12.9);
        medicalImage.setComputer(computer1);
        
    }

    /**
     * Teste de unidade que verifica se os atributos de uma opção de cardápio são atribuídos e
     * modificados corretamente.
     */
    @Test
    public void testBasic() {
        assertEquals("sistemavascular.TIFF", medicalImage.getName());
        assertEquals(12.9, medicalImage.getSize(),.0001);
        assertEquals(computer1, medicalImage.getComputer());
        

        medicalImage.setName("pancreasdeteriorado.TIFF");
        medicalImage.setSize(9.10);
        medicalImage.setComputer(computer2);
        
        assertEquals("pancreasdeteriorado.TIFF", medicalImage.getName());
        assertEquals(9.10, medicalImage.getSize(),.0001);
        assertEquals(computer2, medicalImage.getComputer());
    }
    
    /**
     * Testa se o método equals foi implementado corretamente.
     */
    @Test
    public void testEquals() {
        MedicalImage temp = new MedicalImage("sistemavascular.TIFF", 11.02);
        temp.setComputer(computer1);
        assertFalse(temp.equals(medicalImage));

        temp.setSize(12.9);
        assertTrue(temp.equals(medicalImage));

        temp = new MedicalImage("pancreasdeteriorado.TIFF", 10.00);
        assertFalse(temp.equals(medicalImage));
    }
}

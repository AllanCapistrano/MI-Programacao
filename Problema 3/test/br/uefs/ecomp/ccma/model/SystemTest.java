package br.uefs.ecomp.ccma.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Testes de unidade para a classe ({@link System}).
 */
public class SystemTest {
    private System sys;
    private Computer computer1, computer2, computer3, computer4, computer5, 
            computer6, computer7, computer8, computer9, computer10, computer11, 
            computer12, computer13, computer14, computer15, computer16, 
            computer17;
    
    
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception{
        sys = new System();
        computer1 = new Computer("hostKevin1", 99999.0);
        computer2 = new Computer("hostAllan2", 789.0);
        computer3 = new Computer("hostKakashi3", 456.0);
        computer4 = new Computer("hostEsdras4", 190.0);
        computer5 = new Computer("hostPatrick5", 20.0);
        computer6 = new Computer("hostAlisson6", 541.0);
        computer7 = new Computer("hostLinux7", 213.0);
        computer8 = new Computer("hostXiaomi8", 1000.0);
        computer9 = new Computer("hostJava9", 666.0);
        computer10 = new Computer("hostGitHub10", 157.0);
        computer11 = new Computer("hostPython11", 155.0);
        computer12 = new Computer("hostPicachu12", 121.0);
        computer13 = new Computer("hostTiago13", 171.0);
        computer14 = new Computer("hostLatino14", 184.0);
        computer15 = new Computer("hostCatra15", 231.0);
        computer16 = new Computer("hostManual", 233.0);
        computer17 = new Computer("hostManual_2", 129.0);
        
    }
    
    /**
     * Teste de unidade que verifica se foi possível adicionar todos os 
     * computadores do arquivo no sistema.
     */
    @Test
    public void adicionarComputador(){
        assertTrue(sys.getComputerList().isEmpty());
        sys.addComputer();
        assertFalse(sys.getComputerList().isEmpty());
        assertEquals(15, sys.getComputerList().size());
        
        assertTrue(sys.getComputerList().get(0).equals(computer2));
        assertTrue(sys.getComputerList().get(1).equals(computer3));
        assertTrue(sys.getComputerList().get(2).equals(computer1));
        assertTrue(sys.getComputerList().get(3).equals(computer4));
        assertTrue(sys.getComputerList().get(4).equals(computer5));
        assertTrue(sys.getComputerList().get(5).equals(computer7));
        assertTrue(sys.getComputerList().get(6).equals(computer8));
        assertTrue(sys.getComputerList().get(7).equals(computer9));
        assertTrue(sys.getComputerList().get(8).equals(computer6));
        assertTrue(sys.getComputerList().get(9).equals(computer13));
        assertTrue(sys.getComputerList().get(10).equals(computer10));
        assertTrue(sys.getComputerList().get(11).equals(computer11));
        assertTrue(sys.getComputerList().get(12).equals(computer12));
        assertTrue(sys.getComputerList().get(13).equals(computer14));
        assertTrue(sys.getComputerList().get(14).equals(computer15));
        
        /*Adicionando computadores manualmente (sem arquivo)*/
        sys.getComputerList().add(computer16);
        sys.getComputerList().add(computer17);
        
        assertEquals(17, sys.getComputerList().size());
        
        assertTrue(sys.getComputerList().get(15).equals(computer16));
        assertTrue(sys.getComputerList().get(16).equals(computer17));
    }
    
    /**
     * Teste de unidade que verifica se foi possível adicionar todas as imagens 
     * que estão no arquivo nos computadores do sistema.
     */
    @Test
    public void adicionarImagens(){
        assertTrue(sys.getComputerList().isEmpty());
        
        sys.addComputer();
        assertFalse(sys.getComputerList().isEmpty());
        assertTrue(sys.getImagesTree().isEmpty());
        
        sys.addImages();
        assertFalse(sys.getImagesTree().isEmpty());
        assertEquals(1000, sys.getImagesTree().countNodes());
        assertEquals("aabcdefghi.TIFF: 11.1", sys.getComputerList().get(0).
                getImageList().get(8));
        assertTrue(sys.getImagesTree().search("aabcdefghi.TIFF"));
        
        assertTrue(sys.getComputerList().get(0).getImageList().
                search("cabcdefghijklmnopqrstuvw.TIFF: 13.3"));

        assertFalse(sys.getComputerList().get(0).getImageList().isEmpty());
    }
    
    /**
     * Teste de unidade que verifica se os computadores que estão na lista estão 
     * sendo ordenados corretamente com base no espaço disponível do disco.
     */
    @Test
    public void ordenarComputador(){
        sys.addComputer();
        
        assertTrue(sys.getComputerList().get(0).equals(computer2));
        assertTrue(sys.getComputerList().get(1).equals(computer3));
        assertTrue(sys.getComputerList().get(2).equals(computer1));
        assertTrue(sys.getComputerList().get(3).equals(computer4));
        assertTrue(sys.getComputerList().get(4).equals(computer5));
        assertTrue(sys.getComputerList().get(5).equals(computer7));
        assertTrue(sys.getComputerList().get(6).equals(computer8));
        assertTrue(sys.getComputerList().get(7).equals(computer9));
        assertTrue(sys.getComputerList().get(8).equals(computer6));
        assertTrue(sys.getComputerList().get(9).equals(computer13));
        assertTrue(sys.getComputerList().get(10).equals(computer10));
        assertTrue(sys.getComputerList().get(11).equals(computer11));
        assertTrue(sys.getComputerList().get(12).equals(computer12));
        assertTrue(sys.getComputerList().get(13).equals(computer14));
        assertTrue(sys.getComputerList().get(14).equals(computer15));
        
        sys.getComputerList().ordena();
        
        assertTrue(sys.getComputerList().get(0).equals(computer1)); // hostKevin1: 99999.0
        assertTrue(sys.getComputerList().get(1).equals(computer8)); // hostXiaomi8: 1000.0
        assertTrue(sys.getComputerList().get(2).equals(computer2)); // hostAllan2: 789.0
        assertTrue(sys.getComputerList().get(3).equals(computer9)); // hostJava9: 666.0
        assertTrue(sys.getComputerList().get(4).equals(computer6)); // hostAlisson6: 541.0
        assertTrue(sys.getComputerList().get(5).equals(computer3)); // hostKakashi3: 456.0
        assertTrue(sys.getComputerList().get(6).equals(computer15)); // hostCatra15: 231.0
        assertTrue(sys.getComputerList().get(7).equals(computer7)); // hostLinux7: 213.0
        assertTrue(sys.getComputerList().get(8).equals(computer4)); // hostEsdras4: 190.0
        assertTrue(sys.getComputerList().get(9).equals(computer14)); // hostLatino14: 184.0
        assertTrue(sys.getComputerList().get(10).equals(computer13)); // hostTiago13: 171.0
        assertTrue(sys.getComputerList().get(11).equals(computer10)); // hostGitHub10: 157.0
        assertTrue(sys.getComputerList().get(12).equals(computer11)); // hostPython11: 155.0
        assertTrue(sys.getComputerList().get(13).equals(computer12)); // hostPicachu12: 121.0
        assertTrue(sys.getComputerList().get(14).equals(computer5)); // hostPatrick5: 20.0
    }
    
    /**
     * Teste de unidade que verifica se as imagens estão sendo removidas dos 
     * computadores corretamente.
     */
    @Test
    public void deletarImagem(){
        assertTrue(sys.getComputerList().isEmpty());
        
        sys.addComputer();
        assertFalse(sys.getComputerList().isEmpty());
        assertTrue(sys.getImagesTree().isEmpty());
                
        sys.addImages();
        assertFalse(sys.getImagesTree().isEmpty());
        assertEquals(1000, sys.getImagesTree().countNodes());
        assertEquals(88620.4, sys.getComputerList().get(0).getFreeSize(), 0.1);
        
        assertTrue(sys.getImagesTree().search("aabcdefghij.TIFF"));
        
        assertTrue(sys.deleteImage("aabcdefghi.TIFF"));
        assertFalse(sys.getImagesTree().search("aabcdefghi.TIFF"));
        assertFalse(sys.getComputerList().get(0).getImageList().
                search("aabcdefghi.TIFF"));
        assertEquals(88631.5, sys.getComputerList().get(0).getFreeSize(), 0.1);
        
    }
    
    /**
     * Teste de unidade que verifica se a busca das imagens na árvore AVL está 
     * sendo feita corretamente.
     */
    @Test
    public void buscarImagem(){
        sys.addComputer();
        sys.addImages();
        
        assertTrue(sys.getImagesTree().search("dabcdefghijklmn.TIFF"));
        assertTrue(sys.getImagesTree().search("sabcdefghijklmnopqrs.TIFF"));
        assertTrue(sys.getImagesTree().search("eabcdefghi.RAW"));
        assertTrue(sys.getImagesTree().search("qa.TIFF"));
        
        sys.deleteImage("aabcd.RAW");
        sys.deleteImage("babcdefghijkl.RAW");
        
        assertFalse(sys.getImagesTree().search("aabcd.RAW"));
        assertFalse(sys.getImagesTree().search("babcdefghijkl.RAW"));
        
        assertEquals(998, sys.getImagesTree().countNodes());
        
        assertEquals(computer1.getHostName(), sys.searchImage("dabcdefgh.RAW").getHostName());
        assertEquals(computer1.getHostName(), sys.searchImage("qabcdefghijklmnopq.TIFF").getHostName());
        assertEquals(computer1.getHostName(), sys.searchImage("kab.TIFF").getHostName());
    }
    
    /**
     * Teste de unidade que verifica se a listagem dos computadores e de suas 
     * respectivas capacidades totais de disco está sendo feita corretamente.
     */
    @Test
    public void listarCapacidadesDosComputadores(){
        sys.addComputer();
        
        assertEquals("1 - hostAllan2: 789.0 |"
                + " 2 - hostKakashi3: 456.0 |"
                + " 3 - hostKevin1: 99999.0 |"
                + " 4 - hostEsdras4: 190.0 |"
                + " 5 - hostPatrick5: 20.0 |"
                + " 6 - hostLinux7: 213.0 |"
                + " 7 - hostXiaomi8: 1000.0 |"
                + " 8 - hostJava9: 666.0 |"
                + " 9 - hostAlisson6: 541.0 |"
                + " 10 - hostTiago13: 171.0 |"
                + " 11 - hostGitHub10: 157.0 |"
                + " 12 - hostPython11: 155.0 |"
                + " 13 - hostPicachu12: 121.0 |"
                + " 14 - hostLatino14: 184.0 |"
                + " 15 - hostCatra15: 231.0 | ", sys.displayCapacity());
        
        sys.getComputerList().ordena();
        
        assertEquals("1 - hostKevin1: 99999.0 |"
                + " 2 - hostXiaomi8: 1000.0 |"
                + " 3 - hostAllan2: 789.0 |"
                + " 4 - hostJava9: 666.0 |"
                + " 5 - hostAlisson6: 541.0 |"
                + " 6 - hostKakashi3: 456.0 |"
                + " 7 - hostCatra15: 231.0 |"
                + " 8 - hostLinux7: 213.0 |"
                + " 9 - hostEsdras4: 190.0 |"
                + " 10 - hostLatino14: 184.0 |"
                + " 11 - hostTiago13: 171.0 |"
                + " 12 - hostGitHub10: 157.0 |"
                + " 13 - hostPython11: 155.0 |"
                + " 14 - hostPicachu12: 121.0 |"
                + " 15 - hostPatrick5: 20.0 | ", sys.displayCapacity());
        
    }
    
    /**
     * Teste de unidade que verifica se a listagem dos computadores e de seus 
     * respectivos espaços livres de disco está sendo feita corretamente.
     */
    @Test
    public void listarEspacoDisponivelDosComputadores(){
        sys.addComputer();
        
        assertEquals("1 - hostAllan2: 789.0 |"
                + " 2 - hostKakashi3: 456.0 |"
                + " 3 - hostKevin1: 99999.0 |"
                + " 4 - hostEsdras4: 190.0 |"
                + " 5 - hostPatrick5: 20.0 |"
                + " 6 - hostLinux7: 213.0 |"
                + " 7 - hostXiaomi8: 1000.0 |"
                + " 8 - hostJava9: 666.0 |"
                + " 9 - hostAlisson6: 541.0 |"
                + " 10 - hostTiago13: 171.0 |"
                + " 11 - hostGitHub10: 157.0 |"
                + " 12 - hostPython11: 155.0 |"
                + " 13 - hostPicachu12: 121.0 |"
                + " 14 - hostLatino14: 184.0 |"
                + " 15 - hostCatra15: 231.0 | ", sys.displayFreeSize());
        
        /**
         * Alterando a capacidade de todos os computadores para testar a 
         * variabilidade da capacidade.
         */
        sys.getComputerList().ordena();
        
        sys.getComputerList().get(0).setCapacity(100.0);
        sys.getComputerList().get(0).setFreeSize(100.0);
        
        sys.getComputerList().get(1).setCapacity(100.0);
        sys.getComputerList().get(1).setFreeSize(100.0);
        
        sys.getComputerList().get(2).setCapacity(100.0);
        sys.getComputerList().get(2).setFreeSize(100.0);
        
        sys.getComputerList().get(3).setCapacity(100.0);
        sys.getComputerList().get(3).setFreeSize(100.0);
        
        sys.getComputerList().get(4).setCapacity(100.0);
        sys.getComputerList().get(4).setFreeSize(100.0);
        
        sys.getComputerList().get(5).setCapacity(100.0);
        sys.getComputerList().get(5).setFreeSize(100.0);
        
        sys.getComputerList().get(6).setCapacity(100.0);
        sys.getComputerList().get(6).setFreeSize(100.0);
        
        sys.getComputerList().get(7).setCapacity(100.0);
        sys.getComputerList().get(7).setFreeSize(100.0);
        
        sys.getComputerList().get(8).setCapacity(100.0);
        sys.getComputerList().get(8).setFreeSize(100.0);
        
        sys.getComputerList().get(9).setCapacity(100.0);
        sys.getComputerList().get(9).setFreeSize(100.0);
        
        sys.getComputerList().get(10).setCapacity(100.0);
        sys.getComputerList().get(10).setFreeSize(100.0);
        
        sys.getComputerList().get(11).setCapacity(100.0);
        sys.getComputerList().get(11).setFreeSize(100.0);
        
        sys.getComputerList().get(12).setCapacity(100.0);
        sys.getComputerList().get(12).setFreeSize(100.0);
        
        sys.getComputerList().get(13).setCapacity(100.0);
        sys.getComputerList().get(13).setFreeSize(100.0);
        
        sys.getComputerList().get(14).setCapacity(100.0);
        sys.getComputerList().get(14).setFreeSize(100.0);
        
        sys.addImages();
        
        assertEquals("1 - hostPython11: 13.20000000000001 |"
                + " 2 - hostGitHub10: 13.0 |"
                + " 3 - hostKevin1: 12.800000000000006 |"
                + " 4 - hostLatino14: 12.499999999999998 |"
                + " 5 - hostCatra15: 12.100000000000001 |"
                + " 6 - hostJava9: 11.900000000000013 |"
                + " 7 - hostLinux7: 11.900000000000013 |"
                + " 8 - hostAllan2: 9.0 |"
                + " 9 - hostAlisson6: 8.899999999999999 |"
                + " 10 - hostPicachu12: 7.799999999999999 |"
                + " 11 - hostKakashi3: 7.79999999999999 |"
                + " 12 - hostXiaomi8: 5.900000000000004 |"
                + " 13 - hostTiago13: 5.700000000000006 |"
                + " 14 - hostEsdras4: 4.100000000000005 |"
                + " 15 - hostPatrick5: 0.8000000000000149 | ", sys.displayFreeSize());
    }
    
    /**
     * Teste de unidade que verifica se o método de mostrar o conteúdo (imgens) 
     * de um computador esá funcionando corretamente.
     */
    @Test
    public void listarConteudoDeUmComputador(){
        sys.addComputer();
        sys.getComputerList().ordena();
        sys.getComputerList().get(0).setCapacity(500.0);
        sys.getComputerList().get(0).setFreeSize(500.0);
        sys.addImages();
        assertEquals("dabcdefghijklmno.TIFF: 11.2 dabcdefghijklmnopqrst.TIFF: "
                + "11.8 dabcdefghijklmnopqrstuvwxy.TIFF: 12.7 eabcd.TIFF: 12.7 "
                + "eabcdefghijk.TIFF: 9.3 eabcdefghijklmnop.TIFF: 10.8 "
                + "eabcdefghijklmnopqrstuv.TIFF: 11.0 fab.TIFF: 9.8 "
                + "fabcdef.TIFF: 12.0 fabcdefghijklm.TIFF: 12.0 "
                + "fabcdefghijklmnopqrs.TIFF: 10.2 "
                + "fabcdefghijklmnopqrstuvwx.TIFF: 10.0 gabc.TIFF: 11.0 "
                + "gabcdefghi.TIFF: 10.7 gabcdefghijklmno.TIFF: 11.7 "
                + "gabcdefghijklmnopqrstuv.TIFF: 9.5 ha.TIFF: 13.7 "
                + "habcdefgh.TIFF: 11.7 habcdefghijklmn.TIFF: 9.5 "
                + "habcdefghijklmnopqrs.TIFF: 13.6 "
                + "habcdefghijklmnopqrstuvwxy.TIFF: 13.7 "
                + "iabcdef.TIFF: 11.1 iabcdefghijkl.TIFF: 9.2 "
                + "iabcdefghijklmnop.TIFF: 10.5 "
                + "iabcdefghijklmnopqrstuvw.TIFF: 13.0 "
                + "jabcdefg.TIFF: 10.0 jabcdefghijklm.TIFF: 11.6 "
                + "jabcdefghijklmnopqrstu.TIFF: 13.7 kabcdefg.TIFF: 10.4 "
                + "kabcdefghijklmnop.TIFF: 13.3 labc.TIFF: 10.3 "
                + "labcdefghijklmnop.TIFF: 13.1 mabcd.TIFF: 13.3 "
                + "mabcdefghijklmnopq.TIFF: 12.3 nabcdefg.TIFF: 10.4 "
                + "nabcdefghijklmnopqrst.TIFF: 9.6 oabcdefgh.TIFF: 11.8 "
                + "oabcdefghijklmnopqrstuv.TIFF: 10.8 pabcdefghijk.TIFF: 11.1 "
                + "pabcdefghijklmnopqrstuvwxy.TIFF: 13.3 "
                + "qabcdefghijklmn.TIFF: 10.4 ra.TIFF: 10.6 "
                + "rabcdefghijklmnop.TIFF: 12.3 ", sys.displayImagesOnComputer("hostKevin1"));
    }
    
    /**
     * Teste de unidade que verifica se a listagem das imagens que foram 
     * adicionadas no sitema está sendo feita corretamente.
     */
    @Test
    public void listarTodasAsImagens(){
        sys.addComputer();
        
        /* Alterando a capacidade e espaço livre de todos os computadores
           para o sistema não ser capaz de inserir todas as imagens.*/
        sys.getComputerList().get(0).setCapacity(100.0);
        sys.getComputerList().get(0).setFreeSize(100.0);
        
        sys.getComputerList().get(1).setCapacity(100.0);
        sys.getComputerList().get(1).setFreeSize(100.0);
        
        sys.getComputerList().get(2).setCapacity(100.0);
        sys.getComputerList().get(2).setFreeSize(100.0);
        
        sys.getComputerList().get(3).setCapacity(100.0);
        sys.getComputerList().get(3).setFreeSize(100.0);
        
        sys.getComputerList().get(4).setCapacity(100.0);
        sys.getComputerList().get(4).setFreeSize(100.0);
        
        sys.getComputerList().get(5).setCapacity(100.0);
        sys.getComputerList().get(5).setFreeSize(100.0);
        
        sys.getComputerList().get(6).setCapacity(100.0);
        sys.getComputerList().get(6).setFreeSize(100.0);
        
        sys.getComputerList().get(7).setCapacity(100.0);
        sys.getComputerList().get(7).setFreeSize(100.0);
        
        sys.getComputerList().get(8).setCapacity(100.0);
        sys.getComputerList().get(8).setFreeSize(100.0);
        
        sys.getComputerList().get(9).setCapacity(100.0);
        sys.getComputerList().get(9).setFreeSize(100.0);
        
        sys.getComputerList().get(10).setCapacity(100.0);
        sys.getComputerList().get(10).setFreeSize(100.0);
        
        sys.getComputerList().get(11).setCapacity(100.0);
        sys.getComputerList().get(11).setFreeSize(100.0);
        
        sys.getComputerList().get(12).setCapacity(100.0);
        sys.getComputerList().get(12).setFreeSize(100.0);
        
        sys.getComputerList().get(13).setCapacity(100.0);
        sys.getComputerList().get(13).setFreeSize(100.0);
        
        sys.getComputerList().get(14).setCapacity(100.0);
        sys.getComputerList().get(14).setFreeSize(100.0);
        
        // Verificando se não inseriu todas as imagens.
        assertEquals("Capacidade de disco esgotada!", sys.addImages()); 
        
        // Verificando as imagens que foram inseridas.
        assertEquals("aa.TIFF\n" +
                        "aab.TIFF\n" +
                        "aabc.TIFF\n" +
                        "aabcd.TIFF\n" +
                        "aabcde.TIFF\n" +
                        "aabcdef.TIFF\n" +
                        "aabcdefg.TIFF\n" +
                        "aabcdefgh.TIFF\n" +
                        "aabcdefghi.TIFF\n" +
                        "aabcdefghij.TIFF\n" +
                        "aabcdefghijk.TIFF\n" +
                        "aabcdefghijkl.TIFF\n" +
                        "aabcdefghijklm.TIFF\n" +
                        "aabcdefghijklmn.TIFF\n" +
                        "aabcdefghijklmno.TIFF\n" +
                        "aabcdefghijklmnop.TIFF\n" +
                        "aabcdefghijklmnopq.TIFF\n" +
                        "aabcdefghijklmnopqr.TIFF\n" +
                        "aabcdefghijklmnopqrs.TIFF\n" +
                        "aabcdefghijklmnopqrst.TIFF\n" +
                        "aabcdefghijklmnopqrstu.TIFF\n" +
                        "aabcdefghijklmnopqrstuv.TIFF\n" +
                        "aabcdefghijklmnopqrstuvw.TIFF\n" +
                        "aabcdefghijklmnopqrstuvwx.TIFF\n" +
                        "aabcdefghijklmnopqrstuvwxy.TIFF\n" +
                        "aabcdefghijklmnopqrstuvwxyz.TIFF\n" +
                        "ba.TIFF\n" +
                        "bab.TIFF\n" +
                        "babc.TIFF\n" +
                        "babcd.TIFF\n" +
                        "babcde.TIFF\n" +
                        "babcdef.TIFF\n" +
                        "babcdefg.TIFF\n" +
                        "babcdefgh.TIFF\n" +
                        "babcdefghi.TIFF\n" +
                        "babcdefghij.TIFF\n" +
                        "babcdefghijk.TIFF\n" +
                        "babcdefghijkl.TIFF\n" +
                        "babcdefghijklm.TIFF\n" +
                        "babcdefghijklmn.TIFF\n" +
                        "babcdefghijklmno.TIFF\n" +
                        "babcdefghijklmnop.TIFF\n" +
                        "babcdefghijklmnopq.TIFF\n" +
                        "babcdefghijklmnopqr.TIFF\n" +
                        "babcdefghijklmnopqrs.TIFF\n" +
                        "babcdefghijklmnopqrst.TIFF\n" +
                        "babcdefghijklmnopqrstu.TIFF\n" +
                        "babcdefghijklmnopqrstuv.TIFF\n" +
                        "babcdefghijklmnopqrstuvw.TIFF\n" +
                        "babcdefghijklmnopqrstuvwx.TIFF\n" +
                        "babcdefghijklmnopqrstuvwxy.TIFF\n" +
                        "babcdefghijklmnopqrstuvwxyz.TIFF\n" +
                        "ca.TIFF\n" +
                        "cab.TIFF\n" +
                        "cabc.TIFF\n" +
                        "cabcd.TIFF\n" +
                        "cabcde.TIFF\n" +
                        "cabcdef.TIFF\n" +
                        "cabcdefg.TIFF\n" +
                        "cabcdefgh.TIFF\n" +
                        "cabcdefghi.TIFF\n" +
                        "cabcdefghij.TIFF\n" +
                        "cabcdefghijk.TIFF\n" +
                        "cabcdefghijkl.TIFF\n" +
                        "cabcdefghijklm.TIFF\n" +
                        "cabcdefghijklmn.TIFF\n" +
                        "cabcdefghijklmno.TIFF\n" +
                        "cabcdefghijklmnop.TIFF\n" +
                        "cabcdefghijklmnopq.TIFF\n" +
                        "cabcdefghijklmnopqr.TIFF\n" +
                        "cabcdefghijklmnopqrs.TIFF\n" +
                        "cabcdefghijklmnopqrst.TIFF\n" +
                        "cabcdefghijklmnopqrstu.TIFF\n" +
                        "cabcdefghijklmnopqrstuv.TIFF\n" +
                        "cabcdefghijklmnopqrstuvw.TIFF\n" +
                        "cabcdefghijklmnopqrstuvwx.TIFF\n" +
                        "cabcdefghijklmnopqrstuvwxy.TIFF\n" +
                        "cabcdefghijklmnopqrstuvwxyz.TIFF\n" +
                        "da.TIFF\n" +
                        "dab.TIFF\n" +
                        "dabc.TIFF\n" +
                        "dabcd.TIFF\n" +
                        "dabcde.TIFF\n" +
                        "dabcdef.TIFF\n" +
                        "dabcdefg.TIFF\n" +
                        "dabcdefgh.TIFF\n" +
                        "dabcdefghi.TIFF\n" +
                        "dabcdefghij.TIFF\n" +
                        "dabcdefghijk.TIFF\n" +
                        "dabcdefghijkl.TIFF\n" +
                        "dabcdefghijklm.TIFF\n" +
                        "dabcdefghijklmn.TIFF\n" +
                        "dabcdefghijklmno.TIFF\n" +
                        "dabcdefghijklmnop.TIFF\n" +
                        "dabcdefghijklmnopq.TIFF\n" +
                        "dabcdefghijklmnopqr.TIFF\n" +
                        "dabcdefghijklmnopqrs.TIFF\n" +
                        "dabcdefghijklmnopqrst.TIFF\n" +
                        "dabcdefghijklmnopqrstu.TIFF\n" +
                        "dabcdefghijklmnopqrstuv.TIFF\n" +
                        "dabcdefghijklmnopqrstuvw.TIFF\n" +
                        "dabcdefghijklmnopqrstuvwx.TIFF\n" +
                        "dabcdefghijklmnopqrstuvwxy.TIFF\n" +
                        "dabcdefghijklmnopqrstuvwxyz.TIFF\n" +
                        "ea.TIFF\n" +
                        "eab.TIFF\n" +
                        "eabc.TIFF\n" +
                        "eabcd.TIFF\n" +
                        "eabcde.TIFF\n" +
                        "eabcdef.TIFF\n" +
                        "eabcdefg.TIFF\n" +
                        "eabcdefgh.TIFF\n" +
                        "eabcdefghi.TIFF\n" +
                        "eabcdefghij.TIFF\n" +
                        "eabcdefghijk.TIFF\n" +
                        "eabcdefghijkl.TIFF\n" +
                        "eabcdefghijklm.TIFF\n" +
                        "eabcdefghijklmn.TIFF\n" +
                        "eabcdefghijklmno.TIFF\n" +
                        "eabcdefghijklmnop.TIFF\n" +
                        "eabcdefghijklmnopq.TIFF\n" +
                        "eabcdefghijklmnopqr.TIFF\n", sys.displayAllImages());
    }
}

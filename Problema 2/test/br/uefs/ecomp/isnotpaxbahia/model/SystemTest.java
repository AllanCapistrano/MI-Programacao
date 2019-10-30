package br.uefs.ecomp.isnotpaxbahia.model;

import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class SystemTest {
    private Lote lote1, lote2, lote3, lote4, lote5, lote6;
    private Medico medico1, medico2;
    private Consulta consulta1, consulta2;
    private Exame exame1, exame2;
    private Paciente paciente1, paciente2, paciente3, paciente4;
    private Agendamento agendamento1, agendamento2, agendamento3, agendamento4, agendamento5, agendamento6;
    private Atendente atendente1, atendente2;
    private System sys;
    
    
    /**
     * Este método é executado antes de cada teste de unidade (testes a seguir),
     * e serve para inicializar objetos que são utilizados nos testes.
     */
    @Before
    public void setUp() throws Exception{
        sys = new System();
        
        medico1 = new Medico("Maria", 1995, "feminino", "9900-1131", "Cardiologista", 1547);
        medico2 = new Medico("George", 1990, "masculino", "5555-4432", "Oftalmologista", 1559);
        
        consulta1 = new Consulta(1101, medico1);
        consulta2 = new Consulta(1102, medico2);
        
        exame1 = new Exame("Sem recomendação", "Sem restrição", 1001, medico2);
        exame2 = new Exame("Repousar antes do exame", "Jejuar", 1002, medico1);

        /*quantidade, data, id, tipo de procedimento*/
        lote1 = new Lote(1, 1021, 1101, consulta1);
        lote2 = new Lote(3, 1022, 1001, exame1);
        lote3 = new Lote(2, 1022, 1102, consulta2);
        lote4 = new Lote(4, 1023, 1002, exame2);
        lote5 = new Lote(2, 1024, 1102, consulta2);
        lote6 = new Lote(3, 1025, 1001, exame1);
        
        paciente1 = new Paciente("Kevin", 1925, "masculino", "4002-8922", 1337);
        paciente2 = new Paciente("Lucas", 1992, "masculino", "3654-8922", 7896);
        paciente3 = new Paciente("Ayala", 1992, "feminino", "0909-8922", 8908);
        paciente4 = new Paciente("Sandra", 1992, "feminino", "6543-2101", 8900);
        
        atendente1 = new Atendente("Judite", 1990, "feminino", "9980-9819", 4567);
        atendente2 = new Atendente("Keannu", 1989, "masculino", "9980-9809", 9912);
        
        agendamento1 = new Agendamento(1021, paciente1, atendente1, consulta1);
        agendamento2 = new Agendamento(1022, paciente2, atendente2, exame1);
        agendamento3 = new Agendamento(1025, paciente3, atendente2, exame1);
        agendamento4 = new Agendamento(1022, paciente4, atendente2, consulta2);
        agendamento5 = new Agendamento(1025, paciente1, atendente1, exame1);
        agendamento6 = new Agendamento(1022, paciente1, atendente1, exame1);
        
    }
    
    /**
     * Teste de unidade que verifica se foi possível realizar os agendamentos, e
     * informa a situação, ou seja, se foi possível agendadar ou não e mostra o 
     * motivo.
     */
    @Test
    public void angendarConfirmados(){
        sys.getLote().add(lote1);
        sys.getLote().add(lote2);
        sys.getLote().add(lote3);
        sys.getLote().add(lote4);
        sys.getLote().add(lote5);
        sys.getLote().add(lote6);
        
        /*agendarPaciente verfica a possibilidade no lote do procedimento,
        caso possível instacia um novo agendamento e passa como parâmetro um 
        procedimento, e adiciona-o na lista de agendamento*/
        
        assertEquals(1, sys.getLote().search(1101, 1021).getQuantidade());
        sys.agendarPaciente(1021, paciente1, atendente1, 1101); // Criando um novo agendamento
        assertEquals(0, sys.getLote().search(1101, 1021).getQuantidade()); // Verificando se a quantidade do lote mudou para 0
        assertEquals(1, sys.getAgendamentos().size());
        
        assertEquals(3, sys.getLote().search(1001, 1022).getQuantidade());
        sys.agendarPaciente(1022, paciente2, atendente2, 1001);
        assertEquals(2, sys.getLote().search(1001, 1022).getQuantidade());
        assertEquals(2, sys.getAgendamentos().size());
        
        assertEquals(2, sys.getLote().search(1102, 1024).getQuantidade());
        sys.agendarPaciente(1024, paciente3, atendente2, 1102);
        assertEquals(1, sys.getLote().search(1102, 1024).getQuantidade());
        assertEquals(3, sys.getAgendamentos().size());
        
        sys.agendarPaciente(1115, paciente4, atendente1, 1001);// Pedindo numa data invalida
        sys.agendarPaciente(1021, paciente4, atendente1, 1101); // Pedindo numa data onde a quantidade de vaga acabou
        assertEquals(3, sys.getAgendamentos().size());//Tamanho continua em 3
        
    }
    
    /**
     * Teste de unidade que verifica a inserção de pacientes no sistema.
     */
    @Test
    public void cadastrarPaciente(){
        assertTrue(sys.getPacientes().isEmpty());
        
        sys.getPacientes().add(paciente1);
        sys.getPacientes().add(paciente2);
        sys.getPacientes().add(paciente3);
        
        assertFalse(sys.getPacientes().isEmpty());
        assertEquals(3, sys.getPacientes().size());
        
        assertEquals(paciente1, sys.getPacientes().get(0));
        assertEquals(paciente2, sys.getPacientes().get(1));
        assertEquals(paciente3, sys.getPacientes().get(2));
        
    }
    
    /**
     * Teste de unidade que procura um determinado paciente na lista de pacientes
     * com base no número do plano.
     */
    @Test
    public void buscarPaciente(){
        sys.getPacientes().add(paciente1);
        sys.getPacientes().add(paciente2);
        sys.getPacientes().add(paciente3);
        sys.getPacientes().add(paciente4);
        
        assertEquals(paciente2, sys.getPacientes().search(7896));
        assertEquals(paciente1, sys.getPacientes().search(1337));
        assertEquals(paciente3, sys.getPacientes().search(8908));
        assertEquals(paciente4, sys.getPacientes().search(8900));
        
    }
    
    /**
     * Teste de unidade que verifica a inserção dos procedimentos realizados na 
     * lista do histórico.
     */
    @Test
    public void inserirListaHistorico(){
        assertTrue(sys.getHistorico().isEmpty());
        
        assertNull(sys.proximoPaciente(1101, 1021));
        
        sys.getListaEspera().add(agendamento3, 2); /*add(agendamento, prioridade)*/
        sys.getListaEspera().add(agendamento5, 5);
        
        /*proximoPaciente(id, data)*/
        sys.proximoPaciente(1001, 1025); /*Método que chama um paciente para o seu procedimento, tira ele
                                                    da lista de espera e coloca na lista do historico*/
        assertEquals(agendamento5, sys.getHistorico().get(0));
        
        sys.proximoPaciente(1001, 1025);
        assertEquals(agendamento3, sys.getHistorico().get(1));
        
        assertFalse(sys.getHistorico().isEmpty());
        assertEquals(2, sys.getHistorico().size());
        
        assertTrue(sys.getListaEspera().isEmpty());
        assertEquals(0, sys.getListaEspera().size());
        
        
        assertNull(sys.proximoPaciente(1001, 1025));
    }
    
    /**
     * Teste de unidade que veifica os agendamentos que estão na lista de espera.
     */
    @Test
    public void verificarListaEspera(){
        /*Ordem que deve ficar: agendamento6, agendamento2, agendamento4*/
        sys.getListaEspera().add(agendamento2, 4);
        sys.getListaEspera().add(agendamento4, 1);
        sys.getListaEspera().add(agendamento6, 5);
        
        assertEquals(3, sys.getListaEspera().size());
        
        assertEquals(agendamento6, sys.proximoPaciente(1001, 1022));
        assertEquals(agendamento2, sys.proximoPaciente(1001, 1022));
        assertEquals(agendamento4, sys.proximoPaciente(1102, 1022));
        
        
        assertTrue(sys.getListaEspera().isEmpty());
        
        assertEquals(3, sys.getHistorico().size());
    }
    
    /**
     * Teste de unidade que procura um determinado agendamento na lista de 
     * historico com base no número do plano.
     */
    @Test
    public void buscarHistorico(){
        
        Iterator it;
        
        // Adiciona os procedimentos na fila de espera
        sys.getListaEspera().add(agendamento1, 4);
        sys.getListaEspera().add(agendamento2, 1);
        sys.getListaEspera().add(agendamento3, 3);
        sys.getListaEspera().add(agendamento4, 2);
        sys.getListaEspera().add(agendamento5, 1);
        sys.getListaEspera().add(agendamento6, 5);
        
        //chama os pacientes na ordem certa de cada dia
        assertEquals(agendamento1,sys.proximoPaciente(1101, 1021)); //agendamento1
        assertEquals(agendamento6, sys.proximoPaciente(1001, 1022)); //agendamento6
        assertEquals(agendamento4, sys.proximoPaciente(1102, 1022)); //agendamento4
        assertEquals(agendamento2,sys.proximoPaciente(1001, 1022)); //agendamento2
        assertEquals(agendamento3, sys.proximoPaciente(1001, 1025)); //agendamento3
        assertEquals(agendamento5, sys.proximoPaciente(1001, 1025)); //agendamento5
        
        it = sys.getHistorico().search(paciente1); //busca todos procedimentos realizados pelo paciente 1
        
        assertTrue(it.hasNext());
        assertEquals(agendamento1,it.next());
        assertTrue(it.hasNext());
        assertEquals(agendamento6,it.next());
        assertTrue(it.hasNext());
        assertEquals(agendamento5,it.next());
        
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        it = sys.getHistorico().search(exame2);//busca todos os procedimentos com exame 2 feitos
        assertFalse(it.hasNext());
        assertNull(it.next());
        
        it = sys.getHistorico().search(consulta1); //busca todos os procedimentos com consulta 1 feitos
        assertTrue(it.hasNext());
        assertEquals(agendamento1,it.next());
        assertFalse(it.hasNext());
        
        it = sys.getHistorico().search(medico1); //busca todos procedimentos realizados pelo medico 1
        assertTrue(it.hasNext());
        assertEquals(agendamento1,it.next());
        assertFalse(it.hasNext());
        assertNull(it.next());
        
    }
    
    /**
     * Teste de unidade que informa os pacientes que não compareceram para 
     * realizar os seus procedimentos agendados.
     */
    @Test
    public void informarAusentes(){
        
        sys.getAgendamentos().add(agendamento1);
        sys.getAgendamentos().add(agendamento2);
        sys.getAgendamentos().add(agendamento3);
        sys.getAgendamentos().add(agendamento4);
        sys.getAgendamentos().add(agendamento5);
        sys.getAgendamentos().add(agendamento6);
        
        sys.getListaEspera().add(agendamento6, 5);
        sys.proximoPaciente(1001, 1022);
        
        Iterator it = sys.getAgendamentos().searchPacientesAusentes(1022);
        assertTrue(it.hasNext());
        assertEquals(agendamento2, it.next());
        assertTrue(it.hasNext());
        assertEquals(agendamento4, it.next());
        
        assertFalse(it.hasNext());
        assertNull(it.next());
        
    }
    
    /**
     * Teste de unidade que verifica a inserção dos lotes na lista de lotes.
     */
    @Test
    public void lote(){
        assertTrue(sys.getLote().isEmpty());
        
        sys.getLote().add(lote1);
        sys.getLote().add(lote2);
        sys.getLote().add(lote3);
        sys.getLote().add(lote4);
        sys.getLote().add(lote5);
        sys.getLote().add(lote6);
        
        assertFalse(sys.getLote().isEmpty());
        
        assertEquals(lote1, sys.getLote().get(0));
        assertEquals(lote2, sys.getLote().get(1));
        assertEquals(lote3, sys.getLote().get(2));
        assertEquals(lote4, sys.getLote().get(3));
        assertEquals(lote5, sys.getLote().get(4));
        assertEquals(lote6, sys.getLote().get(5));
        
        assertEquals(6, sys.getLote().size());
    }
    
    /**
     * Teste de unidade que informa a situação atual dos agendamentos.
     */
    
    @Test
    public void informarSituacao(){
        sys.getLote().add(lote1);
        sys.getLote().add(lote2);
        sys.getLote().add(lote4);
        
        /*data, paciente, atendente, id do procedimento*/
        assertEquals(1, sys.getLote().search(1101, 1021).getQuantidade());
        assertEquals("Procedimento confirmado!", sys.agendarPaciente(1021, paciente1, atendente1, 1101));  
        assertEquals(0, sys.getLote().search(1101, 1021).getQuantidade());
        
        assertEquals(3, sys.getLote().search(1001, 1022).getQuantidade());
        assertEquals("Procedimento confirmado!", sys.agendarPaciente(1022, paciente2, atendente2, 1001));
        assertEquals(2, sys.getLote().search(1001, 1022).getQuantidade());
        
        assertEquals(4, sys.getLote().search(1002, 1023).getQuantidade());
        assertEquals("Procedimento confirmado!", sys.agendarPaciente(1023, paciente3, atendente2, 1002));
        assertEquals(3, sys.getLote().search(1002, 1023).getQuantidade());
        
        assertEquals(3, sys.getAgendamentos().size());
        
        assertEquals("Procedimento indisponível para data escolhida", sys.agendarPaciente(1115, paciente4, atendente1, 1001));
        assertEquals("Procedimento esgotado", sys.agendarPaciente(1021, paciente4, atendente1, 1101));
        assertEquals(3, sys.getAgendamentos().size());
           
    }
}

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PassageiroTest {

    @Test
    public void testCPFValido() {
        assertTrue(Passageiro.validarCPF("52998224725"));
    }

    @Test
    public void testCPFInvalido() {
        assertFalse(Passageiro.validarCPF("12345678900"));
    }

    @Test
    public void testEmailValido() {
        assertTrue(Passageiro.validarEmail("teste@email.com"));
    }

    @Test
    public void testEmailInvalido() {
        assertFalse(Passageiro.validarEmail("email@invalido@com"));
    }

    @Test
    public void testCadastroPassageiro() {
        ArrayList<Passageiro> lista = new ArrayList<>();
        Passageiro p = new Passageiro(1, "João", "52998224725", "joao@email.com");
        lista.add(p);

        assertEquals(1, lista.size());
        assertEquals("João", lista.get(0).getNome());
    }
}

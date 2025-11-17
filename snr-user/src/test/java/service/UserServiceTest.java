package service;

import com.ies9021.snr.dao.UserDAO;
import com.ies9021.snr.model.User;
import com.ies9021.snr.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TESTING DE CAJA BLANCA – UserService
 */
public class UserServiceTest {

    private UserService service;
    private UserDAO daoMock;

    @BeforeEach
    public void setUp() {
        daoMock = mock(UserDAO.class);
        service = new UserService(daoMock);
    }

    // -----------------------------
    // 1. TEST: Crear usuario válido
    // -----------------------------
    @Test
    public void testCreateUser_DatosValidos() {
        User u = new User();
        u.setName("Pablo");
        u.setEmail("pablo@mail.com");
        u.setPassword("1234");
        u.setDni("30123123");

        when(daoMock.insertUser(any(User.class))).thenReturn(true);

        boolean resultado = service.createUser(u);

        assertTrue(resultado);
        verify(daoMock, times(1)).insertUser(any(User.class));
    }

    // -------------------------------------------------
    // 2. TEST: Falla porque el nombre está vacío
    // -------------------------------------------------
    @Test
    public void testCreateUser_NombreVacio() {
        User u = new User();
        u.setName("");
        u.setEmail("a@a.com");
        u.setPassword("123");
        u.setDni("30303030");

        boolean resultado = service.createUser(u);

        assertFalse(resultado);
        verify(daoMock, never()).insertUser(any());
    }

    // -------------------------------------------------
    // 3. TEST: updateUser falla porque ID = 0
    // -------------------------------------------------
    @Test
    public void testUpdateUser_IdInvalido() {
        User u = new User();
        u.setIdUser(0);
        u.setName("Juan");

        boolean resultado = service.updateUser(u);

        assertFalse(resultado);
        verify(daoMock, never()).updateUser(any());
    }

    // -------------------------------------------------
    // 4. TEST: updateUser falla porque nombre vacío
    // -------------------------------------------------
    @Test
    public void testUpdateUser_NombreVacio() {
        User u = new User();
        u.setIdUser(5);
        u.setName("");

        boolean resultado = service.updateUser(u);

        assertFalse(resultado);
        verify(daoMock, never()).updateUser(any());
    }

    // -------------------------------------------------
    // 5. TEST: deleteUser con ID negativo
    // -------------------------------------------------
    @Test
    public void testDeleteUser_IdNegativo() {
        boolean resultado = service.deleteUser(-2);

        assertFalse(resultado);
        verify(daoMock, never()).deleteUser(anyInt());
    }

    // -------------------------------------------------
    // 6. TEST: deleteUser con ID válido
    // -------------------------------------------------
    @Test
    public void testDeleteUser_Valido() {
        when(daoMock.deleteUser(anyInt())).thenReturn(true);

        boolean resultado = service.deleteUser(10);

        assertTrue(resultado);
        verify(daoMock, times(1)).deleteUser(10);
    }
}

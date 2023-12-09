package co.edu.escuelaing.cvds.lab7.controller;
import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private Model model;

    @InjectMocks
    private LoginController loginController;

    @Test
    void testShowLoginPage() {
        String result = loginController.showLoginPage();

        assertEquals("login", result);
    }

    @Test
    void testLoginSuccess() {
        String username = "user.jc";
        String password = "password";
        String plato = "somePlato";
        User user = new User(username, password, "email");

        when(userService.findUserByUsername(username)).thenReturn(user);

        String result = loginController.login(username, password, plato, model);

        assertEquals("redirect:/cocina", result);
        verify(model, never()).addAttribute(eq("error"), anyString());
    }

    @Test
    void testLoginFailure() {
        String username = "user";
        String password = "wrongPassword";
        String plato = "somePlato";

        when(userService.findUserByUsername(username)).thenReturn(null);

        String result = loginController.login(username, password, plato, model);

        assertEquals("login", result);
        verify(model).addAttribute("error", "Credenciales inválidas");
    }

    @Test
    void testLoginRedirectToPrueba() {
        String username = "user";
        String password = "correctPassword";
        String plato = "somePlato";
        User user = new User(username, password, "email");

        when(userService.findUserByUsername(username)).thenReturn(user);

        String result = loginController.login(username, password, plato, model);

        assertEquals("redirect:/prueba", result);
        verify(model, never()).addAttribute(eq("error"), anyString());
    }

    // Puedes agregar más pruebas según tus necesidades

}

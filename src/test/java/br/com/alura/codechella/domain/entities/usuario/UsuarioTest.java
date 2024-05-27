package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "Jacque", LocalDate.parse("1990-09-08"), "email@email.com"));
    }

    @Test
    public void deveCadastrarUsuarioComCpfNoFOrmatoValido(){

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "Jacque", LocalDate.parse("1990-09-08"), "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioComFabricaDeUsuario(){

        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Emily", "654.123.897-88", LocalDate.parse("2000-10-01"));

        Assertions.assertEquals("Emily",usuario.getNome());
        Assertions.assertEquals("654.123.897-88", usuario.getCpf());
        Assertions.assertEquals(LocalDate.parse("2000-10-01"), usuario.getNascimento());

        usuario = fabrica.incluirEndereco("12345-000", 40, "apto 201");

        Assertions.assertEquals("12345-000", usuario.getEndereco().getCep());
        Assertions.assertEquals(40, usuario.getEndereco().getNumero());
        Assertions.assertEquals("apto 201", usuario.getEndereco().getComplemento());
    }
}

package es.ieslavereda.exercice1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    Persona p1, p2, p3, p4;

    @BeforeEach
    void setUp() {
        p1 = new Persona("Pepa","Navarro",18);
        p2 = new Persona("Luna","García",40);
        p3 = new Persona("Blanca","Romero",80);
        p4 = new Persona("Manuel","Cano",17);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calcularIMC() {
        p1.setAltura(1.94);
        p1.setPeso(69.6);
        p2.setAltura(1.94);
        p2.setPeso(70);
        p3.setAltura(1.94);
        p3.setPeso(112.75);
        p4.setAltura(1.94);
        p4.setPeso(113);

        assertAll(() -> assertEquals(-1,p1.calcularIMC()),
                () -> assertEquals(0,p2.calcularIMC()),
        () -> assertEquals(1,p3.calcularIMC()),
        () -> assertEquals(2,p4.calcularIMC())
        );


    }

    @Test
    void esMayorDeEdad() {
        assertAll(() -> assertTrue(p1.esMayorDeEdad()),
                () -> assertTrue(p2.esMayorDeEdad()),
                () -> assertTrue(p3.esMayorDeEdad()),
                () -> assertFalse(p4.esMayorDeEdad())
        );
    }
}
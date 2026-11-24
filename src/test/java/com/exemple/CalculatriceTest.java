package com.exemple;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatriceTest {

    private final Calculatrice calc = new Calculatrice();

    @Test
    void additionDeuxNombres() {
         assertEquals(5, calc.additionner(2, 3)); 
    }

    @Test
    void divisionNormale() {
        assertEquals(2, calc.diviser(6, 3));
    }

    @Test
    void divisionParZeroLeveUneException() {
        assertThrows(IllegalArgumentException.class, () -> calc.diviser(1, 0));
    }
} 
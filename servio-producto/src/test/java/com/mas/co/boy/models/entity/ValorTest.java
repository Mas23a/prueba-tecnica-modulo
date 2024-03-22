/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mas.co.boy.models.entity;

import com.mas.co.boy.exception.ValorErroresException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ValorTest {
    
    Valor valor;
    
    @BeforeEach
    void initMetodotest(){
        this.valor= new Valor(10, 5, 15,0);
    }

    @Test
    void testValorX() {
        Integer esperado =10;
        Integer real = valor.getValorX();

        assertEquals(esperado, real);

    }
    @Test
    void testValorY() {

        valor.setValorY(10);

        Integer esperado =10;
        Integer real = valor.getValorY();

        assertEquals(esperado, real);

    }
    @Test
    void testValorN() {

        valor.setValorN(10);

        Integer esperado =10;
        Integer real = valor.getValorN();

        assertEquals(esperado, real);

    }
  
    
    @Test
    void testValorErroresException(){
       
        this.valor= new Valor(1,0,-1,0);
        
        Exception exception = assertThrows(ValorErroresException.class, ()->{
            
            valor.calcularMaximo(valor.getValorX(), valor.getValorY(), valor.getValorN());
        });
        String actual= exception.getMessage();
        String esperado= "Valor fuera del rango";
        
        assertEquals(actual,esperado);
        
        
    }

}

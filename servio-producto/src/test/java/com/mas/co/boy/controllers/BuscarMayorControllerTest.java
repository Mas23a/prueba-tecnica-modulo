/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mas.co.boy.controllers;

import com.mas.co.boy.models.entity.Valor;
import com.mas.co.boy.models.service.ValorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BuscarMayorController.class)
public class BuscarMayorControllerTest {
   
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private ValorServiceImpl valorService;
    
     Valor valor;
      Integer valorX;
    Integer valorY;
    Integer valorN;
    
    @BeforeEach
    void initMetodotest(){
        this.valor= new Valor(10, 5, 15,15);
         this.valorX=10;
        this.valorY=5;
        this.valorN=15;
    }
    
    @Test
    void testBuscarMayor() throws Exception{
        
        when(valorService.findValor(this.valorX, this.valorY, this.valorN)).thenReturn(this.valor);
        
        mvc.perform(get("/api/buscar/10/5/15").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.valorX").value(10))
                .andExpect(jsonPath("$.valorY").value(5))
                ;
    }
    
}

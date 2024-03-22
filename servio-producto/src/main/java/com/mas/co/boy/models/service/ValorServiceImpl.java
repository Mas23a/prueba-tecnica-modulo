/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mas.co.boy.models.service;

import com.mas.co.boy.exception.ValorErroresException;
import com.mas.co.boy.models.entity.Valor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;




@Service
public class ValorServiceImpl implements IValorService{
    
   private static final Logger logger = LoggerFactory.getLogger(ValorServiceImpl.class);

    @Override
    public Valor findValor(Integer valorX, Integer valorY, Integer valorN) {
        
        Valor valor = new Valor();
        
        try {
        Integer valorMaximo= valor.calcularMaximo(valorX, valorY, valorN);
        
        valor.setValorX(valorX);
        valor.setValorY(valorY);
        valor.setValorN(valorN);
        valor.setValorMaximo(valorMaximo);
            return valor;
        } catch (ValorErroresException e) {
            logger.error(e.getMessage());
            return null;
        }
      
    }
    
  
    
}

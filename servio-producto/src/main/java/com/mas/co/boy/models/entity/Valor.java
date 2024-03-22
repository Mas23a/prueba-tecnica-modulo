/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mas.co.boy.models.entity;

import com.mas.co.boy.exception.ValorErroresException;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Valor {
    
  

    @NotEmpty
    private Integer valorX;
    @NotEmpty
    private Integer valorY;
    @NotEmpty
    private Integer valorN;

    private Integer valorMaximo;
    
    public void valorFueraRango(Integer valorMax, Integer valorY, Integer valorN){
        
        if(valorMax!=valorY ){
            throw new ValorErroresException("Valor fuera del rango");
        }
        
        
    }
    
    public Integer calcularResiduo(Integer valorK,Integer valorX){
        
        Integer residuo= valorK%valorX;
        
        return residuo;
        
    }
    
    
    public Integer calcularMaximo(Integer valorX, Integer valorY, Integer valorN){
        
         
        int valorMax=0;
        
        for (int k = 0; k <= valorN; k++) {
            Integer residuo= this.calcularResiduo(k, valorX);
            if(Objects.equals(residuo, valorY)){
                valorMax=k;
            }
        }
        
        if(valorMax<0 || valorMax>valorN){
            throw new ValorErroresException("Valor fuera del rango");
        }
        
        return valorMax;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mas.co.boy.models.service;

import com.mas.co.boy.models.entity.Valor;


public interface IValorService {
    
    Valor findValor(Integer valorX, Integer valorY, Integer valorN);
    
}

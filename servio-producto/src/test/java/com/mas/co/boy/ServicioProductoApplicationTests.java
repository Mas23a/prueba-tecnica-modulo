package com.mas.co.boy;

import com.mas.co.boy.models.entity.Valor;
import com.mas.co.boy.models.service.ValorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServicioProductoApplicationTests {
    
    ValorServiceImpl valorService;
    Valor valor;
    Integer valorX;
    Integer valorY;
    Integer valorN;
    @BeforeEach
    void metodoIncial(){
        
        valorService= new ValorServiceImpl();
        this.valor= new Valor(10, 5, 15,15);
        this.valorX=10;
        this.valorY=5;
        this.valorN=15;
        
    }
    

	@Test
	void contextLoads() {
            
            Valor valorMaximo= valorService.findValor(this.valorX, this.valorY, this.valorN);
            Assertions.assertEquals(valorMaximo.getValorMaximo(), this.valor.getValorMaximo());
            
	}

}

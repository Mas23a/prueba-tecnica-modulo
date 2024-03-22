package com.mas.co.boy.controllers;

import com.mas.co.boy.models.entity.Valor;
import com.mas.co.boy.models.service.IValorService;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BuscarMayorController {

    @Autowired
    private IValorService valorService;

    @GetMapping("/buscar/{valorX}/{valorY}/{valorN}")
    public ResponseEntity<?> buscarMayor(@Valid @PathVariable Integer valorX, @PathVariable Integer valorY, @PathVariable Integer valorN) {

        Valor valorNuevo;

        Map<String, Object> response = new HashMap<>();
      

        if (valorX != null && valorY != null && valorN != null ) {

            valorNuevo = valorService.findValor(valorX, valorY, valorN );

            response.put("valor", valorNuevo);
            return new ResponseEntity<>(valorNuevo, HttpStatus.OK);
        } else {
            response.put("error", "Valores Vacíos");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }

    }

}

package com.bancocpm.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bancocpm.atm.services.ClienteService;
import com.bancocpm.atm.services.CuentaService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ClienteService clienteService;
    private final CuentaService cuentaService;

    @GetMapping               //define que va despues de /admin
    public String adminHome(){
        return "admin/index";
    }

}

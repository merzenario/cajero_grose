package com.bancocpm.atm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bancocpm.atm.entity.Cliente;
import com.bancocpm.atm.entity.Cuenta;
import com.bancocpm.atm.entity.TipoCuenta;
import com.bancocpm.atm.repository.CuentaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CuentaService {
    private final CuentaRepository cuentaRepository;
    public Cuenta crearCuenta(Cliente cliente, String numero, TipoCuenta tipo,double saldoInicial){
        Cuenta cuenta = Cuenta.builder()
        .cliente(null)
        .numero(numero)
        .tipo(tipo)
        .saldo(saldoInicial)
        .build();
        return cuentaRepository.save(cuenta);
    }

    public Optional<Cuenta> buscarPorNumero(String numero){
        return cuentaRepository.findByNumero(numero);
    }

    public double ConsultarSaldo(Cuenta cuenta){
        return cuenta.getSaldo();
    }

    public List<Cuenta> obtenerCuentasCliente(Cliente cliente){
        return cliente.getCuentas();
    }

    public void actualizarSaldo(Cuenta cuenta, double nuevoSaldo){
        cuenta.setSaldo(nuevoSaldo);
        cuentaRepository.save(cuenta);
    }

    public List<Cuenta> buscarPorCliente(Cliente cliente){
        return cuentaRepository.findByCliente(cliente);
    }

    public Cuenta obtenerCuentaPorClienteActual(String username){
        throw new UnsupportedOperationException("Not impelented yet.");
    }

}

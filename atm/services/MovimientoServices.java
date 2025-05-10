package com.bancocpm.atm.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bancocpm.atm.entity.Cuenta;
import com.bancocpm.atm.entity.Movimiento;
import com.bancocpm.atm.entity.TipoMovimiento;
import com.bancocpm.atm.repository.CuentaRepository;
import com.bancocpm.atm.repository.MovimientoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoServices {
    
        private final MovimientoRepository movimientoRepository;
        private final CuentaRepository cuentaRepository;
    
        public Movimiento registrarMovimiento(Cuenta cuenta, TipoMovimiento tipo, double monto){
            Movimiento movimiento = Movimiento.builder()
                .cuenta(cuenta)
                .tipo(tipo)
                .monto(monto)
                .fecha(LocalDateTime.now())
                .build();
            return movimientoRepository.save(movimiento);
        }

        public List<Movimiento> obtenerMovimientosPorCuenta(Cuenta cuenta, double monto){
            return movimientoRepository.findByCuenta(cuenta);
        }

        public boolean realizarRetiro(Cuenta cuenta, double monto){
            if(cuenta.getSaldo() >= monto){
                cuenta.setSaldo(cuenta.getSaldo() - monto);
                cuentaRepository.save(cuenta);
                registrarMovimiento(cuenta, TipoMovimiento.RETIRO, monto);
                return true;
            }
            return false;
        }

        public boolean realizarTransferencia(Cuenta origen, Cuenta destino, double monto){
            if (origen.getSaldo()>= monto){
                origen.setSaldo(destino.getSaldo() - monto);
                destino.setSaldo(destino.getSaldo() + monto);
                cuentaRepository.save(origen);
                cuentaRepository.save(destino);

                registrarMovimiento(origen, TipoMovimiento.TRANSFERENCIA, monto);
                registrarMovimiento(destino, TipoMovimiento.TRANSFERENCIA, monto);

                return true;

            }return false;
        }

        public List<Movimiento> buscarPorCuenta(String numeroCuenta){
            Cuenta cuenta = cuentaRepository.findByNumero(numeroCuenta)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
                return movimientoRepository.findByCuentaOrderByFechaDesc(cuenta);
        }

        public boolean realizarConsignacion(Cuenta cuenta, double monto){
            if(monto <= 0){
                throw new IllegalArgumentException("El monto debe ser mayor a cero");
            }
            cuenta.setSaldo(cuenta.getSaldo() + monto);
            cuentaRepository.save(cuenta);
            registrarMovimiento(cuenta, TipoMovimiento.CONSIGNACION, monto);
            return true;
        }
}

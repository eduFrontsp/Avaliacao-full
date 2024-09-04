package com.example.financeTransfer.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TaxaServico {
    public BigDecimal calcularTaxa(LocalDate dataAgendamento, LocalDate dataTransferencia, BigDecimal valor) throws IllegalAccessException {
        long dias = ChronoUnit.DAYS.between(dataAgendamento, dataTransferencia);

        if(dias == 0) {
            return valor.multiply(BigDecimal.valueOf(0.025)).add(BigDecimal.valueOf(3.00));
        } else if(dias >= 1 && dias <= 10) {
            return BigDecimal.valueOf(12.00);
        } else if (dias >= 11 && dias <= 20) {
            return BigDecimal.valueOf(0.082);
        } else if (dias >= 21 && dias <= 30) {
            return valor.multiply(BigDecimal.valueOf(0.069));
        } else if (dias >= 31 && dias <= 40) {
            return valor.multiply(BigDecimal.valueOf(0.047));
        } else if (dias >= 41 && dias <= 50) {
            return valor.multiply(BigDecimal.valueOf(0.017));
        } else {
            throw new IllegalAccessException("transferencia nao permitida");
        }
    }
}

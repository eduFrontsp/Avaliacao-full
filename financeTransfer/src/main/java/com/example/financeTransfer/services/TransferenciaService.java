package com.example.financeTransfer.services;

import com.example.financeTransfer.entity.Transferencia;
import com.example.financeTransfer.repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransferenciaService {

    @Autowired
    private TransferenciaRepository transferenciaRepository;
    @Autowired
    private TaxaServico taxaServico;

    public Transferencia agendarTransferencia(String contaOrigem, String contaDestino, BigDecimal valor, LocalDate dataTransferencia) throws IllegalAccessException {
        LocalDate dataAgendamento = LocalDate.now();
        BigDecimal taxa = taxaServico.calcularTaxa(dataAgendamento, dataTransferencia, valor);

        Transferencia transferencia = new Transferencia();
        transferencia.setContaOrigem(contaOrigem);
        transferencia.setContaDestino(contaDestino);
        transferencia.setValor(valor);
        transferencia.setDataTransferencia(dataTransferencia);
        transferencia.setDataAgendamento(dataAgendamento);

        return transferenciaRepository.save(transferencia);
    }
    public List<Transferencia>listarTransferencia() {
        return transferenciaRepository.findAll();
    }
}

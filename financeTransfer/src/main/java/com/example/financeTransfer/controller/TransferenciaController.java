package com.example.financeTransfer.controller;

import com.example.financeTransfer.entity.Transferencia;
import com.example.financeTransfer.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    private TransferenciaService transferenciaService;

    @PostMapping("/agendar")
    public ResponseEntity<Transferencia>agendarTransferencia(@RequestParam String contaOrigem,
                                                             @RequestParam String contaDestino,
                                                             @RequestParam BigDecimal valor,
                                                             @RequestParam LocalDate dataTransferencia) {
        try {
            Transferencia transferencia = transferenciaService.agendarTransferencia(contaOrigem, contaDestino, valor, dataTransferencia);
            return ResponseEntity.ok(transferencia);
        }catch (IllegalAccessException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @GetMapping("/extrato")
    public ResponseEntity<List<Transferencia>> listarTransferencia() {
        return ResponseEntity.ok(transferenciaService.listarTransferencia());
    }
}

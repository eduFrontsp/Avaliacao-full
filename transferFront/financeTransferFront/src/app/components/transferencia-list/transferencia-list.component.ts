import { Component, OnInit } from '@angular/core';
import { Transferencia, TransferenciaService } from '../../service/transferencia.service';

@Component({
  selector: 'app-transferencia-list',
  templateUrl: './transferencia-list.component.html',
  styleUrl: './transferencia-list.component.css'
})
export class TransferenciaListComponent implements OnInit {
  transferencias: Transferencia[] = []

  constructor(private transferenciaService: TransferenciaService) { }

  ngOnInit(): void {
    this.transferenciaService.listarTransferencia()
      .subscribe(transferencias => this.transferencias = transferencias)
  }
}

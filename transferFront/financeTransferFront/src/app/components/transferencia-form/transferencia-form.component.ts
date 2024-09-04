import { Component } from '@angular/core';
import { Transferencia, TransferenciaService } from '../../service/transferencia.service';

@Component({
  selector: 'app-transferencia-form',
  templateUrl: './transferencia-form.component.html',
  styleUrl: './transferencia-form.component.css'
})
export class TransferenciaFormComponent {

  transferencia: Transferencia = {
    contaOrigem: '',
    contaDestino: '',
    valor: 0,
    dataTransferencia: ''
  }

  mensagemErro: string | null = null

  constructor(private transferenciaService: TransferenciaService) { }

  agendarTransferencia() {
    this.transferenciaService.agendarTransferencia(this.transferencia)
      .subscribe({
        next: () => {
          this.mensagemErro = null
          alert('transferencia foi agendada')
          this.transferencia = { contaOrigem: '', contaDestino:'', valor: 0, dataTransferencia: ''}
        },
        error: (error) => {
          this.mensagemErro = 'Erro no agendamento da transferencia' + error.error.message
        }
      })
  }

}

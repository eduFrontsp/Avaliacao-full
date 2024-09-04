import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Transferencia {
  id?: number
  contaOrigem: String
  contaDestino: string
  valor: number
  taxa?: number
  dataTransferencia: string
  dataAgendamento?:string
}

@Injectable({
  providedIn: 'root'
})
export class TransferenciaService {

  private apiUrl = 'http://localhost:8080/transferencias'

  constructor(private http: HttpClient) { }

  agendarTransferencia(transferencia: Transferencia): Observable<Transferencia> {
    return this.http.post<Transferencia>(`${this.apiUrl}/agendar`, transferencia)
  }
  listarTransferencia(): Observable<Transferencia[]> {
    return this.http.get<Transferencia[]>(`${this.apiUrl}/extrato`)
  }
}

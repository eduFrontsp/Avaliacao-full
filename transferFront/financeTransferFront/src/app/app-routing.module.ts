import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TransferenciaFormComponent } from './components/transferencia-form/transferencia-form.component';
import { TransferenciaListComponent } from './components/transferencia-list/transferencia-list.component';

const routes: Routes = [
  { path: 'agendar', component: TransferenciaFormComponent },
  { path: 'extrato', component: TransferenciaListComponent },
  { path: '', redirectTo: '/agendar', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

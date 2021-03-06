import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CadastrarClienteComponent } from './person/view/cliente/cadastrar-cliente/cadastrar-cliente.component';
import { ListarClienteComponent } from './person/view/cliente/listar-cliente/listar-cliente.component';
import { HomeComponent } from './home/home.component';
import { CadastrarFornecedorComponent } from './person/view/fornecedor/cadastrar-fornecedor/cadastrar-fornecedor.component';
import { ListarFornecedorComponent } from './person/view/fornecedor/listar-fornecedor/listar-fornecedor.component';
import { CadastrarAnoModeloComponent } from './customer/view/anoModelo/cadastrar-ano-modelo/cadastrar-ano-modelo.component';
import { ListarAnoModeloComponent} from './customer/view/anoModelo/listar-ano-modelo/listar-ano-modelo.component';
import { CadastrarCorComponent} from  './customer/view/cor/cadastrar-cor/cadastrar-cor.component';
import { ListarCorComponent} from './customer/view/cor/listar-cor/listar-cor.component';
import { CadastrarFabricanteComponent} from  './customer/view/fabricante/cadastrar-fabricante/cadastrar-fabricante.component';
import { ListarFabricanteComponent} from './customer/view/fabricante/listar-fabricante/listar-fabricante.component';
import { CadastrarModeloComponent} from  './customer/view/modelo/cadastrar-modelo/cadastrar-modelo.component';
import { ListarModeloComponent} from './customer/view/modelo/listar-modelo/listar-modelo.component';
import { CadastrarVeiculoComponent} from  './customer/view/veiculo/cadastrar-veiculo/cadastrar-veiculo.component';
import { ListarVeiculoComponent} from './customer/view/veiculo/listar-veiculo/listar-veiculo.component';
import { CadastroOrderComponent } from './order/view/cadastro-order/cadastro-order.component';
import { CadastrarEstoqueComponent } from './store/view/estoque/cadastrar-estoque/cadastrar-estoque.component';
import { ListarEstoqueComponent } from './store/view/estoque/listar-estoque/listar-estoque.component';
import { ListarOrderComponent } from './order/view/listar-order/listar-order.component';
import { ListarPorClienteComponent } from './order/view/listar-por-cliente/listar-por-cliente.component';
import { ListarServicoComponent } from './store/view/servico/listar-servico/listar-servico.component';
import { CadastrarServicoComponent } from './store/view/servico/cadastrar-servico/cadastrar-servico.component';
import { CadastrarNotaComponent } from './store/view/cadastrar-nota/cadastrar-nota.component';
import { ListarNotaComponent } from './store/view/listar-nota/listar-nota.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent},
  { path: 'cadastrarCliente', component: CadastrarClienteComponent},
  { path: 'listarCliente', component: ListarClienteComponent},
  { path: 'cadastrarFornecedor', component: CadastrarFornecedorComponent},
  { path: 'listarFornecedor', component: ListarFornecedorComponent},
  { path: 'cadastrarAnoModelo', component: CadastrarAnoModeloComponent},
  { path: 'listarAnoModelo', component: ListarAnoModeloComponent},
  { path: 'cadastrarCor', component: CadastrarCorComponent},
  { path: 'listarCor', component: ListarCorComponent},
  { path: 'cadastrarFabricante', component: CadastrarFabricanteComponent},
  { path: 'listarFabricante', component: ListarFabricanteComponent},
  { path: 'cadastrarVeiculo', component: CadastrarVeiculoComponent},
  { path: 'listarVeiculo', component: ListarVeiculoComponent},
  { path: 'cadastrarModelo', component: CadastrarModeloComponent},
  { path: 'listarModelo', component: ListarModeloComponent},
  { path: 'cadastroOrdem',component: CadastroOrderComponent},
  { path: 'cadastrarEstoque', component: CadastrarEstoqueComponent},
  { path: 'listarEstoque', component: ListarEstoqueComponent},
  { path: 'listarOrdem', component: ListarOrderComponent},
  { path: 'listarPorCliente', component: ListarPorClienteComponent},
  { path: 'listarServico', component: ListarServicoComponent},
  { path: 'cadastrarServico', component: CadastrarServicoComponent},
  { path: 'cadastrarNota', component: CadastrarNotaComponent},
  { path: 'listarNota', component: ListarNotaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

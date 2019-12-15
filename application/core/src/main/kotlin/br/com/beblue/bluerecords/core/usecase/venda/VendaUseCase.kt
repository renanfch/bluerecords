package br.com.beblue.bluerecords.core.usecase.venda

import br.com.beblue.bluerecords.core.entity.Venda
import br.com.beblue.bluerecords.core.usecase.venda.command.ConsultaVendasCommand
import br.com.beblue.bluerecords.core.usecase.venda.command.RegistrarVendaCommand

interface VendaUseCase {
    fun registrarVenda(command: RegistrarVendaCommand): Venda
    fun consultarVendas(command: ConsultaVendasCommand): List<Venda>
    fun consultarVendaPorId(id: Int): Venda
}
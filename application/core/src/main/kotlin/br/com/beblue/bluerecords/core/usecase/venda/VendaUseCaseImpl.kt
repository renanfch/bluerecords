package br.com.beblue.bluerecords.core.usecase.venda

import br.com.beblue.bluerecords.core.entity.Venda
import br.com.beblue.bluerecords.core.repository.VendaRepositorio
import br.com.beblue.bluerecords.core.usecase.venda.command.ConsultaVendasCommand
import br.com.beblue.bluerecords.core.usecase.venda.command.RegistrarVendaCommand

class VendaUseCaseImpl(
    private val vendaRepositorio: VendaRepositorio
) : VendaUseCase {

    override fun registrarVenda(command: RegistrarVendaCommand): Venda {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun consultarVendas(command: ConsultaVendasCommand): List<Venda> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun consultarVendaPorId(id: Int): Venda {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
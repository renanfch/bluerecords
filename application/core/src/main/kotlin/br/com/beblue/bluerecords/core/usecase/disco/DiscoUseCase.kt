package br.com.beblue.bluerecords.core.usecase.disco

import br.com.beblue.bluerecords.core.entity.Disco
import br.com.beblue.bluerecords.core.usecase.disco.command.ConsultaDiscosCommand

interface DiscoUseCase
{
    fun consultarDiscoPorId(id: Int): Disco
    fun consultarDiscosPorGenero(consultaDiscosCommand: ConsultaDiscosCommand): List<Disco>
}
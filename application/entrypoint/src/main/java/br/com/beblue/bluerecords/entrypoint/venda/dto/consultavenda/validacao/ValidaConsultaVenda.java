package br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.validacao;

import br.com.beblue.bluerecords.entrypoint.util.DataUtil;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.ConsultarVendaDTO;

public class ValidaConsultaVenda
{
    public static boolean valida(ConsultarVendaDTO consultarVendaDTO)
    {
        if(!DataUtil.validarStringParaData(consultarVendaDTO.getDataInicial()))
            return false;

        if(!DataUtil.validarStringParaData(consultarVendaDTO.getDataFinal()))
            return false;

        return true;
    }
}

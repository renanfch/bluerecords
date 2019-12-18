package br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.validacao;

import br.com.beblue.bluerecords.entrypoint.util.DataUtil;
import br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.RegistrarVendaRequestDTO;

public class ValidaRegistraVenda
{
    public static boolean valida(RegistrarVendaRequestDTO registrarVendaRequestDTO)
    {
        if(!DataUtil.validarStringParaData(registrarVendaRequestDTO.getDate()))
            return false;

        return true;
    }
}

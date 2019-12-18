package br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.validacao;

import br.com.beblue.bluerecords.entrypoint.util.DataUtil;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.dto.ConsultarVendaDTO;

public class ValidaConsultaVenda {
    public static boolean valida(ConsultarVendaDTO consultarVendaDTO) {
        if (!DataUtil.validarStringParaData(consultarVendaDTO.getDataInicial()))
            return false;

        return DataUtil.validarStringParaData(consultarVendaDTO.getDataFinal());
    }
}

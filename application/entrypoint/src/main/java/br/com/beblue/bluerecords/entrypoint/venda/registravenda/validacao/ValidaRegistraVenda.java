package br.com.beblue.bluerecords.entrypoint.venda.registravenda.validacao;

import br.com.beblue.bluerecords.entrypoint.util.DataUtil;
import br.com.beblue.bluerecords.entrypoint.venda.registravenda.dto.RegistrarVendaRequestDTO;

public class ValidaRegistraVenda {
    private ValidaRegistraVenda(){}

    public static boolean valida(RegistrarVendaRequestDTO registrarVendaRequestDTO) {
        return DataUtil.validarStringParaData(registrarVendaRequestDTO.getDate());
    }
}

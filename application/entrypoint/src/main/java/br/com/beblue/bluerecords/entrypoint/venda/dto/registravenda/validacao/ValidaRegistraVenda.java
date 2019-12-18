package br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.validacao;

import br.com.beblue.bluerecords.entrypoint.util.DataUtil;
import br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.dto.RegistrarVendaRequestDTO;

public class ValidaRegistraVenda {
    public static boolean valida(RegistrarVendaRequestDTO registrarVendaRequestDTO) {
        return DataUtil.validarStringParaData(registrarVendaRequestDTO.getDate());
    }
}

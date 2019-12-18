package br.com.beblue.bluerecords.entrypoint.venda.registravenda.mapper;

import br.com.beblue.bluerecords.core.command.RegistraVendaCommand;
import br.com.beblue.bluerecords.core.command.RegistrarVendaItensCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.entrypoint.util.DataUtil;
import br.com.beblue.bluerecords.entrypoint.util.DoubleUtil;
import br.com.beblue.bluerecords.entrypoint.venda.registravenda.dto.RegistrarVendaRequestDTO;
import br.com.beblue.bluerecords.entrypoint.venda.registravenda.dto.RegistrarVendaResponseDTO;
import com.google.common.util.concurrent.AtomicDouble;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistrarVendaMapper {

    private RegistrarVendaMapper(){}

    public static RegistraVendaCommand toCommand(RegistrarVendaRequestDTO registrarVendaRequestDTO) {
        List<RegistrarVendaItensCommand> itens = new ArrayList<>();

        registrarVendaRequestDTO.getRegistrarVendaItemRequestDTO().forEach(it ->
                itens.add(new RegistrarVendaItensCommand(it.getIdDisco(), it.getQuantidade())));

        LocalDate data = DataUtil.converteParaLocalDate(registrarVendaRequestDTO.getDate());

        return new RegistraVendaCommand(
                data,
                registrarVendaRequestDTO.getIdCliente(),
                itens);
    }

    public static RegistrarVendaResponseDTO toResponseDTO(Venda venda) {
        final AtomicDouble totalCashBack = new AtomicDouble(0);
        venda.getVendaItens().forEach(it -> totalCashBack.addAndGet(it.getCashBack()));
        return new RegistrarVendaResponseDTO(
                venda.getId(),
                "Sucesso",
                DoubleUtil.parseDouble(totalCashBack.get())
        );
    }
}

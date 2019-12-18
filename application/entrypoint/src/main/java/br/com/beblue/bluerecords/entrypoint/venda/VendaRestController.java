package br.com.beblue.bluerecords.entrypoint.venda;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.usecase.VendaUseCase;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.*;
import br.com.beblue.bluerecords.entrypoint.venda.mapper.ConsultaVendaMapper;
import br.com.beblue.bluerecords.entrypoint.venda.mapper.RegistrarVendaMapper;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(
        value = "REST API para pesquisar e realizar vendas",
        tags = {"ConsultaVendas"}
)
public class VendaRestController {
    public VendaRestController(VendaUseCase vendaUseCase) {
        this.vendaUseCase = vendaUseCase;
    }

    private VendaUseCase vendaUseCase;

    @PostMapping("/venda")
    public RegistrarVendaResponseDTO registrarVenda(@RequestBody  RegistrarVendaRequestDTO request) {
        RegistrarVendaResponseDTO response = verifyAndExecute(request);
        return response;
    }

    private RegistrarVendaResponseDTO verifyAndExecute(RegistrarVendaRequestDTO request) {
        RegistrarVendaMapper registrarVendaMapper = new RegistrarVendaMapper();
        return registrarVendaMapper.toResponseDTO(vendaUseCase.registrarVenda(registrarVendaMapper.toCommand(request)));
    }

    @GetMapping("venda/{id}")
    public ConsultarVendaResponseDTO consultarVenda(@PathVariable Integer id) {
        ConsultaVendaMapper consultaVendaMapper = new ConsultaVendaMapper();
        Venda venda = vendaUseCase.consultarVendaPorId(id);
        ConsultarVendaResponseDTO vendaResponseDTO = consultaVendaMapper.vendaToResponseDTO(venda);
        return vendaResponseDTO;
    }

    @GetMapping("/vendas")
    public PaginacaoDTO<ConsultarVendaResponseDTO> consultarVendas(ConsultarVendaDTO consultarVendaDTO) {
        ConsultaVendaMapper consultaVendaMapper = new ConsultaVendaMapper();
        ConsultaVendaCommand consultaVendaCommand = consultaVendaMapper.toCommand(consultarVendaDTO);
        Paginacao<Venda> vendas = vendaUseCase.consultarVendas(consultaVendaCommand);
        PaginacaoDTO<ConsultarVendaResponseDTO> response = consultaVendaMapper.toDTO(vendas);
        return response;
    }


}

package br.com.beblue.bluerecords.entrypoint.venda;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.usecase.VendaUseCase;
import br.com.beblue.bluerecords.core.usecase.facade.VendaComCashBackUseCash;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.dto.ConsultarVendaDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.dto.ConsultarVendaResponseDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.validacao.ValidaConsultaVenda;
import br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.dto.RegistrarVendaRequestDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.dto.RegistrarVendaResponseDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.mapper.ConsultaVendaMapper;
import br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.mapper.RegistrarVendaMapper;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(
        value = "REST API para pesquisar e realizar vendas",
        tags = {"ConsultaVendas"}
)
public class VendaRestController {
    public VendaRestController(VendaUseCase vendaUseCase, VendaComCashBackUseCash vendaCaseBackUseCase) {
        this.vendaUseCase = vendaUseCase;
        this.vendaCaseBackUseCase = vendaCaseBackUseCase;
    }

    private VendaComCashBackUseCash vendaCaseBackUseCase;
    private VendaUseCase vendaUseCase;

    @PostMapping("/venda")
    public RegistrarVendaResponseDTO registrarVenda(@RequestBody RegistrarVendaRequestDTO request) {
        RegistrarVendaResponseDTO response = verifyAndExecute(request);
        return response;
    }

    private RegistrarVendaResponseDTO verifyAndExecute(RegistrarVendaRequestDTO request) {
        RegistrarVendaMapper registrarVendaMapper = new RegistrarVendaMapper();
        return registrarVendaMapper.toResponseDTO(vendaCaseBackUseCase.registrarVenda(registrarVendaMapper.toCommand(request)));
    }

    @GetMapping("venda/{id}")
    public ResponseEntity<ConsultarVendaResponseDTO> consultarVenda(@PathVariable Integer id) {
        ConsultaVendaMapper consultaVendaMapper = new ConsultaVendaMapper();
        Venda venda = vendaUseCase.consultarVendaPorId(id);
        return consultaVendaMapper.vendaToResponseDTO(venda);
    }

    @GetMapping("/venda")
    public ResponseEntity<PaginacaoDTO<ConsultarVendaResponseDTO>> consultarVendas(ConsultarVendaDTO consultarVendaDTO) {
        if (!ValidaConsultaVenda.valida(consultarVendaDTO))
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(new PaginacaoDTO<>("Dados de Entrada não são válidos."));

        ConsultaVendaMapper consultaVendaMapper = new ConsultaVendaMapper();
        ConsultaVendaCommand consultaVendaCommand = consultaVendaMapper.toCommand(consultarVendaDTO);
        Paginacao<Venda> vendas = vendaUseCase.consultarVendas(consultaVendaCommand);
        return consultaVendaMapper.toDTO(vendas);
    }


}

package br.com.beblue.bluerecords.entrypoint.venda;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.usecase.VendaUseCase;
import br.com.beblue.bluerecords.core.usecase.facade.VendaComCashBackUseCash;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.venda.consultavenda.dto.ConsultarVendaDTO;
import br.com.beblue.bluerecords.entrypoint.venda.consultavenda.dto.ConsultarVendaResponseDTO;
import br.com.beblue.bluerecords.entrypoint.venda.consultavenda.validacao.ValidaConsultaVenda;
import br.com.beblue.bluerecords.entrypoint.venda.registravenda.dto.RegistrarVendaRequestDTO;
import br.com.beblue.bluerecords.entrypoint.venda.registravenda.dto.RegistrarVendaResponseDTO;
import br.com.beblue.bluerecords.entrypoint.venda.consultavenda.mapper.ConsultaVendaMapper;
import br.com.beblue.bluerecords.entrypoint.venda.registravenda.mapper.RegistrarVendaMapper;
import br.com.beblue.bluerecords.entrypoint.venda.registravenda.validacao.ValidaRegistraVenda;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(
        value = "REST API para pesquisar e realizar vendas",
        tags = {"API de consulta e venda de discos."}
)
public class VendaRestController {
    public VendaRestController(VendaUseCase vendaUseCase, VendaComCashBackUseCash vendaCaseBackUseCase) {
        this.vendaUseCase = vendaUseCase;
        this.vendaCaseBackUseCase = vendaCaseBackUseCase;
    }

    private VendaComCashBackUseCash vendaCaseBackUseCase;
    private VendaUseCase vendaUseCase;

    @PostMapping("/venda")
    public ResponseEntity<RegistrarVendaResponseDTO> registrarVenda(@RequestBody RegistrarVendaRequestDTO request) {
        if (!ValidaRegistraVenda.valida(request))
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(new RegistrarVendaResponseDTO("Dados de Entrada não são válidos."));
        return RegistrarVendaMapper.toResponseDTO(vendaCaseBackUseCase.registrarVenda(RegistrarVendaMapper.toCommand(request)));
    }

    @GetMapping("venda/{id}")
    public ResponseEntity<ConsultarVendaResponseDTO> consultarVenda(@PathVariable Integer id) {
        Venda venda = vendaUseCase.consultarVendaPorId(id);
        return ConsultaVendaMapper.vendaToResponseDTO(venda);
    }

    @GetMapping("/venda")
    public ResponseEntity<PaginacaoDTO<ConsultarVendaResponseDTO>> consultarVendas(ConsultarVendaDTO consultarVendaDTO) {
        if (!ValidaConsultaVenda.valida(consultarVendaDTO))
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(new PaginacaoDTO<>("Dados de Entrada não são válidos."));

        ConsultaVendaCommand consultaVendaCommand = ConsultaVendaMapper.toCommand(consultarVendaDTO);
        Paginacao<Venda> vendas = vendaUseCase.consultarVendas(consultaVendaCommand);
        return ConsultaVendaMapper.toDTO(vendas);
    }


}

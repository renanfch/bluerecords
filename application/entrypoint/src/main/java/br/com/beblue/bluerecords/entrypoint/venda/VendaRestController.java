package br.com.beblue.bluerecords.entrypoint.venda;

import br.com.beblue.bluerecords.core.command.ConsultaVendaCommand;
import br.com.beblue.bluerecords.core.entitidade.Venda;
import br.com.beblue.bluerecords.core.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.usecase.VendaUseCase;
import br.com.beblue.bluerecords.entrypoint.paginacao.PaginacaoDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.ConsultarVendaDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.ConsultarVendaResponseDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.consultavenda.validacao.ValidaConsultaVenda;
import br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.RegistrarVendaRequestDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.registravenda.RegistrarVendaResponseDTO;
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
    public VendaRestController(VendaUseCase vendaUseCase) {
        this.vendaUseCase = vendaUseCase;
    }

    private VendaUseCase vendaUseCase;

    @PostMapping("/venda")
    public RegistrarVendaResponseDTO registrarVenda(@RequestBody RegistrarVendaRequestDTO request) {
        RegistrarVendaResponseDTO response = verifyAndExecute(request);
        return response;
    }

    private RegistrarVendaResponseDTO verifyAndExecute(RegistrarVendaRequestDTO request) {
        RegistrarVendaMapper registrarVendaMapper = new RegistrarVendaMapper();
        return registrarVendaMapper.toResponseDTO(vendaUseCase.registrarVenda(registrarVendaMapper.toCommand(request)));
    }

    @GetMapping("venda/{id}")
    public ResponseEntity<ConsultarVendaResponseDTO> consultarVenda(@PathVariable Integer id) {
        ConsultaVendaMapper consultaVendaMapper = new ConsultaVendaMapper();
        Venda venda = vendaUseCase.consultarVendaPorId(id);
        return consultaVendaMapper.vendaToResponseDTO(venda);
    }

    @GetMapping("/vendas")
    public ResponseEntity<PaginacaoDTO<ConsultarVendaResponseDTO>> consultarVendas(ConsultarVendaDTO consultarVendaDTO) {
        if (!ValidaConsultaVenda.valida(consultarVendaDTO))
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(new PaginacaoDTO<>("Dados de Entrada não são válidos."));

        ConsultaVendaMapper consultaVendaMapper = new ConsultaVendaMapper();
        ConsultaVendaCommand consultaVendaCommand = consultaVendaMapper.toCommand(consultarVendaDTO);
        Paginacao<Venda> vendas = vendaUseCase.consultarVendas(consultaVendaCommand);
        return  consultaVendaMapper.toDTO(vendas);
    }


}

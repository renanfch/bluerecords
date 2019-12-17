package br.com.beblue.bluerecords.entrypoint.venda;

import br.com.beblue.bluerecords.core.usecase.VendaUseCase;
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaRequestDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.RegistrarVendaResponseDTO;
import br.com.beblue.bluerecords.entrypoint.venda.dto.VendaResponseDTO;
import br.com.beblue.bluerecords.entrypoint.venda.mapper.RegistrarVendaMapper;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(
        description = "REST API para pesquisar e realizar vendas",
        tags = {"ConsultaVendas"}
)
public class VendaRestController {
    public VendaRestController(VendaUseCase vendaUseCase) {
        this.vendaUseCase = vendaUseCase;
    }

    private VendaUseCase vendaUseCase;

    @PostMapping
    public RegistrarVendaResponseDTO registrarVenda(RegistrarVendaRequestDTO request) {
        RegistrarVendaResponseDTO response = verifyAndExecute(request);
        return response;
    }

    private RegistrarVendaResponseDTO verifyAndExecute(RegistrarVendaRequestDTO request) {
        RegistrarVendaMapper registrarVendaMapper = new RegistrarVendaMapper();
        return registrarVendaMapper.toResponseDTO(vendaUseCase.registrarVenda(registrarVendaMapper.toCommand(request)));
    }

    @GetMapping
    public VendaResponseDTO buscarVenda() {
        return null;
    }

}

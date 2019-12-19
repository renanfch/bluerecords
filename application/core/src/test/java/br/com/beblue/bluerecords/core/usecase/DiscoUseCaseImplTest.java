package br.com.beblue.bluerecords.core.usecase;

import br.com.beblue.bluerecords.core.command.*;
import br.com.beblue.bluerecords.core.entitidade.Disco;
import br.com.beblue.bluerecords.core.entitidade.paginacao.Paginacao;
import br.com.beblue.bluerecords.core.repositorio.DiscoRepositorio;
import br.com.beblue.bluerecords.core.repositorio.DiscoSpotifyClient;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscoUseCaseImplTest {

    String nomeDisco = "DiscoUm";
    CadastraDiscoCommand cadastraDiscoCommand = new CadastraDiscoCommand(nomeDisco, 1, 10.0);
    PaginacaoCommand paginacaoCommand = new PaginacaoCommand(1, 50);
    ConsultaDiscoCommand consultaDiscoCommand = new ConsultaDiscoCommand(paginacaoCommand, 1);
    List<Disco> discos = new ArrayList<>();
    Paginacao<Disco> paginacaoDiscos = new Paginacao<>(50, 200, 1, discos);
    Disco disco = new Disco(1, 1, nomeDisco, 10.0);

    DiscoRepositorio discoRepositorio = Mockito.mock(DiscoRepositorio.class);
    DiscoSpotifyClient discoSpotifyClient = Mockito.mock(DiscoSpotifyClient.class);

    public DiscoUseCaseImplTest() {
        discos.add(disco);
    }

    @Test
    public void deveRetornarODiscoUm() {
        DiscoUseCase discoUseCase = new DiscoUseCaseImpl(discoRepositorio, discoSpotifyClient);
        Mockito.when(discoRepositorio.consultar(1)).thenReturn(disco);
        Disco discoAtual = discoUseCase.consultar(1);
        assertEquals("DiscoUm", discoAtual.getNome());
    }

    @Test
    public void deveRetornarOGeneroUm() {
        Mockito.when(discoRepositorio.consultar(1)).thenReturn(disco);
        DiscoUseCase discoUseCase = new DiscoUseCaseImpl(discoRepositorio, discoSpotifyClient);
        Disco discoAtual = discoUseCase.consultar(1);
        assertEquals(Integer.valueOf(1), discoAtual.getIdGenero());
    }

    @Test
    public void deveRetornarOValorDez() {
        Mockito.when(discoRepositorio.consultar(1)).thenReturn(disco);
        DiscoUseCase discoUseCase = new DiscoUseCaseImpl(discoRepositorio, discoSpotifyClient);
        Disco discoAtual = discoUseCase.consultar(1);
        assertEquals(Double.valueOf(10.0), discoAtual.getValor());
    }

    @Test
    public void deveRetornarQueDiscosExistem() {
        Mockito.when(discoRepositorio.existeDiscoCadastrado()).thenReturn(true);
        DiscoUseCase discoUseCase = new DiscoUseCaseImpl(discoRepositorio, discoSpotifyClient);
        Boolean existeDiscoCadastrado = discoUseCase.discosForamCadastrados();
        assertEquals(true, existeDiscoCadastrado);
    }

    @Test
    public void deveRetornarQueDiscosNaoExistem() {
        Mockito.when(discoRepositorio.existeDiscoCadastrado()).thenReturn(false);
        DiscoUseCase discoUseCase = new DiscoUseCaseImpl(discoRepositorio, discoSpotifyClient);
        Boolean existeDiscoCadastrado = discoUseCase.discosForamCadastrados();
        assertEquals(false, existeDiscoCadastrado);
    }

    @Test
    public void deveRetornarUmTotalDeDuzentosItens() {
        Mockito.when(discoRepositorio.consultarDiscos(consultaDiscoCommand)).thenReturn(paginacaoDiscos);
        DiscoUseCase discoUseCase = new DiscoUseCaseImpl(discoRepositorio, discoSpotifyClient);
        Paginacao<Disco> paginacao = discoUseCase.consultarDiscos(consultaDiscoCommand);
        assertEquals(Integer.valueOf(200), paginacao.getTotal());
    }

    @Test
    public void deveRetornarUmaPaginaCom50Itens() {
        Mockito.when(discoRepositorio.consultarDiscos(consultaDiscoCommand)).thenReturn(paginacaoDiscos);
        DiscoUseCase discoUseCase = new DiscoUseCaseImpl(discoRepositorio, discoSpotifyClient);
        Paginacao<Disco> paginacao = discoUseCase.consultarDiscos(consultaDiscoCommand);
        assertEquals(Integer.valueOf(50), paginacao.getTamanho());
    }

    @Test
    public void deveCadastrarUmDiscoRetornarIdUm() {
        Mockito.when(discoRepositorio.cadastrar(cadastraDiscoCommand)).thenReturn(disco);
        DiscoUseCase discoUseCase = new DiscoUseCaseImpl(discoRepositorio, discoSpotifyClient);
        Disco discoAtual = discoUseCase.cadastrar(cadastraDiscoCommand);
        assertEquals(Integer.valueOf(1), discoAtual.getId());
    }


}
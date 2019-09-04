package com.financssapi.controller;

import com.financssapi.model.Conta;
import com.financssapi.model.DataPesquisa;
import com.financssapi.model.TransacaoRendimento;
import com.financssapi.repository.ContaRepository;
import com.financssapi.repository.TransacaoRendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@RequestMapping("/api/transacao_rendimento")
public class TransacaoRendimentoController extends WebMvcConfigurerAdapter implements ModeloCrud<TransacaoRendimento> {

    private static final String SLASH = "/";
    private static final String PATH_LISTAR = "listar";
    private static final String PATH_CADASTRAR = "cadastrar";
    private static final String PATH_EDITAR = "editar";
    private static final String PATH_REMOVER = "remover";
    private static final String PATH_PAGINAR = "paginar";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("PUT", "DELETE", "GET", "POST");
    }

    @Autowired
    private TransacaoRendimentoRepository trr;

    @Autowired
    private ContaRepository cr;

    @Override
    @GetMapping(SLASH + PATH_LISTAR)
    public List<TransacaoRendimento> listar() {

        return trr.findAll();
    }

    @Override
    @PostMapping(SLASH + PATH_CADASTRAR)
    public TransacaoRendimento cadastrar(@RequestBody TransacaoRendimento transacaoRendimento) {

        //Recuperando a conta
        Conta conta = cr.findById(transacaoRendimento.getConta().getId());

        //Novo valor da conta
        float novo_valor = conta.getValor() + transacaoRendimento.getValor();

        conta.setValor(novo_valor);

        cr.save(conta);

        return trr.save(transacaoRendimento);
    }

    @Override
    @PutMapping(SLASH + PATH_EDITAR)
    public TransacaoRendimento editar(@RequestBody TransacaoRendimento transacaoRendimento) {
        return trr.save(transacaoRendimento);
    }

    @Override
    @DeleteMapping(SLASH + PATH_REMOVER)
    public void remover(Long id) {
        trr.delete(trr.findById(id));
    }

    @Override
    @GetMapping(SLASH + PATH_PAGINAR)
    public Page<TransacaoRendimento> paginar(Pageable pageable) {

        return trr.findAll(pageable);
    }

    @PostMapping(SLASH + PATH_LISTAR + SLASH + "mes")
    public List<TransacaoRendimento> listarTransacoesData(@RequestBody DataPesquisa dataPesquisa) {

        return trr.findAllByDtLancamentoBetween(dataPesquisa.getDataInicio(), dataPesquisa.getDataFim());
        //return trr.findAllByDtLancamento(dataPesquisa.getDataInicio());
    }
}

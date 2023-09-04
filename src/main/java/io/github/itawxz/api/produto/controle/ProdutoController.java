package io.github.itawxz.api.produto.controle;

import io.github.itawxz.api.produto.modelo.ProdutoModelo;
import io.github.itawxz.api.produto.modelo.RespostaModelo;
import io.github.itawxz.api.produto.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    // Açoes
    @Autowired
    private ProdutoRepositorio acoes;


    // Listar Produtos
    @RequestMapping(value="/produtos", method= RequestMethod.GET)
    public @ResponseBody List<ProdutoModelo> listar() {
        return acoes.findAll();
    }

    //Cadastrar Produtos
    @RequestMapping(value="/produtos", method=RequestMethod.POST)
    public @ResponseBody ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
        return acoes.save(produto);
    }
    //Filtrar Produtos

    @RequestMapping(value="/produtos/{codigo}", method=RequestMethod.GET)
    public @ResponseBody ProdutoModelo filtrar(@PathVariable Integer codigo) {
        return acoes.findByCodigo(codigo);
    }

    //Alterar produtos
    @RequestMapping(value="/produtos", method=RequestMethod.PUT)
    public @ResponseBody ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
        return acoes.save(produto);
    }

    //Remover produtos
    @RequestMapping(value="/produtos/{codigo}", method=RequestMethod.DELETE)
    public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {
        RespostaModelo resposta = new RespostaModelo();
        try {
            ProdutoModelo produto = filtrar(codigo);
            this.acoes.delete(produto);
            resposta.setMensagem("Produto removido com sucesso!");
        } catch(Exception erro) {
            resposta.setMensagem("Falha ao remover: "+ erro.getMessage());
        }
        return resposta;
    }
}

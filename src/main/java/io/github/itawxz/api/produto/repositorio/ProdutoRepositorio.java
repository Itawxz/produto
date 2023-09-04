package io.github.itawxz.api.produto.repositorio;

import io.github.itawxz.api.produto.modelo.ProdutoModelo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer> {
    // Listar todos os produtos
    List<ProdutoModelo> findAll();
    // Pesquisar por codigo
    ProdutoModelo findByCodigo(int codigo);
    // Remover produto
    void delete(ProdutoModelo produto);
    // Cadastar/Alterar produto
    //ProdutoModelo save(ProdutoModelo produto);
    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod produto);

}
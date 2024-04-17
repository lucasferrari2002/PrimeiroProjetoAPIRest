package com.aulaudemy.primeiroexemplo.repository;

import com.aulaudemy.primeiroexemplo.execption.ProdutoExecption;
import com.aulaudemy.primeiroexemplo.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryProduto {
    private List<Produto> produtos = new ArrayList<>();
    private Integer ultimoID = 0;

    public List<Produto> obterTodos(){
        return produtos;
    }
    public Optional<Produto> obterPorId(Integer id){
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }
    public Produto adicionar(Produto produto){
        ultimoID++;
        produto.setId(ultimoID);
        produtos.add(produto);

        return produto;
    }

    public void deletar (Integer id){
        produtos.removeIf(produto -> produto.getId() == id);

    }
    public Produto atualizar(Produto produto){
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if( produtoEncontrado.isEmpty()){
            throw new ProdutoExecption("Produto não encontrado");

        }
        deletar(produto.getId());

        produtos.add(produto);

        return produto;
    }
}

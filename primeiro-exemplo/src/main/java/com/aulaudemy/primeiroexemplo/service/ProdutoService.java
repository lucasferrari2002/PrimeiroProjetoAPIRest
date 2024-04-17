package com.aulaudemy.primeiroexemplo.service;

import com.aulaudemy.primeiroexemplo.execption.ProdutoExecption;
import com.aulaudemy.primeiroexemplo.model.Produto;
import com.aulaudemy.primeiroexemplo.repository.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private RepositoryProduto repositoryProduto;

    public List<Produto> obterTodos(){
        return repositoryProduto.obterTodos();
    }
    public Optional<Produto> obterPorId(Integer id){
        if(repositoryProduto.obterPorId(id).isEmpty()){
            throw new ProdutoExecption("Id não encontrado: Verifique!");
        }
       return repositoryProduto.obterPorId(id);
    }
    public Produto adicionar(Produto produto){
        return repositoryProduto.adicionar(produto);
    }
    public void deletar (Integer id){
        repositoryProduto.deletar(id);

    }
    public Produto atualizar(Integer id, Produto produto){
       produto.setId(id);
       return repositoryProduto.atualizar(produto);
    }

}

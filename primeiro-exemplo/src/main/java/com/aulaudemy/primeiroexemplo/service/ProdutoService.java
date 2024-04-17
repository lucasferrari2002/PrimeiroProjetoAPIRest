package com.aulaudemy.primeiroexemplo.service;

import com.aulaudemy.primeiroexemplo.execption.ProdutoExecption;
import com.aulaudemy.primeiroexemplo.model.Produto;
import com.aulaudemy.primeiroexemplo.repository.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private RepositoryProduto repositoryProduto;

    public List<Produto> obterTodos(){
        return repositoryProduto.findAll();
    }
    public Optional<Produto> obterPorId(Integer id){
        if(repositoryProduto.findById(id).isEmpty()){
            throw new ProdutoExecption("Id não encontrado: Verifique!");
        }
       return repositoryProduto.findById(id);
    }
    public Produto adicionar(Produto produto){
        return repositoryProduto.save(produto);
    }
    public void deletar (Integer id){
        repositoryProduto.deleteById(id);

    }
    public Produto atualizar(Integer id, Produto produto){
       produto.setId(id);
       return repositoryProduto.save(produto);
    }

}

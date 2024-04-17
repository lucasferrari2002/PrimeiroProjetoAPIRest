package com.aulaudemy.primeiroexemplo.repository;

import com.aulaudemy.primeiroexemplo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProduto extends JpaRepository<Produto, Integer> {
}

package UEPG2024Web.JG.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import UEPG2024Web.JG.demo.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
    Produto findByID(int id);
    Produto findByCodigo(char codigo[]);
    List<Produto> findByValorCusto(float valorCusto);
    List<Produto> findByValorVenda(float valorVenda);

}

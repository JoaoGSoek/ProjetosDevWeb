package UEPG2024Web.JG.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import UEPG2024Web.JG.demo.model.Produto;
import UEPG2024Web.JG.demo.model.ProdutoPedido;

public interface ProdutoPedidoRepository extends JpaRepository<ProdutoPedido, Integer>{
    
    ProdutoPedido deleteByID(int idPedido, int idProduto);
    ProdutoPedido findByID(int idPedido, int idProduto);
    List<Produto> findByPrecoUnitario(float precoUnitario);

}

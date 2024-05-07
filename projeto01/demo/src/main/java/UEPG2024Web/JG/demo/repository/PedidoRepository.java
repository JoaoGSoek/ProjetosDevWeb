package UEPG2024Web.JG.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import UEPG2024Web.JG.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
    Pedido findByID(int id);
    List<Pedido> findByIDFuncionario(int id);
    List<Pedido> findByIDCliente(int id);
    List<Pedido> findByDataPedido(Date date);
    List<Pedido> findByDataRemessa(Date date);

}

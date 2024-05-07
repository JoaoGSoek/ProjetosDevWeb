package UEPG2024Web.JG.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;

    @Column
    private int idFuncionario;

    @Column
    private int idCliente;

    @Column
    private Date dataPedido;

    @Column
    private Date dataRemessa;

    public Pedido(int idFuncionario, int idCliente, Date dataPedido, Date dataRemessa){

        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.dataPedido = dataPedido;
        this.dataRemessa = dataRemessa;

    }

    // Gets e Sets

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataRemessa() {
        return dataRemessa;
    }

    public void setDataRemessa(Date dataRemessa) {
        this.dataRemessa = dataRemessa;
    }

    

}

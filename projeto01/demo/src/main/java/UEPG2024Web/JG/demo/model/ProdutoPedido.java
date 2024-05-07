package UEPG2024Web.JG.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class ProdutoPedido {
    
    @Id
    private final int idPedido;

    @Id
    private final int idProduto;

    @Column
    private int quantidade;

    @Column
    private float precoUnitario;

    @Column
    private float desconto;

    public ProdutoPedido(int idPedido, int idProduto, int quantidade, float precoUnitario, float desconto){

        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.desconto = desconto;

    }

    // Gets e Sets

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }


    
}

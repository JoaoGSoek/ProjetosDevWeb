package UEPG2024Web.JG.demo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido_produto")
public class ProdutoPedido {
    
    
    @OneToMany
    @Id
    private final List<Pedido> pedidos;

    @OneToMany
    @Id
    private final List<Produto> produtos;

    @Column
    private int quantidade;

    @Column
    private float precoUnitario;

    @Column
    private float desconto;

    public ProdutoPedido(List<Pedido> pedidos, List<Produto> produtos, int quantidade, float precoUnitario, float desconto){

        this.pedidos = pedidos;
        this.produtos = produtos;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.desconto = desconto;

    }

    // Gets e Sets

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public List<Produto> getProdutos() {
        return produtos;
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

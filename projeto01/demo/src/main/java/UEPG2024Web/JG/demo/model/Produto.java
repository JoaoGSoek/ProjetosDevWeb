package UEPG2024Web.JG.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduto;

    @Column
    private char codigo[] = new char[20];

    @Column
    private String descricao;

    @Column
    private float valor_custo;

    @Column
    private float valor_venda;

    public Produto(char codigo[], String descricao, float valor_custo, float valor_venda){

        this.codigo = codigo;
        this.descricao = descricao;
        this.valor_custo = valor_custo;
        this.valor_venda = valor_venda;

    }

    // Gets e Sets

    public int getId(){
        return this.idProduto;
    }

    public char[] getCodigo(){
        return this.codigo;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public float getValorCusto(){
        return this.valor_custo;
    }

    public float getValorVenda(){
        return this.valor_venda;
    }
    
    public void setCodigo(char codigo[]){
        this.codigo = codigo;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setValorCusto(float valor_custo){
        this.valor_custo = valor_custo;
    }
    
    public void setValorVenda(float valor_venda){
        this.valor_venda = valor_venda;
    }
    
}

package UEPG2024Web.JG.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import UEPG2024Web.JG.demo.model.Produto;
import UEPG2024Web.JG.demo.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController {
 
    @Autowired
    ProdutoRepository rep;
    
    // Gets

    /*
     * GET /api/Produtos : listar todos os Produtos
     */
    @GetMapping("/produtos")
    public  ResponseEntity<List<Produto>> getAllProdutos(){
        try
        {
            List<Produto> la = new ArrayList<>();
            rep.findAll().forEach(la::add);

            if (la.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<>(la, HttpStatus.OK);
        }
         catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
     * GET /api/produtos/:code : listar Produto dado um código
     */
    @GetMapping("/produtos/codigo/{code}")
    public ResponseEntity<Produto> getProdutoByCodigo(@PathVariable("code") char codigo[]){

        Produto data = rep.findByCodigo(codigo);
        return (data != null) ? new ResponseEntity<>(data, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);     

    }

    /*
     * GET /api/Produtos/:id : listar Produto dado um id
     */
    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") int id){

        Optional<Produto> data = rep.findById(id);
        return (data.isPresent()) ? new ResponseEntity<>(data.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);     

    }

    // Posts

    /*
     * POST /api/Produtos : criar Produto
     */
    @PostMapping("/produtos")
    public ResponseEntity<Produto> createProduto(@RequestBody Produto ar){

        try {
            Produto _a = rep.save(new Produto(ar.getCodigo(), ar.getDescricao(), ar.getValorCusto(), ar.getValorVenda()));
            return new ResponseEntity<>(_a, HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Puts

    /*
     * PUT /api/Produtos/:id : atualizar Produto dado um id
     */
    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("id") int id, @RequestBody Produto a)
    {
        Optional<Produto> data = rep.findById(id);

        if (data.isPresent()){

            Produto ar = data.get();
            ar.setCodigo(a.getCodigo());
            ar.setDescricao(a.getDescricao());
            ar.setValorCusto(a.getValorCusto());
            ar.setValorVenda(a.getValorVenda());
            return new ResponseEntity<>(rep.save(ar), HttpStatus.OK);

        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Dels

    /*
     * DEL /api/Produtos/:id : remover Produto dado um id
     */
    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<HttpStatus> deleteProduto(@PathVariable("id") int id)
    {
        try {
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    /*
     * DEL /api/Produtos : remover todos os Produtos
     */
    @DeleteMapping("/produtos")
    public ResponseEntity<HttpStatus> deleteAllProduto(){
        
        try {

            rep.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}

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

import UEPG2024Web.JG.demo.model.ProdutoPedido;
import UEPG2024Web.JG.demo.repository.ProdutoPedidoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoPedidoController {
 
    @Autowired
    ProdutoPedidoRepository rep;
    
    // Gets

    /*
     * GET /api/ProdutoPedidos : listar todos os ProdutoPedidos
     */
    @GetMapping("/produtopedidos")
    public  ResponseEntity<List<ProdutoPedido>> getAllProdutoPedidos(){
        try
        {
            List<ProdutoPedido> la = new ArrayList<>();
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
     * GET /api/ProdutoPedidos/:idPedido/:idProduto : listar ProdutoPedido dado um id
     */
    @GetMapping("/produtopedidos/{idPedido}/{idProduto}")
    public ResponseEntity<ProdutoPedido> getProdutoPedidoById(@PathVariable("idPedido") int idPedido, @PathVariable("idProduto") int idProduto){

        ProdutoPedido data = rep.findByID(idPedido, idProduto);
        return (data != null) ? new ResponseEntity<>(data, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Posts

    /*
     * POST /api/ProdutoPedidos : criar ProdutoPedido
     */
    @PostMapping("/produtopedidos")
    public ResponseEntity<ProdutoPedido> createProdutoPedido(@RequestBody ProdutoPedido ar){

        try {
            ProdutoPedido _a = rep.save(new ProdutoPedido(ar.getIdPedido(), ar.getIdProduto(), ar.getQuantidade(), ar.getPrecoUnitario(), ar.getDesconto()));
            return new ResponseEntity<>(_a, HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Puts

    /*
     * PUT /api/ProdutoPedidos/:id : atualizar ProdutoPedido dado um id
     */
    @PutMapping("/produtopedidos/{id}")
    public ResponseEntity<ProdutoPedido> updateProdutoPedido(@PathVariable("id") int id, @RequestBody ProdutoPedido a)
    {
        Optional<ProdutoPedido> data = rep.findById(id);

        if (data.isPresent()){

            ProdutoPedido ar = data.get();
            ar.setQuantidade(a.getQuantidade());
            ar.setPrecoUnitario(a.getPrecoUnitario());
            ar.setDesconto(a.getDesconto());
            return new ResponseEntity<>(rep.save(ar), HttpStatus.OK);

        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Dels

    /*
     * DEL /api/ProdutoPedidos/:id : remover ProdutoPedido dado um id
     */
    @DeleteMapping("/produtopedidos/{idPedido}/{idProduto}")
    public ResponseEntity<HttpStatus> deleteProdutoPedido(@PathVariable("idPedido") int idPedido, @PathVariable("idProduto") int idProduto)
    {
        try {
            rep.deleteByID(idPedido, idProduto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    /*
     * DEL /api/ProdutoPedidos : remover todos os ProdutoPedidos
     */
    @DeleteMapping("/produtopedidos")
    public ResponseEntity<HttpStatus> deleteAllProdutoPedido(){
        
        try {

            rep.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}

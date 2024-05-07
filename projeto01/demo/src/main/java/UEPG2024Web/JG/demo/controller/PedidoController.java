package UEPG2024Web.JG.demo.controller;

import java.util.ArrayList;
import java.util.Date;
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

import UEPG2024Web.JG.demo.model.Pedido;
import UEPG2024Web.JG.demo.repository.PedidoRepository;

@RestController
@RequestMapping("/api")
public class PedidoController {
 
    @Autowired
    PedidoRepository rep;
    
    // Gets

    /*
     * GET /api/pedidos : listar todos os Pedidos
     */
    @GetMapping("/pedidos")
    public  ResponseEntity<List<Pedido>> getAllPedidos(){
        try
        {
            List<Pedido> la = new ArrayList<>();
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
     * GET /api/pedidos : listar todos os Pedidos pela data da remessa
     */
    @GetMapping("/pedidos/data-remessa/{data}")
    public  ResponseEntity<List<Pedido>> getPedidosByDataRemessa(@PathVariable("data") Date dataRemessa){
        try
        {
            List<Pedido> la = new ArrayList<>();

            rep.findByDataRemessa(dataRemessa).forEach(la::add);

            if (la.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<>(la, HttpStatus.OK);
        }
         catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    /*
     * GET /api/pedidos : listar todos os Pedidos pela data do pedido
     */
    @GetMapping("/pedidos/data-pedido/{data}")
    public  ResponseEntity<List<Pedido>> getPedidosByDataPedido(@PathVariable("data") Date dataPedido){
        try
        {
            List<Pedido> la = new ArrayList<>();

            rep.findByDataPedido(dataPedido).forEach(la::add);

            if (la.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<>(la, HttpStatus.OK);
        }
         catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    /*
     * GET /api/pedidos : listar todos os Pedidos feitos por um cliente
     */
    @GetMapping("/pedidos/cliente/{id}")
    public  ResponseEntity<List<Pedido>> getPedidosByIDCliente(@PathVariable("id") int idCliente){
        try
        {
            List<Pedido> la = new ArrayList<>();

            rep.findByIDCliente(idCliente).forEach(la::add);

            if (la.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<>(la, HttpStatus.OK);
        }
         catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    /*
     * GET /api/pedidos : listar todos os Pedidos feitos por um funcionario
     */
    @GetMapping("/pedidos/funcionario/{id}")
    public  ResponseEntity<List<Pedido>> getPedidosByIDFuncionario(@PathVariable("id") int idFuncionario){
        try
        {
            List<Pedido> la = new ArrayList<>();

            rep.findByIDFuncionario(idFuncionario).forEach(la::add);

            if (la.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
            return new ResponseEntity<>(la, HttpStatus.OK);
        }
         catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /*
     * GET /api/Pedidos/:id : listar Pedido dado um id
     */
    @GetMapping("/Pedidos/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") int id){

        Optional<Pedido> data = rep.findById(id);
        return (data.isPresent()) ? new ResponseEntity<>(data.get(), HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);     

    }

    // Posts

    /*
     * POST /api/Pedidos : criar Pedido
     */
    @PostMapping("/Pedidos")
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido ar){

        try {
            Pedido _a = rep.save(new Pedido(ar.getIdFuncionario(), ar.getIdCliente(), ar.getDataPedido(), ar.getDataRemessa()));
            return new ResponseEntity<>(_a, HttpStatus.CREATED);            
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Puts

    /*
     * PUT /api/Pedidos/:id : atualizar Pedido dado um id
     */
    @PutMapping("/Pedidos/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable("id") int id, @RequestBody Pedido a)
    {
        Optional<Pedido> data = rep.findById(id);

        if (data.isPresent()){

            Pedido ar = data.get();
            ar.setIdFuncionario(a.getIdFuncionario());
            ar.setIdCliente(a.getIdCliente());
            ar.setDataPedido(a.getDataPedido());
            ar.setDataRemessa(a.getDataRemessa());
            return new ResponseEntity<>(rep.save(ar), HttpStatus.OK);

        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Dels

    /*
     * DEL /api/Pedidos/:id : remover Pedido dado um id
     */
    @DeleteMapping("/Pedidos/{id}")
    public ResponseEntity<HttpStatus> deletePedido(@PathVariable("id") int id)
    {
        try {
            rep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    /*
     * DEL /api/Pedidos : remover todos os Pedidos
     */
    @DeleteMapping("/Pedidos")
    public ResponseEntity<HttpStatus> deleteAllPedido(){
        
        try {

            rep.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

}

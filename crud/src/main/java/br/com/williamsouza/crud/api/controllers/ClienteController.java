package br.com.williamsouza.crud.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.williamsouza.crud.api.Cliente;
import br.com.williamsouza.crud.api.services.ClienteService;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(this.clienteService.listarTodos());

    }

    @GetMapping(path = "/id")
    public ResponseEntity<Cliente> listarPorId(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(this.clienteService.listarPorId(id));

    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(this.clienteService.cadastrar(cliente));

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable(name = "id") String id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return ResponseEntity.ok(this.clienteService.atualizar(cliente));

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Integer> remover(@PathVariable(name = "id") String id) {
        this.clienteService.remover(id);
        return ResponseEntity.ok(1);

    }

}

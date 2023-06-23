package br.com.williamsouza.crud.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.williamsouza.crud.api.Cliente;
import br.com.williamsouza.crud.api.responses.Response;
import br.com.williamsouza.crud.api.services.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Response<List<Cliente>>> listarTodos() {
        return ResponseEntity.ok(new Response<List<Cliente>>(this.clienteService.listarTodos()));

    }

    @GetMapping(path = "/id")
    public ResponseEntity<Response<Cliente>> listarPorId(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(new Response<>(this.clienteService.listarPorId(id)));

    }

    @PostMapping
    public ResponseEntity<Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Cliente>(erros));

        }
        return ResponseEntity.ok(new Response<Cliente>(this.clienteService.cadastrar(cliente)));

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response<Cliente>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody
             Cliente cliente, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = new ArrayList<String>();
            result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Cliente>(erros));

        }

        cliente.setId(id);
        return ResponseEntity.ok(new Response<Cliente>(this.clienteService.atualizar(cliente)));

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
        this.clienteService.remover(id);
        return ResponseEntity.ok(new Response<Integer>(1));

    }

}

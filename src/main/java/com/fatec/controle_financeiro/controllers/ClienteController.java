package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
//http://localhost:8090/api/clientes

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
 
    private List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;
 
    // POST - LANÇAR
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }
    // http://localhost:8090/api/clientes
    // GET - LISTAR
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clientes;
    }

    // 
    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable int id) {
        Optional<Cliente> cliente = clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        return cliente.orElse(null);
    }
    // http://localhost:8090/api/clientes/id
    // PUT - ALTERAR
    @PutMapping("/{id}")
    public Cliente updateCliente(@PathVariable int id, @RequestBody Cliente clienteAtualizado) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNome(clienteAtualizado.getNome());
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }
    // http://localhost:8090/api/clientes/id
    // DELETE - APGAR
    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
        return "Cliente com id " + id + " foi removido.";
    }
}
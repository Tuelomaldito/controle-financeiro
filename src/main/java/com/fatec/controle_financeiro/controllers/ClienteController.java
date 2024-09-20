package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
// http://localhost:8090/api/clientes
// caminho para abrir o codigo,tanto na Browser ou HOOPSCOTCH

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
 
    private List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;
 
    // POST - LANÇAR
    // Responsavel por criar o clinete no HOOPSCOTCH, pela estrutura do codigo ele cria o ID automatico somando eles
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }
    // http://localhost:8090/api/clientes
    // GET - LISTAR
    // Responsavel por listar o todos os cliente criados no POST
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clientes;
    }

    // http://localhost:8090/api/clientes/id
    // PUT - ALTERAR
    // Responsavel por alterar o nome do cliente com base no ID dele
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
    // Responsavel por apagar o cliente com base no ID dele 
    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
        return "Cliente com id " + id + " foi removido.";
    }
}
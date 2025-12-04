package br.com.loja.sistema_pedidos.service;

import br.com.loja.sistema_pedidos.model.Cliente;
import br.com.loja.sistema_pedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public Cliente salvar(Cliente cliente) {
        // Aqui você poderia verificar se o CPF já existe, por exemplo
        return repository.save(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
    
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
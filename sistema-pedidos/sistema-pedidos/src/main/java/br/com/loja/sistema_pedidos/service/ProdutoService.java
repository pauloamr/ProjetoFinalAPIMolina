package br.com.loja.sistema_pedidos.service;

import br.com.loja.sistema_pedidos.model.Produto;
import br.com.loja.sistema_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }
    
    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }
}
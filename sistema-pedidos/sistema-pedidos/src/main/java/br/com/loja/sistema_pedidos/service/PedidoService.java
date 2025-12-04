package br.com.loja.sistema_pedidos.service;

import br.com.loja.sistema_pedidos.model.ItemPedido;
import br.com.loja.sistema_pedidos.model.Pedido;
import br.com.loja.sistema_pedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public Pedido salvar(Pedido pedido) {
        double total = 0.0;
        
        // Se houver itens, calcula o total e vincula ao pedido
        if (pedido.getItens() != null) {
            for (ItemPedido item : pedido.getItens()) {
                item.setPedido(pedido); // Diz pro item: "Você é deste pedido"
                
                // Cálculo simples de segurança
                if (item.getPrecoUnitario() != null && item.getQuantidade() != null) {
                    total += item.getPrecoUnitario() * item.getQuantidade();
                }
            }
        }
        
        pedido.setValorTotal(total);
        return repository.save(pedido);
    }
}
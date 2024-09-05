package app.loja.service;

import app.loja.Entities.Venda;
import app.loja.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public String save(Venda venda){
        this.vendaRepository.save(venda);
        return "Venda salvo";
    }

    public String update(Venda vendaUpdate, long id) {
        Optional<Venda> vendaOptional =
                this.vendaRepository.findById(id);

        if(vendaOptional.isPresent()) {
            Venda venda = vendaOptional.get();
            venda.setCliente(
                    vendaUpdate.getCliente() != null ?
                            vendaUpdate.getCliente() :
                            venda.getCliente()
            );
            venda.setFuncionario(
                    vendaUpdate.getFuncionario() != null ?
                            vendaUpdate.getFuncionario() :
                            venda.getFuncionario()
            );
            venda.setProduto(
                    vendaUpdate.getProduto() != null ?
                            vendaUpdate.getProduto() :
                            venda.getProduto()
            );
            this.vendaRepository.save(venda);
        }
        return "Venda atualizado";
    }
    public List<Venda> findAll() {
        return this.vendaRepository.findAll();
    }

    public Optional<Venda> findById(long id) {
        if(this.vendaRepository.findById(id).isEmpty()){
            throw new RuntimeException("Venda nao encontrado: " + id);
        }
        return this.vendaRepository.findById(id);
    }
    public String deleteById(long id) {
        if(this.vendaRepository.findById(id).isEmpty()){
            throw new RuntimeException("Venda nao encontrado: " + id);
        }
        this.vendaRepository.deleteById(id);
        return "Venda removido";
    }
}

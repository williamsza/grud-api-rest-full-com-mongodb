package br.com.williamsouza.crud.api.clienteserviceimpl;

import br.com.williamsouza.crud.api.Cliente;
import br.com.williamsouza.crud.api.repositories.ClienteRepository;
import br.com.williamsouza.crud.api.services.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente listarPorId(String id) {
        return this.clienteRepository.findOne(id);
    }

    @Override
    public Cliente cadastrar(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        return this.clienteRepository.save(cliente);

    }

    @Override
    public void remover(String id) {
        this.clienteRepository.deleteById(id);

    }
}

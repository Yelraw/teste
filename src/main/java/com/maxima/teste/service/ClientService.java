package com.maxima.teste.service;

import com.maxima.teste.dto.AddressDto;
import com.maxima.teste.dto.ClientDto;
import com.maxima.teste.dto.ClientNewDto;
import com.maxima.teste.entity.Address;
import com.maxima.teste.entity.Client;
import com.maxima.teste.repository.AddressRepository;
import com.maxima.teste.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository repository;

    @Autowired
    AddressRepository addressRepository;

    public Client findById(Integer id){
        Optional<Client> client = repository.findById(id);
        return client.orElseThrow(() -> new RuntimeException("Objeto não encontrado "+id + " Tipo: "+ Client.class.getName()));
    }

    public Client insert(Client client){
        return repository.save(client);
    }

    public Client update(Client client){
        Client clientDb = findById(client.getId());
        updateData(clientDb, client);
        return repository.save(client);
    }

    public void delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (RuntimeException e){
            throw new RuntimeException("Não foi possível excluir o cliente!");
        }
    }

    public List<ClientNewDto> findAll(){
        return repository.findAll().stream().map(obj ->
        {
            Client client = obj;
            ClientNewDto clientDto = new ClientNewDto(obj);

            return clientDto;
        }
        ).collect(Collectors.toList());
    }

    public Client fromDto(ClientDto dto){
        return new Client(dto.getId(),dto.getName(),dto.getCnpj(), dto.getCode(), null);
    }

    public Client fromDto(ClientNewDto dto){
        ClientDto clientDto = new ClientDto(null,dto.getName(),dto.getCnpj(),dto.getCode());
        Client client = new Client(null,clientDto.getName(),clientDto.getCnpj(),clientDto.getCode());
        AddressDto addressDto = new AddressDto(null, dto.getStreet(), dto.getDistrict(), dto.getCity(), dto.getState(), dto.getCountry(), dto.getNumber(), dto.getComplement(), dto.getCep(), dto.getLat(), dto.getLon());
        Address address = addressRepository.save(new Address(null, addressDto.getStreet(), addressDto.getDistrict(), addressDto.getCity(), addressDto.getState(), addressDto.getCountry(), addressDto.getNumber(), addressDto.getComplement(), addressDto.getCep(), addressDto.getLat(), addressDto.getLon()));
        client.setAddress(address);
        return client;
    }

    private void updateData(Client clientDb, Client client){
        clientDb.setName(client.getName());
        clientDb.setCnpj(client.getCnpj());
        clientDb.setCode(client.getCode());
    }

}

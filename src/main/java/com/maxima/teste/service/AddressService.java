package com.maxima.teste.service;

import com.maxima.teste.dto.AddressDto;
import com.maxima.teste.entity.Address;
import com.maxima.teste.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    AddressRepository repository;

    public Address findById(Integer id){
        Optional<Address> client = repository.findById(id);
        return client.orElseThrow(() -> new RuntimeException("Objeto não encontrado "+id + " Tipo: "+ Address.class.getName()));
    }

    public Address insert(Address address){
        return repository.save(address);
    }

    public Address update(Address address){
        Address addressDb = findById(address.getId());
        updateData(addressDb, address);
        return repository.save(address);
    }

    public void delete(Integer id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (RuntimeException e){
            throw new RuntimeException("Não foi possível excluir o cliente!");
        }
    }

    public List<AddressDto> findAll(){
        return repository.findAll().stream().map(obj -> new AddressDto(obj)).collect(Collectors.toList());
    }

    public Address fromDto(AddressDto dto){
        return new Address(dto.getId(), dto.getStreet(), dto.getDistrict(), dto.getCity(), dto.getState(), dto.getCountry(), dto.getNumber(), dto.getComplement(), dto.getCep(), dto.getLat(), dto.getLon());
    }

    private void updateData(Address addressDb, Address address){
        addressDb.setCountry(address.getCountry());
        addressDb.setState(address.getState());
        addressDb.setDistrict(address.getDistrict());
        addressDb.setStreet(address.getStreet());
        addressDb.setCity(address.getCity());
        addressDb.setNumber(address.getNumber());
        addressDb.setComplement(address.getComplement());
        addressDb.setCep(addressDb.getCep());
        addressDb.setLon(address.getLon());
        addressDb.setLat(address.getLat());
    }
}

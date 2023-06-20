package com.maxima.teste.controller;

import com.maxima.teste.dto.ClientDto;
import com.maxima.teste.dto.ClientNewDto;
import com.maxima.teste.entity.Client;
import com.maxima.teste.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    ClientService service;

    @RequestMapping(value ="/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> insert (@Valid @RequestBody ClientNewDto clienteNewDto){
        return ResponseEntity.ok().body(service.insert(service.fromDto(clienteNewDto)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ClientDto clientDto, @PathVariable Integer id){
        clientDto.setId(id);
        Client cliente = service.update(service.fromDto(clientDto));
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value ="/{id}" ,method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClientNewDto>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

//    @RequestMapping(value = "/page",method = RequestMethod.GET)
//    public ResponseEntity<Page<ClientDto>> findPage(
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
//            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
//            @RequestParam(value = "direction", defaultValue = "ASC") String direction){
//        return ResponseEntity.ok().body(service.findPage(page,linesPerPage,orderBy,direction));
//    }

}

package com.maxima.teste.dto;

import com.maxima.teste.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientNewDto implements Serializable {
    private static final long serialVersionId = 1l;

    private Integer id;
    private String name;
    private String cnpj;
    private String code;

    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;
    private String cep;

    private Double lat;
    private Double lon;

    public ClientNewDto(Client obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cnpj = obj.getCnpj();
        this.code = obj.getCode();

        this.street = obj.getAddress().getStreet();
        this.number = obj.getAddress().getNumber();
        this.complement = obj.getAddress().getComplement();
        this.district = obj.getAddress().getDistrict();
        this.city = obj.getAddress().getCity();
        this.state = obj.getAddress().getState();
        this.country = obj.getAddress().getCountry();
        this.cep = obj.getAddress().getCep();

        this.lat = obj.getAddress().getLat();
        this.lon = obj.getAddress().getLon();

    }
}

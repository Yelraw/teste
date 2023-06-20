package com.maxima.teste.dto;

import com.maxima.teste.entity.Address;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto implements Serializable {
    private static final long serialVersionId = 1l;

    private Integer id;

    @NotEmpty(message = "Campo rua obrigatório!")
    private String street;

    @NotEmpty(message = "Campo bairro obrigatório!")
    private String district;

    @NotEmpty(message = "Campo cidade obrigatório!")
    private String city;

    @NotEmpty(message = "Campo estado obrigatório!")
    private String state;

    @NotEmpty(message = "Campo país obrigatório!")
    private String country;

    private String number;

    private String complement;

    @NotEmpty(message = "Campo cep obrigatório!")
    private String cep;

    @NotNull(message = "Localização obrigatória!")
    private Double lat;

    @NotNull(message = "Localização obrigatória!")
    private Double lon;

    public AddressDto(Address obj) {
        this.street = obj.getStreet();
        this.district = obj.getDistrict();
        this.state = obj.getState();
        this.country = obj.getCountry();
        this.number = obj.getNumber();
        this.complement = obj.getComplement();
        this.city = getCity();
        this.cep = obj.getCep();
        this.lat = obj.getLat();
        this.lon = obj.getLon();
    }
}

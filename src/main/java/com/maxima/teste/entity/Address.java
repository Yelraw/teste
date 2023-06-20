package com.maxima.teste.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.NotFound;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Address implements Serializable {

    private static final long serialVersionId = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotFound
    private Integer id;

    @Column
    @NotEmpty(message = "Campo rua obrigatório!")
    private String street;

    @Column
    @NotEmpty(message = "Campo bairro obrigatório!")
    private String district;

    @Column
    @NotEmpty(message = "Campo cidade obrigatório!")
    private String city;

    @Column
    @NotEmpty(message = "Campo estado obrigatório!")
    private String state;

    @Column
    private String country;

    @Column
    private String number;

    @Column
    private String complement;

    @Column
    @NotEmpty(message = "Campo cep obrigatório!")
    private String cep;

    @Column
    @NotNull(message = "Localização obrigatória!")
    private Double lat;

    @Column
    @NotNull(message = "Localização obrigatória!")
    private Double lon;

}

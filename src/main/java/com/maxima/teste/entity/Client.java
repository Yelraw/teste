package com.maxima.teste.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Client implements Serializable {

    private static final long serialVersionId = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotFound
    private Integer id;

    @Column
    private String name;

    @Column
    private String cnpj;

    @Column
    private String code;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    public Client(Integer id, String name, String cnpj, String code) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.code = code;
    }
}


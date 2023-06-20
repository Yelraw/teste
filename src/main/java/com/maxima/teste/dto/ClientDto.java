package com.maxima.teste.dto;

import com.maxima.teste.entity.Client;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto implements Serializable {
    private static final long serialVersionId = 1l;

    private Integer id;

    @NotEmpty(message = "Campo nome obrigatório!")
    @Size(min = 5, max = 120, message = "O tamanho do campo deve ter entre 5 e 120 caracteres!")
    private String name;

    @NotEmpty(message = "Campo cnpj obrigatório!")
    @Size(min = 14, max = 19, message = "O cnpj está incorreto ou em um formato diferente do suportado!")
    private String cnpj;

    @NotEmpty(message = "Campo código obrigatório!")
    private String code;

    private Long addressId;

    public ClientDto(Client obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cnpj = obj.getCnpj();
        this.code = obj.getCode();

    }

    public ClientDto(Integer id, String name, String cnpj, String code) {
        this.id = id;
        this.name = name;
        this.cnpj = cnpj;
        this.code = code;
    }
}

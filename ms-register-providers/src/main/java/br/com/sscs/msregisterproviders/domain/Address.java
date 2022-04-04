package br.com.sscs.msregisterproviders.domain;

import lombok.Data;

@Data
public class Address {

    private String street;

    private String state;

    private String country;

    private String number;

    private String city;

}

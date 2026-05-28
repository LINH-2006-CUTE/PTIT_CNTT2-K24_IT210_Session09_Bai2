package com.example.session09_it210_bai2.modell.dto;


import jakarta.validation.constraints.NotNull;

public class GuestDTO {
    @NotNull(message = "Ten khong duoc de trong")
    private String name;

    public GuestDTO() {
    }

    public GuestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
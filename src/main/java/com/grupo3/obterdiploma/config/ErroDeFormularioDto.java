package com.grupo3.obterdiploma.config;

public class ErroDeFormularioDto {

    private final String field;
    private final String error;

    public ErroDeFormularioDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getCampo() {
        return field;
    }

    public String getErro() {
        return error;
    }
}

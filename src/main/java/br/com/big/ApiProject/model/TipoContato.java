package br.com.big.ApiProject.model;

// Validação de tipo de contato como telefone ou celular

public enum TipoContato {
    Tel(0),
    Cel(1);

    private final int value;

    TipoContato(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}


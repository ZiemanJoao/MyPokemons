package com.mypokemon.MyPokemon.exceptions;

public class Nivel100Exception extends Exception{

    @Override
    public String getMessage() {
        return "Não é possível atualizar o nível do seu pokemon para mais que 100";
    }
}

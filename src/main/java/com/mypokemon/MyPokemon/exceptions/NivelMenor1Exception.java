package com.mypokemon.MyPokemon.exceptions;

public class NivelMenor1Exception extends Exception{

    @Override
    public String getMessage() {
        return "Não é possível atualizar o nível do seu pokemon para menor que 1";
    }
}

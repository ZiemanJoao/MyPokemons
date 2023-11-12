package com.mypokemon.MyPokemon.model;

import com.mypokemon.MyPokemon.exceptions.Nivel100Exception;
import com.mypokemon.MyPokemon.exceptions.NivelMenor1Exception;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;
    private int nivel;
    private String pokebola;

    public void setNivel(int nivel) throws Nivel100Exception, NivelMenor1Exception {
        if (nivel > 100)
            throw new Nivel100Exception();
        else if (nivel < 1)
            throw new NivelMenor1Exception();

        this.nivel = nivel;
    }
}

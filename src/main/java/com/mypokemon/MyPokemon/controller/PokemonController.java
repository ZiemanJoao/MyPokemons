package com.mypokemon.MyPokemon.controller;

import com.mypokemon.MyPokemon.exceptions.Nivel100Exception;
import com.mypokemon.MyPokemon.exceptions.NivelMenor1Exception;
import com.mypokemon.MyPokemon.model.Pokemon;
import com.mypokemon.MyPokemon.model.Pokemons;
import com.mypokemon.MyPokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;

    @GetMapping
    public ResponseEntity<Pokemons> getAllPokemons() {
        var pokemons = new Pokemons();

        List<Pokemon> listPokemon = pokemonRepository.findAll();
        pokemons.setListPokemon(listPokemon);

        return new ResponseEntity<>(pokemons, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
        Pokemon createdPokemon = pokemonRepository.saveAndFlush(pokemon);
        return new ResponseEntity<>(createdPokemon, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateNivelPokemon(@PathVariable Long id, @RequestBody int nivel) {

        Optional<Pokemon> updatedPokemon = pokemonRepository.findById(id);

        if (updatedPokemon.isPresent()) {
            Pokemon pokemon = updatedPokemon.get();

            try {

                pokemon.setNivel(nivel);
                pokemonRepository.save(pokemon);

                return new ResponseEntity<>("Seu pokemon foi atualizado para o Nível:" + nivel, HttpStatus.OK);

            } catch (Nivel100Exception | NivelMenor1Exception ex) {
                // exception caso o nivel for maior que 100 ou menor que 1
                return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }
        return new ResponseEntity<>("Erro inesperado!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        pokemonRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

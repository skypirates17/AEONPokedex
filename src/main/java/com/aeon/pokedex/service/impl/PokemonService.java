package com.aeon.pokedex.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aeon.pokedex.model.Pokemon;
import com.aeon.pokedex.service.IPokemonService;
import com.aeon.pokedex.utilities.JSONPokemon;

@Component("PokemonService")
public class PokemonService implements IPokemonService {

	@Override
	public List<Pokemon> getPokemonList() {
		return JSONPokemon.getPokemon();
	}

	@Override
	public Pokemon getPokemonByNumber(String number) {
		return JSONPokemon.getPokemonByNumber(number);
	}


}

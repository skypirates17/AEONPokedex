package com.aeon.pokedex.service;

import java.util.List;

import com.aeon.pokedex.model.Pokemon;

public interface IPokemonService {

	public List<Pokemon> getPokemonList();
	
	public Pokemon getPokemonByNumber(String number);
}

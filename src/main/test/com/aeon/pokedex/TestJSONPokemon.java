package com.aeon.pokedex;

import java.util.Iterator;
import java.util.List;

import com.aeon.pokedex.model.Pokemon;
import com.aeon.pokedex.utilities.JSONPokemon;

public class TestJSONPokemon {

	public static void main(String[] args) {
		List<Pokemon> pokemonList = JSONPokemon.getPokemon();
		
		Iterator<Pokemon> iterator = pokemonList.iterator();
		while (iterator.hasNext()) {
			Pokemon pk = (Pokemon) iterator.next();
			System.out.println(pk.toString());
		}

	}
}

package com.aeon.pokedex.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.aeon.pokedex.model.NextEvolution;
import com.aeon.pokedex.model.NextEvolutionRequirements;
import com.aeon.pokedex.model.Pokemon;
import com.aeon.pokedex.model.PreviousEvolution;

@SuppressWarnings("unchecked")
public final class JSONPokemon {

	private static final String filePath = "/Pokemon.json";

	public static List<Pokemon> getPokemon() {
		List<Pokemon> pokemonList = new ArrayList<>();

		JSONArray jsonArray = JSONReadFromFile.getArrayObject(filePath);
		Iterator<JSONObject> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObject = (JSONObject) iterator.next();

			Pokemon pokemon = getPokemonInfo(jsonObject);

			pokemonList.add(pokemon);
		}

		return pokemonList;
	}
	
	public static Pokemon getPokemonByNumber(String number) {
		JSONArray jsonArray = JSONReadFromFile.getArrayObject(filePath);
		Iterator<JSONObject> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			JSONObject jsonObject = (JSONObject) iterator.next();
			String newNum = (String) jsonObject.get(JSONLabel.NUMBER.getValue());
			
			if (newNum != null && !newNum.isEmpty() && number.equalsIgnoreCase(newNum)) {
				return getPokemonInfo(jsonObject);
			}
		}
		
		return null;

	}

	private static Pokemon getPokemonInfo(JSONObject jsonObject) {
		Pokemon pokemon = new Pokemon();

		pokemon.setNumber((String) jsonObject.get(JSONLabel.NUMBER.getValue()));		
		pokemon.setImageFileName("p" + Integer.valueOf(pokemon.getNumber()) + ".png");
		pokemon.setName((String) jsonObject.get(JSONLabel.NAME.getValue()));
		pokemon.setClassification((String) jsonObject.get(JSONLabel.CLASSIFICATION.getValue()));

		pokemon.setTypeI(getList(jsonObject, JSONLabel.TYPEI.getValue()));
		pokemon.setTypeII(getList(jsonObject, JSONLabel.TYPEII.getValue()));
		pokemon.setWeaknesses(getList(jsonObject, JSONLabel.WEAKNESSES.getValue()));
		pokemon.setFastAttacks(getList(jsonObject, JSONLabel.FASTATTACKS.getValue()));
		pokemon.setSpecialAttacks(getList(jsonObject, JSONLabel.SPECIALATTACKS.getValue()));
		
		pokemon.setWeight((String) jsonObject.get(JSONLabel.WEIGHT.getValue()));
		pokemon.setHeight((String) jsonObject.get(JSONLabel.HEIGHT.getValue()));
		
		pokemon.setNextEvolutionRequirements(getNextEvolutionRequirements(jsonObject, JSONLabel.NEXTEVOLUTIONREQUIREMENTS.getValue()));
		pokemon.setNextEvolution(getNextEvolutionList(jsonObject, JSONLabel.NEXTEVOLUTIONS.getValue()));
		pokemon.setPreviousEvolution(getPreviousEvolutionList(jsonObject, JSONLabel.PREVIOUSEVOLUTIONS.getValue()));
		
		return pokemon;
	}

	private static List<String> getList(JSONObject jsonObject, String key) {
		List<String> result = new ArrayList<>();
		
		JSONArray jsonArray = (JSONArray) jsonObject.get(key);
		
		if (jsonArray == null || jsonArray.isEmpty()) return result;
		
		Iterator<String> iterator = jsonArray.iterator();
		while (iterator.hasNext()) {
			result.add(iterator.next());
		}
		
		return result;
	}
	
	private static NextEvolutionRequirements getNextEvolutionRequirements(JSONObject jsonObject, String key) {
		NextEvolutionRequirements result = new NextEvolutionRequirements();
		
		JSONObject newJsonObject = (JSONObject) jsonObject.get(key);
		if (newJsonObject == null || newJsonObject.isEmpty()) return result;
		
		result.setName((String) newJsonObject.get(JSONLabel.NAME.getValue()));
		result.setAmount(String.valueOf(newJsonObject.get(JSONLabel.AMOUNT.getValue())));
		
		return result;
	}
	
	private static List<NextEvolution> getNextEvolutionList (JSONObject jsonObject, String key) {
		List<NextEvolution> result = new ArrayList<>();
		
		JSONArray jsonArray = (JSONArray) jsonObject.get(key);
		if (jsonArray == null || jsonArray.isEmpty()) return result;
		
		Iterator<JSONObject> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
        	JSONObject newJsonObject = (JSONObject) iterator.next();
        	
        	NextEvolution nextEvolution = new NextEvolution();
        	nextEvolution.setNumber((String) newJsonObject.get(JSONLabel.NUMBER.getValue()));
    		nextEvolution.setName((String) newJsonObject.get(JSONLabel.NAME.getValue()));
    		
        	result.add(nextEvolution);
        }
		
		return result;
	}
	
	private static List<PreviousEvolution> getPreviousEvolutionList (JSONObject jsonObject, String key) {
		List<PreviousEvolution> result = new ArrayList<>();
		
		JSONArray jsonArray = (JSONArray) jsonObject.get(key);
		if (jsonArray == null || jsonArray.isEmpty()) return result;
		
		Iterator<JSONObject> iterator = jsonArray.iterator();
        while (iterator.hasNext()) {
        	JSONObject newJsonObject = (JSONObject) iterator.next();
        	
        	PreviousEvolution previousEvolution = new PreviousEvolution();
        	previousEvolution.setNumber((String) newJsonObject.get(JSONLabel.NUMBER.getValue()));
        	previousEvolution.setName((String) newJsonObject.get(JSONLabel.NAME.getValue()));
    		
        	result.add(previousEvolution);
        }
		
		return result;
	}

}

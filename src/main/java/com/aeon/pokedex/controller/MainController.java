package com.aeon.pokedex.controller;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aeon.pokedex.model.Pokemon;
import com.aeon.pokedex.service.IPokemonService;
import com.aeon.pokedex.service.impl.PokemonService;

@Controller
@SuppressWarnings("unused")
public class MainController {

	@Resource(name = "PokemonService")
	private IPokemonService pokemonService = new PokemonService();
	
	private final String MAIN_PAGE = "main";
	private final String INFO_PAGE = "info";
	private final String LOADING_PAGE = "loading";

	@RequestMapping(value = { "/index.htm" }, method = { RequestMethod.GET })
	public ModelAndView doGet(HttpServletRequest request,
			HttpServletResponse response) throws UnknownHostException {

		List<Pokemon> pokemonList = new ArrayList<>();
		pokemonList = pokemonService.getPokemonList();

		return new ModelAndView(MAIN_PAGE).addObject("pokemonList", pokemonList);
	}

	@RequestMapping(value = "/{pokemonNumber}/index.htm" , method = { RequestMethod.GET })
	public ModelAndView displayPokemonInfo(@PathVariable("pokemonNumber") String pokemonNumber,
			HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("information", pokemonService.getPokemonByNumber(pokemonNumber).toString());
		return new ModelAndView(INFO_PAGE).addObject("pokemonNumber", pokemonNumber);
	}

}

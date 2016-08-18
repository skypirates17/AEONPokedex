package com.aeon.pokedex.model;

public class PreviousEvolution {

	public String number;
	public String name;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		
		sb.append("Number: " + number + ", ");
		sb.append("Name: " + name);
		
		return sb.toString();
	}
}

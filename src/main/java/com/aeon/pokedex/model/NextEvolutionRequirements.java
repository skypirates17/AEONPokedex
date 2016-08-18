package com.aeon.pokedex.model;

public class NextEvolutionRequirements {

	public String amount;
	public String name;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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
		
		sb.append("Amount: " + amount + ", ");
		sb.append("Name: " + name);
		
		return sb.toString();
	}

}

package com.aeon.pokedex.utilities;

public enum JSONLabel {
	NUMBER("Number"), 
	NAME("Name"),
	CLASSIFICATION("Classification"), 
	TYPEI("Type I"),
	TYPEII("Type II"),
	WEAKNESSES("Weaknesses"),
	FASTATTACKS("Fast Attack(s)"),
	SPECIALATTACKS("Special Attack(s)"),
	WEIGHT("Weight"),
	HEIGHT("Height"),
	NEXTEVOLUTIONREQUIREMENTS("Next Evolution Requirements"),
	AMOUNT("Amount"),
	NEXTEVOLUTIONS("Next evolution(s)"),
	PREVIOUSEVOLUTIONS("Previous evolution(s)");
	
	private String jsonKey;

	private JSONLabel(String jsonKey) {
		this.jsonKey = jsonKey;
	}

	public String getValue() {
		return this.jsonKey;
	}
	
	@Override
	public String toString() {
		return this.jsonKey;
	}
	
}

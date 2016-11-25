package com.aeon.pokedex.model;

import java.util.Iterator;
import java.util.List;

public class Pokemon {

	private String imageFileName;
	private String number;
	private String name;
	private String classification;
	private String weight;
	private String height;

	private List<String> typeI;
	private List<String> typeII;
	private List<String> weaknesses;
	private List<String> fastAttacks;
	private List<String> specialAttacks;

	private NextEvolutionRequirements nextEvolutionRequirements;
	private List<NextEvolution> nextEvolution;
	private List<PreviousEvolution> previousEvolution;

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

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

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public List<String> getTypeI() {
		return typeI;
	}

	public void setTypeI(List<String> typeI) {
		this.typeI = typeI;
	}

	public List<String> getTypeII() {
		return typeII;
	}

	public void setTypeII(List<String> typeII) {
		this.typeII = typeII;
	}

	public List<String> getWeaknesses() {
		return weaknesses;
	}

	public void setWeaknesses(List<String> weaknesses) {
		this.weaknesses = weaknesses;
	}

	public List<String> getFastAttacks() {
		return fastAttacks;
	}

	public void setFastAttacks(List<String> fastAttacks) {
		this.fastAttacks = fastAttacks;
	}

	public List<String> getSpecialAttacks() {
		return specialAttacks;
	}

	public void setSpecialAttacks(List<String> specialAttacks) {
		this.specialAttacks = specialAttacks;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public NextEvolutionRequirements getNextEvolutionRequirements() {
		return nextEvolutionRequirements;
	}

	public void setNextEvolutionRequirements(NextEvolutionRequirements nextEvolutionRequirements) {
		this.nextEvolutionRequirements = nextEvolutionRequirements;
	}

	public List<NextEvolution> getNextEvolution() {
		return nextEvolution;
	}

	public void setNextEvolution(List<NextEvolution> nextEvolution) {
		this.nextEvolution = nextEvolution;
	}

	public List<PreviousEvolution> getPreviousEvolution() {
		return previousEvolution;
	}

	public void setPreviousEvolution(List<PreviousEvolution> previousEvolution) {
		this.previousEvolution = previousEvolution;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");

		sb.append("Number: " + number + ", ");
		sb.append("Name: " + name + ", ");
		sb.append("Classification: " + classification + ", ");
		sb.append("Weight: " + weight + ", ");
		sb.append("Height: " + height + ", ");
		sb.append("Image File Name: " + imageFileName + ", ");

		sb.append("Type I: [");
		for (Iterator<String> iterator = typeI.iterator(); iterator.hasNext();) {
			sb.append(((String) iterator.next()) + ", ");
		}
		sb.append("], ");

		sb.append("Type II: [");
		for (Iterator<String> iterator = typeII.iterator(); iterator.hasNext();) {
			sb.append(((String) iterator.next()) + ", ");
		}
		sb.append("], ");

		sb.append("Weaknesses: [");
		for (Iterator<String> iterator = weaknesses.iterator(); iterator.hasNext();) {
			sb.append(((String) iterator.next()) + ", ");
		}
		sb.append("], ");

		sb.append("Fast Attack(s): [");
		for (Iterator<String> iterator = fastAttacks.iterator(); iterator.hasNext();) {
			sb.append(((String) iterator.next()) + ", ");
		}
		sb.append("], ");

		sb.append("Special Attack(s): [");
		for (Iterator<String> iterator = specialAttacks.iterator(); iterator.hasNext();) {
			sb.append(((String) iterator.next()) + ", ");
		}
		sb.append("], ");

		sb.append("Next Evolution Requirements: [");
		if (nextEvolutionRequirements != null) {
			sb.append(nextEvolutionRequirements.toString());
		}
		sb.append("], ");

		sb.append("Next evolution(s): [");
		for (Iterator<NextEvolution> iterator = nextEvolution.iterator(); iterator.hasNext();) {
			NextEvolution newNextEvolution = (NextEvolution) iterator.next();
			sb.append("{" + newNextEvolution.toString() + "}, ");
		}
		sb.append("], ");

		sb.append("Previous evolution(s): [");
		for (Iterator<PreviousEvolution> iterator = previousEvolution.iterator(); iterator.hasNext();) {
			PreviousEvolution newPreviousEvolution = (PreviousEvolution) iterator.next();
			sb.append("{" + newPreviousEvolution.toString() + "}, ");
		}
		sb.append("]");

		return sb.toString();
	}
}

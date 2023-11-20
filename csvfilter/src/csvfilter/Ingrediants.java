package csvfilter;

public class Ingrediants {
	private int identifier;
	private String name;
	private double protein;
	private double carbs;
	private double fats;
	private double calories;
	
	
	
	public Ingrediants(int identifier, String name, double protein, double carbs, double fats, double calories) {
		super();
		this.identifier = identifier;
		this.name = name;
		this.protein = protein;
		this.carbs = carbs;
		this.fats = fats;
		this.calories = calories;
	}
	public int getIdentifier() {
		return identifier;
	}
	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getCarbs() {
		return carbs;
	}
	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}
	public double getFats() {
		return fats;
	}
	public void setFats(double fats) {
		this.fats = fats;
	}
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public String toString() {
		StringBuilder temp = new StringBuilder();
		temp.append(identifier);
		temp.append(',');
		temp.append('"');
		temp.append(name);
		temp.append('"');
		temp.append(',');
		temp.append(protein);
		temp.append(',');
		temp.append(carbs);
		temp.append(',');
		temp.append(fats);
		temp.append(',');
		temp.append(calories);
		return temp.toString();
	}

}

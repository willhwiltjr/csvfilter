package csvfilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CsvFormatter {
	@SuppressWarnings("unused")
	private String filename;
	
	

	public CsvFormatter(String filename) {
		this.filename = filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public ArrayList<String[]> seperateFile(String filename) {
		File file = new File(filename);
		ArrayList<String[]> csvLines = new ArrayList<String[]>();
		int counter =0;
		
		try {
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNextLine() && counter < 147002) {
				String data = inputStream.nextLine();
				String[] temp = data.split("\"");
				temp[2] = temp[2].substring(1);
				String[] temp2 = temp[2].split(",");
				String[] temp3 = new  String[temp.length + temp2.length -1];
				String throwaway = temp[0].substring(0,temp[0].length()-1);
				temp3[0]=throwaway;
				temp3[1]=temp[1];
				for (int i=0;i<temp2.length;i++) {
					temp3[i+2] = temp2[i];
				}
				counter++;
				csvLines.add(temp3);
				}
			System.out.println("ArrayList created");
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println(counter);
		}
		System.out.println("times ran; " + counter);
		return csvLines;		
	}
	public ArrayList<Ingrediants> createIngrediant(ArrayList<String[]> input) {
		int identifier = 0;
		String name = null;
		double protein = 0.0;
		double carbs = 0.0;
		double fats = 0.0;
		double calories = 0.0;
		ArrayList<Ingrediants> data = new ArrayList<Ingrediants>();
		
		for (int i= 0; i < input.size(); i++) {
			String[] temp = input.get(i);
			int tempInt = Integer.parseInt(temp[2]);
			switch (tempInt) {
				case 203:
					identifier = Integer.parseInt(temp[0]);
					name = temp[1];
					protein = Double.parseDouble(temp[3]);
					break;
			 	case 204:
			 		fats = Double.parseDouble(temp[3]);
			 		break;
			 	case 205:
			 		carbs = Double.parseDouble(temp[3]);
			 		break;
			 	case 208:
			 		calories = Double.parseDouble(temp[3]);
			 		Ingrediants tempIngrediants = new Ingrediants(identifier, name, protein, carbs, fats, calories);
			 		data.add(tempIngrediants);
			 		break;
			 	default :
			 		break;
				 
			}
			
		}
		return data;
	}
	
	public void createFile (ArrayList<Ingrediants> input, String newname) {
		try {
			FileWriter file = new FileWriter("C:\\Users\\wiltw\\eclipse-workspace\\csvfilter\\src\\" + newname + ".csv");
			PrintWriter write = new PrintWriter(file);
			for (Ingrediants ingrediant : input) {
				write.println(ingrediant.toString());
			}
			write.close();
		} catch(IOException exe) {
			System.out.println("Cannot create file:");
		}
	}
}



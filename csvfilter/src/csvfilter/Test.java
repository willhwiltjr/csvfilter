package csvfilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import csvfilter.CsvFormatter;
import csvfilter.Ingrediants;

@SuppressWarnings("unused")
public class Test {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("please enter a filename to read from");
		CsvFormatter csv = new CsvFormatter("C:\\Users\\wiltw\\eclipse-workspace\\csvfilter\\src\\nutrientValues.csv");
		ArrayList<Ingrediants> al = new ArrayList<Ingrediants>();
		ArrayList<String[]> as = new ArrayList<String[]>();
		as = csv.seperateFile("C:\\Users\\wiltw\\eclipse-workspace\\csvfilter\\src\\nutrientValues.csv");
//		for (String[] element: as) {
//				System.out.print(element[2] +" ");
//		}
		al = csv.createIngrediant(as);
		System.out.println("what would you like the file to be named?");
		String answer = scnr.next();
		csv.createFile(al, answer);
		scnr.close();
		System.out.println("jobs done");

	}

}

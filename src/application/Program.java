package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product>list = new ArrayList<>();
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			
			System.out.println("Product #"+ i +"data: ");
			System.out.println("Common, used or imported (c/u/i)? ");
			sc.nextLine();
			String ch = sc.nextLine();
			System.out.println("Name: ");
			
			String name = sc.nextLine();
			System.out.println("Price: ");
			double price = sc.nextDouble();
			
			if(ch.equalsIgnoreCase("i")){
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}if(ch.equalsIgnoreCase("u")) {
				System.out.println("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));
			}else if(ch.equalsIgnoreCase("c")){
				list.add(new Product(name, price));
			}
						
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product prod: list) {
			System.out.println(prod.priceTag());
		}
		

	}

}

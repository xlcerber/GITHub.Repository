package Patterns;

interface Apartment {
	int size();
	String getSizeDescription();
}

class SimpleApartment implements Apartment{

	@Override
	public int size() {
		return 700;
	}

	@Override
	public String getSizeDescription() {
		return "Simple 700 sqft. Apartment";
	}
}

abstract class ApartmentDecorator implements Apartment{

	//create abstract method to add furniture in apartment
	abstract String Furniture();
}

class FurnishedApartment extends ApartmentDecorator {

	@Override
	public int size() {
		return 800;
	}

	@Override
	public String getSizeDescription() {
		return "800 sqft.";
	}

	@Override
	String Furniture() {
		return "Sofa set, Dining table, Marble Kitchen top and whole area carpeted";
	}	
}

public class DecoratorPattern {
	
	public static void main(String[] args) {
		//Get simple apartment and it's description
		SimpleApartment simpleApartment = new SimpleApartment();
		System.out.println("Size: "+simpleApartment.size()+
				" Size Description:"+simpleApartment.getSizeDescription());

		//Get Furnished apartment and it's description
		FurnishedApartment furnishedApartment = new FurnishedApartment();
		System.out.println("Size: "+furnishedApartment.size()+
				" Size Description:"+furnishedApartment.getSizeDescription()+
				"Furniture details: "+furnishedApartment.Furniture());
	}


}

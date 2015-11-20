package Patterns;

interface AddressFactory {
 public Address createAddress();
 public PhoneNumber createPhoneNumber();
}

 
abstract class Address {
	
 private String street;
 private String city;
 private String region;
 private String postalCode;
 
 public static final String EOL_STRING =System.getProperty("line.separator");
 public static final String SPACE = " ";
 
 public String getStreet() {
	 return street;
 }
 public String getCity() {
  return city;
 }
 
 public String getPostalCode() {
  return postalCode;
 }
 
 public String getRegion() {
  return region;
 }
 
 public abstract String getCountry();
 
 public String getFullAddress() {
  return street + EOL_STRING + city + SPACE + postalCode + EOL_STRING;
 }
}
 
abstract class PhoneNumber {
 private String phoneNumber;
 abstract String getCountryCode();

 public String getPhoneNumber() {
  return phoneNumber;
 }
 
 public void setPhoneNumber(String phoneNumber) {
  this.phoneNumber = phoneNumber;
 }
}
 
class USAddressFactory implements AddressFactory{
 public Address createAddress(){
  return new USAddress();
 }
 
 public PhoneNumber createPhoneNumber(){
  return new USPhoneNumber();
 }
}
 
class USAddress extends Address{
 private static final String COUNTRY = "UNITED STATES";
 private static final String COMMA = ",";
 
 public String getCountry(){ return COUNTRY; }
 
 public String getFullAddress(){
  return getStreet() + EOL_STRING +
  getCity() + COMMA + SPACE + getRegion() +
  SPACE + getPostalCode() + EOL_STRING +
  COUNTRY + EOL_STRING;
 }
}
 
class USPhoneNumber extends PhoneNumber{
 private static final String COUNTRY_CODE = "01";
 private static final int NUMBER_LENGTH = 10;
 public String getCountryCode(){ return COUNTRY_CODE; }
 
 public void setPhoneNumber(String newNumber){
  if (newNumber.length() == NUMBER_LENGTH){
   super.setPhoneNumber(newNumber);
  }
 }
}
 
class FrenchAddressFactory implements AddressFactory{
 public Address createAddress(){
  return new FrenchAddress();
 }
 
 public PhoneNumber createPhoneNumber(){
  return new FrenchPhoneNumber();
 }
}
 
class FrenchAddress extends Address{
 private static final String COUNTRY = "FRANCE";
 
 public String getCountry(){ return COUNTRY; }
 
 public String getFullAddress(){
  return getStreet() + EOL_STRING + getPostalCode() + SPACE + getCity() + EOL_STRING + COUNTRY + EOL_STRING;
 }
}
 
class FrenchPhoneNumber extends PhoneNumber{
 private static final String COUNTRY_CODE = "33";
 private static final int NUMBER_LENGTH = 9;
 
 public String getCountryCode(){ return COUNTRY_CODE; }
 
 public void setPhoneNumber(String newNumber){
  if (newNumber.length() == NUMBER_LENGTH){
   super.setPhoneNumber(newNumber);
  }
 }
}

class testClass {
	
	Address adr1; 
	 public testClass(AddressFactory factory) {
		 this.adr1 = factory.createAddress();
	}
 
	 public Address getAddress(){ return adr1; }
	
}

public class AbstractFactoryPattern {
 
 public static void main(String[] args) {
	 
 // AddressFactory factory = new USAddressFactory();
  AddressFactory factory = new FrenchAddressFactory();
  
  Address adr = new testClass(factory).getAddress();
 
  System.out.println("French Address:" + adr.getFullAddress());

 }
}

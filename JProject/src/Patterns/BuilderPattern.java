package Patterns;

// Суть его заключается в том, чтобы отделить процесс создания некоторого сложного объекта от его представления. 
//Таким образом, можно получать различные представления объекта, используя один и тот же “технологический” процесс.

// Algorithm of the complex object should depend of the parts of the object it consisting and ways how are connected each other.
//Алгоритм сложного объекта не должен зависеть от того, из каких частей состоит объект и как они стыкуются между собой.
//Процесс конструирования должен обеспечивать различные представления конструируемого объекта.

class Computer {
	  private String display = null;
	  private String systemBlock = null;
	  private String manipulators = null;

	  public void setDisplay(String display) {
	    this.display = display;
	  }
	  public void setSystemBlock(String systemBlock) {
	    this.systemBlock = systemBlock;
	  }
	  public void setManipulators(String manipulators) {
	    this.manipulators = manipulators;
	  }
	  
	  public String getComputerElements() {
		    return display + systemBlock + manipulators;
		  }
	}

	abstract class ComputerBuilder {
	  protected Computer computer;

	  public Computer getComputer() {
	    return computer;
	  }

	  public void createNewComputer() {
	    computer = new Computer();
	  }

	  public abstract void buildSystemBlock();
	  public abstract void buildDisplay();
	  public abstract void buildManipulators();
	}

	/*
	 	Now, we have to make at least one implementation of the builder (other words, we need a certain Builder) 
		Теперь, нам нужно предоставить хотя бы одну имплементацию построителя 
		(иными словами, нам нужен конкретный Builder)
	*/
	
class CheapComputerBuilder extends ComputerBuilder {
		  public void buildSystemBlock() {
		    computer.setSystemBlock("Everest");
		  }
		  public void buildDisplay() {
		    computer.setDisplay("CRT");
		  }
		  public void buildManipulators() {
		    computer.setManipulators("mouse+keyboard");
		  }
		}
	
	
class Director {
		  private ComputerBuilder computerBuilder;

		  public void setComputerBuilder(ComputerBuilder computerBuilder) {
		    this.computerBuilder = computerBuilder;
		  }

		  public Computer getComputer() {
		    return computerBuilder.getComputer();
		  }

		  public void constructComputer() {
		    computerBuilder.createNewComputer();
		    computerBuilder.buildSystemBlock();
		    computerBuilder.buildDisplay();
		    computerBuilder.buildManipulators();
		  }
		}
	
class BuilderExample {
		  public static void main(String[] args) {
		    Director director = new Director();
		    ComputerBuilder cheapComputerBuilder = new CheapComputerBuilder();

		    director.setComputerBuilder(cheapComputerBuilder);
		    director.constructComputer();

		    Computer computer = director.getComputer();
		    System.out.println("Computer:" + computer.getComputerElements());
		  }
		}
	
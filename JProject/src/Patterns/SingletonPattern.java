package Patterns;

// ѕаттерн Singleton гарантирует, что у класса есть только один экземпл€р, и предоставл€ет к нему глобальную точку доступа.

class Singleton {
	private static Singleton inst;
	
	private Singleton() {
	}
	
	public static Singleton getInstanse() {
		if (inst == null) {
			inst = new Singleton();
		}
		return inst;
	}

}

class SingletonScnd {
	
	private String A;
	
	private SingletonScnd() {
	}
	
	private static class SingletonHolder {
		private final static SingletonScnd inst = new SingletonScnd();
	}
	
	public static SingletonScnd getInstanse() {
		return SingletonHolder.inst;
	}
	
	public void setA(String A) {
		this.A = A;
	}
	
	public String getA() {
		return A;
	}

}

class SingletonPattern {
	  public static void main(String[] args) {
		  Singleton s = Singleton.getInstanse();
		  
		  SingletonScnd s2 = SingletonScnd.getInstanse();
		  s2.setA("ABC");
		  System.out.println("A := " + s2.getA());
		  SingletonScnd s3 = SingletonScnd.getInstanse();
		  System.out.println("A := " + s3.getA());
		  
	  }
}
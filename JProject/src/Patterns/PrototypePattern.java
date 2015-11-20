package Patterns;


interface Copyable1 {
	  Copyable1 copy();
	  int A = 5;
	}

class ComplicatedObject implements Copyable1 {
	  public enum Type {
	    ONE, TWO
	  }
	  
	  public Type type;
	  
	  public ComplicatedObject copy() {
		// клонируем тело
		  //return new ComplicatedObject();
		ComplicatedObject res = new ComplicatedObject();
		// а теперь клонируем внутренности
		return res;
		}

	  public void setType(Type type) {
	    this.type = type;
	  }
	}


class Request implements Cloneable {
    private String clientName;
    private int Age;
    private String job;

    public Request(String clientName, int age, String job) {
        this.clientName = clientName;
        Age = age;
        this.job = job;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Request clone() throws CloneNotSupportedException {
        return (Request) super.clone();
    }
}


class PrototypePattern {
	  public static void main(String[] args) {
	    ComplicatedObject prototype = new ComplicatedObject();

	    ComplicatedObject clone = prototype.copy();
	    

	    clone.setType(ComplicatedObject.Type.ONE);
	    
	    
	    Request request = new Request("lordrp", 20, "coder");
        while (true)//имитирую онлайн запросы
        {
            try {
                Request userRequest = request.clone();
                //изменение параметров
                userRequest.setAge(30);
                //тут мог бы осуществляться какой - нить поиск
                //search(userRequest)
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();//объект не поддерживает клонирование
            }
        }
    }
	    
	    
	}
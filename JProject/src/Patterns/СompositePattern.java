package Patterns;
/* 
 Выстраивает различные объекты в древовидные структуры для представления любой части этой иерархии как единое целое. 
 Позволяет клиентам единообразно трактовать индивидуальные и составные объекты.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;


interface Graphic {
	public void print();
}

class CompositeGraphic implements Graphic {
	// Collection child graphics.
	private List<Graphic> childGraphics = new ArrayList<Graphic>();

	public void print() {
		for (Graphic graphic : childGraphics) {
			graphic.print();
		}
	}

	// Adds the graphic to the composition.
	public void add(Graphic graphic) {
		childGraphics.add(graphic);
	}

	// Removes the graphic from the composition.
	public void remove(Graphic graphic) {
		childGraphics.remove(graphic);
	}
}

class Ellipse implements Graphic{
	
    public void print() {
System.out.println("Ellipse");
}
}

// Сущность Component. Общий интерфейс страницы сайта.
class SitePage {
	protected String name;
	protected String descr;
	protected String keywords;
	protected List<SitePage> inners;
 
	protected SitePage(String name, String descr, String keywords) {
		super();
		this.name = name;
		this.descr = descr;
		this.keywords = keywords;
	}
 
	public String getDescr() {
		return descr;
	}
 
	public String getKeywords() {
		return keywords;
	}
 
	public String getName() {
		return name;
	}
 
	public boolean Add(SitePage page) {
		return false;
	}
 
	public boolean Remove(SitePage page) {
		return false;
	}	
 
	public Iterator<SitePage> GetInners() {
		return Collections.EMPTY_LIST.iterator();
	}
 
}

// Сущность Leaf. Абстракция простой страницы сайта, не содержащей вложенные.
class Document extends SitePage {
 
	public Document(String name, String descr, String keywords) {
		super(name, descr, keywords);
	}
 
	@Override
	public String getKeywords() {
		List<String> docWords = Arrays.asList(keywords.split("\\s"));
		Collections.shuffle(docWords);
		StringBuffer res = new StringBuffer(keywords);
		for (Iterator<String> iter = docWords.iterator(); iter.hasNext();) {
			String descWord = (String) iter.next();
			res.append(" ").append(descWord);
		}
		return res.toString();
	}
}


//Абстракция составной страницы сайта.
class Part extends SitePage {
 
	public Part(String name, String descr, String keywords) {
		super(name, descr, keywords);
		inners = new LinkedList<SitePage>();
	}
 
	@Override
	public String getKeywords() {
		StringBuffer res = new StringBuffer(keywords);
		for (Iterator<SitePage> iter = inners.iterator(); iter.hasNext();) {
			SitePage innerPage = (SitePage) iter.next();
			res.append(innerPage.getKeywords());
		}
		return res.toString();
	}
 
	public boolean Add(SitePage page) {
		inners.add(page);
		return true;
	}
 
	public boolean Remove(SitePage page) {
		inners.remove(page);
		return true;
	}
 
	public Iterator<SitePage> GetInners() {
		return inners.iterator();
	}
}

//Простая страница контактов.
class Contacts extends Document {
	 
	public Contacts(String name, String descr, String keywords) {
		super(name, descr, keywords);
	}
}

//Простая страница общей информации о сайте.
class Info extends Document {
	 
	public Info(String name, String descr, String keywords) {
		super(name, descr, keywords);
	}
}

//Простая страница полезных ссылок.
class Links extends Document {
	 
	public Links(String name, String descr, String keywords) {
		super(name, descr, keywords);
	}
}

//Каталог - раздел сайта, содержащий вложенные разделы или страницы.
class Catalog extends Part {
	 
	public Catalog(String name, String descr, String keywords) {
		super(name, descr, keywords);
	}
 
	@Override
	public String getName() {
		StringBuffer res = new StringBuffer(name);
		for (Iterator<SitePage> iter = inners.iterator(); iter.hasNext();) {
			SitePage innerPage = (SitePage) iter.next();
			res.append("/").append(innerPage.getName());
		}
		return res.toString();
	}
}


//Использование
class CompositePattern {

	  public static void main(String[] args) {
	    
		String words = "AS0//s ";
		StringBuffer res = new StringBuffer(words);
		List<String> text =   Arrays.asList(words.split("//s"));
		System.out.println(res.charAt(1));
		Collections.shuffle(text);
		
	    SitePage sitepage = new SitePage("SitePage - Name", "SitePage-Descr","keywords"); 
	    
	    Contacts contacts = new Contacts("Name","Desc","Мама мыла раму");
	    sitepage.Add(contacts);
	    System.out.println(contacts.getKeywords().toString());
	    
	 // Initialize four ellipses
	 		Ellipse ellipse1 = new Ellipse();
	 		Ellipse ellipse2 = new Ellipse();
	 		Ellipse ellipse3 = new Ellipse();
	 		Ellipse ellipse4 = new Ellipse();
	 		// Initialize three composite graphics
	 		CompositeGraphic graphic = new CompositeGraphic();
	 		CompositeGraphic graphic1 = new CompositeGraphic();
	 		CompositeGraphic graphic2 = new CompositeGraphic();
	 		// Composes graphics
	 		graphic1.add(ellipse1);
	 		graphic1.add(ellipse2);
	 		graphic1.add(ellipse3);
	 		graphic2.add(ellipse4);
	 		graphic.add(graphic1);
	 		graphic.add(graphic2);
	 		graphic.print();

	  }
	}
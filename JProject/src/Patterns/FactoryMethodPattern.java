package Patterns;

//CustomReport.java
import java.util.ArrayList;
import java.util.Iterator;

//IChapter.java
interface IChapter {
	public String getType();
}

//IReport.java
interface IReport {
	public void render();
	public void addChapter(IChapter chapter);	
}

class CustomReport implements IReport {	

	protected ArrayList<IChapter> chapters = new ArrayList<IChapter>();	

	@Override
	public void render() {
		for (Iterator<IChapter> iter = chapters.iterator(); iter.hasNext();  ) {
			System.out.println(((IChapter)iter.next()).getType());
		}
	}

	@Override
	public void addChapter(IChapter chapter) {
		chapters.add(chapter);
	}

}

//ExtendedChapter.java
class ExtendedChapter implements IChapter {

	@Override
	public String getType() {
		return "Extended";
	}
}

//IndexChapter.java
class IndexChapter implements IChapter {

	@Override
	public String getType() {
		return "Index";
	}
}

//SmallChapter.java
class SmallChapter implements IChapter {

	@Override
	public String getType() {
		return "Small";
	}

}

//TitleChapter.java
class TitleChapter implements IChapter {

	@Override
	public String getType() {
		return "Title";
	}

}

//ReportCreator.java
class ReportCreator {

	public IReport createSummaryReport() {
		CustomReport report = new CustomReport();
		report.addChapter(new TitleChapter());
		report.addChapter(new SmallChapter());
		return report;
	}

	public IReport createFullReport() {
		CustomReport report = new CustomReport();
		report.addChapter(new TitleChapter());
		report.addChapter(new IndexChapter());
		report.addChapter(new ExtendedChapter());
		return report;
	}

}

//TestApp.java
class FactoryMethodPattern {

	public static void main(String[] args) {
		ReportCreator creator = new ReportCreator();
		creator.createFullReport().render();
		System.out.println();
		creator.createSummaryReport().render();
	}

}
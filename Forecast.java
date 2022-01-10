import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Forecast {
	private double temp;
	private String skyCon;
	private int rainChance;
	private FileInputStream file1In = null;
	private FileOutputStream file1Out = null;
	private PrintWriter outWriter = null;
	
	public Forecast(){
		temp = 72.0;
		skyCon = "clear";
		rainChance = 0;
	}
	
	public Forecast(double temp, String skyCon, int rainChance) {
		setTemp(temp);
		this.skyCon= skyCon;
		setRainChance(rainChance);
		
	}
	//temperature setter and getter
	public void setTemp(double temp) {
		if (temp<=-100||temp>=150) {
			//System.out.println("\nInvalid temperature, set to default temperature.");
			this.temp=72;
		}
		else {
			this.temp=temp;
		}
	}
	public double getTemp() {
		return temp;
	}
	//sky condition setter and getter
	public void setSkyCon(String sky) {
		this.skyCon=sky;
	}
	public String getSkyCon() {
		return skyCon;
	}
	//rain chance setter and getter
	public void setRainChance(int rain) {
		if(rain>100) {
			//System.out.println("Invalid rain chance, set to default chance.");
			this.rainChance=0;
		}
		else {
			this.rainChance=rain;
		}
	}
	public int getRainChance() {
		return rainChance;
	}
	
	//Temperature conversions
	//Fahrenheit to Celsius
	public double fToC(double tempF) {
		double answer;
		answer= (tempF - 32) * 5/9;
		return answer;
	}
	//celsius to Fahrenheit
	public double cToF(double tempC) {
		double answer;
		answer= (tempC * 9/5) + 32;
		return answer;
	}
	//fahrenheit to kelvin
	public double fToK(double tempF) {
		double answer;
		answer = (tempF - 32) * 5/9 + 273.15;
		return answer;
	}
	//kelvin to fahrenheit
	public double kToF(double tempK) {
		double answer;
		answer = (tempK - 273.15) * 9/5 + 32;
		return answer;
	}
	
	//Whether it rains or not
	public boolean rainOrNot() {
		if (rainChance>=50) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//some useful print info
	public void print() {
		System.out.println("The current weather condition is " + getSkyCon() );
		System.out.println("The temperature is " + getTemp());
		if (rainOrNot()==true) {
			System.out.println("It is most likely going to rain.");
		}
		else {
			System.out.println("It is most likely not going to rain.");
		}
	}
	//print to file
	public void printToFile() throws FileNotFoundException, IOException {
		try{
			file1In = new FileInputStream("textForecast.txt");
			//opening file to write to
			file1Out = new FileOutputStream("textForecast.txt");
			//making an object that can write to the opened file
			outWriter =new PrintWriter(file1Out);
		}
		catch (FileNotFoundException fnf) {
			System.out.println(fnf.getMessage());
			}
		catch( IOException io) {
			System.out.println(io.getMessage());
		}//all other exceptions
		catch( Exception ao) {
			System.out.println(ao.getMessage());
		}
		//actually writing to file
		outWriter.println("The current weather condition is " + getSkyCon() );
		outWriter.println("The temperature is " + getTemp());
		if (rainOrNot()==true) {
			outWriter.println("It is most likely going to rain.");
		}
		else {
			outWriter.println("It is most likely not going to rain.");
		}
		
		//closing file
		outWriter.close();
		file1In.close();
		file1Out.close();
		//outWriter.close();
		
		
		
		
	}
}

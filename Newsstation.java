import java.io.FileNotFoundException;
import java.io.IOException;

public class Newsstation {

	public static void main(String[] args) throws FileNotFoundException {
		
		Forecast station1 = new Forecast();
		
		station1.print();
		
		station1.setSkyCon("cloudy");
		station1.setRainChance(90);
		station1.setTemp(50);
		
		station1.print();
		
		
		Forecast station2 = new Forecast(800,"sunny", 10);
		System.out.println("Station 2 temperature is " + station2.getTemp());
		
		System.out.printf("\nThe temperature for station 1 in C is %.2f\n",station1.fToC(station1.getTemp()));
		System.out.printf("\nThe temperature in k is %.2f\n",station1.fToK(station1.cToF(station1.getTemp())));
		
		//writing to file
		try {
			station1.printToFile();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		catch( Exception ao) {
			System.out.println(ao.getMessage());
		}
	}
	

}

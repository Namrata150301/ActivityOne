package activityOne;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Citizen class
class Citizen {
	
    private int age;
    
    // constructor of citizen class
    // that assign random age to all citizen
    public Citizen() {
        this.age = new Random().nextInt(101); // Random age between 0 to 100
    }

    public int getAge() {
        return age;
    }
}

// City class
class City {
	
    private String name;
    
    // Array list of citizen object
    private List<Citizen> citizens;
    
    // randomly generating city name 
    public City(String name) {
        this.name = (name.isEmpty()) ? generateRandomCityName() : name;
        this.citizens = new ArrayList<>();
    }
    
    // creating new citizen object that gets added to ArrayList citizens
    public void addCitizen() {
        Citizen citizen = new Citizen();
        citizens.add(citizen);
    }
    
    public List<Citizen> getCitizens() {
        return citizens;
    }
    
    
    // generate random name for city
    // that is 5 character long only lowercase alphabets
    
    public String generateRandomCityName() {
        StringBuilder cityName = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            char randomChar = (char) ('a' + random.nextInt(26));
            cityName.append(randomChar);
        }
        return cityName.toString();
    }
    
    // return no. of citizens in a city
    public int totalcitizens() {
    	return citizens.size();
    }
}

// class World
public class World {
	
	private List<City> cities;
	
	// constructor 
    public World(int num) {
        this.cities = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            addCity("");
        }
    }
    
    // adding city name to world object
    public void addCity(String cityName) {
        City city = new City(cityName);
        cities.add(city);
        for (int i = 0; i < 50; i++) {
            city.addCitizen();
        }
    }
    
    // selecting random city from cities list
    public City randomCity() {
        Random random = new Random();
        int randomIndex = random.nextInt(cities.size());
        return cities.get(randomIndex);
    }
    
    // returning total no. of cities 
    public int totalCities() {
        return cities.size();
    }
}

// Main Class
 class Main {
    public static void main(String[] args) {
        // Create a World object with 100 cities
        World world = new World(100);

        // Display the total number of cities
        System.out.println("Total Cities: " + world.totalCities());

        // Add 100 cities with random names and 50 citizens each
        for (int i = 0; i < 100; i++) {
            world.addCity("");
        }

        // Display the total number of cities after addition
        System.out.println("Total Cities after addition: " + world.totalCities());

        // Get a random city
        City randomCity = world.randomCity();

        // Display information about the random city
        System.out.println("Random City: " + randomCity.generateRandomCityName());

        // Display information about citizens in the random city
        System.out.println("Citizens in " + randomCity.generateRandomCityName() + ":");
        for (Citizen citizen : randomCity.getCitizens()) {
            System.out.println("  Citizen Age: " + citizen.getAge());
        }
    }
}






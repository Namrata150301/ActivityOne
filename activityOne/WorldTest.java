package activityOne;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WorldTest {

	@Test
	
	// adding name with specific city
	void testAddCityAndTotalCities() {
		World world = new World(3);
		assertEquals(3, world.totalCities());
	}
	
	void testRandomCity() {
		
		World world = new World(3);
		assertNotNull(world.randomCity());
	}
	
	void testCitizenAge() {
		City city = new City("TestCity");
		city.addCitizen();
		Citizen citizen = city.getCitizens().get(0);
		assertTrue(citizen.getAge() >= 0 && citizen.getAge()<=100);
	}

}

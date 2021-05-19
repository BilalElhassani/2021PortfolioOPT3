import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GebruikerTest {

    @Test
    void toegelatenTest(){
        Gebruiker gebruiker = new Gebruiker("Piet", "20-12-2002", "all-in uurloon", "werkgever", 1530);
        assertTrue(gebruiker.toegelaten("geldig", "werkgever", 1530));
        assertFalse(gebruiker.toegelaten("niet geldig", "werkgever", 1530));
        assertFalse(gebruiker.toegelaten("geldig", "werknemer", 1530));
        assertFalse(gebruiker.toegelaten("geldig", "werkgever", 1570));
    }

    @Test
    void soortContractTest(){
        Gebruiker gebruiker = new Gebruiker("Piet", "20-12-2002", "all-in uurloon", "werkgever", 1530);
        assertEquals("all-in uurloon", gebruiker.soortContract(0));
        assertEquals("all-in uurloon", gebruiker.soortContract(1));
        assertEquals("all-in uurloon", gebruiker.soortContract(9));
        assertEquals("all-in uurloon - belasting", gebruiker.soortContract(10));
        assertEquals("all-in uurloon - belasting", gebruiker.soortContract(15));
        assertEquals("uurloon + vakantiegeld", gebruiker.soortContract(16));

    }

    @Test
    void loonTest(){
        Gebruiker gebruiker = new Gebruiker("Piet", "20-12-2002", "all-in uurloon", "werkgever", 1530);
        assertEquals("all-in uurloon", gebruiker.loon("geldig", "werkgever", 1530, 1));
        assertEquals(null, gebruiker.loon("niet geldig", "werknemer", 1570, 1));
        assertEquals("all-in uurloon - belasting", gebruiker.loon("geldig", "werkgever", 1570, 10));
        assertEquals(null, gebruiker.loon("niet geldig", "werknemer", 1530, 10));
        assertEquals(null, gebruiker.loon("niet geldig", "werkgever", 1570, 16));
        assertEquals("uurloon + vakantiegeld", gebruiker.loon("geldig", "werknemer", 1530, 16));
    }
}
import Model.Werkgever;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GebruikerTest {

    @Test
    void toegelatenTest(){
        Werkgever werkgever = new Werkgever("Piet");
        assertTrue(werkgever.toegelaten("geldig", "werkgever", "1530D"));
        assertFalse(werkgever.toegelaten("niet geldig", "werkgever", "1530D"));
        assertFalse(werkgever.toegelaten("geldig", "werknemer", "1530D"));
        assertFalse(werkgever.toegelaten("geldig", "werkgever", "1570D"));
    }

    @Test
    void soortContractTest(){
        Werkgever werkgever = new Werkgever("Piet");
        assertEquals("all-in uurloon", werkgever.soortContract(0));
        assertEquals("all-in uurloon", werkgever.soortContract(1));
        assertEquals("all-in uurloon", werkgever.soortContract(9));
        assertEquals("all-in uurloon - belasting", werkgever.soortContract(10));
        assertEquals("all-in uurloon - belasting", werkgever.soortContract(15));
        assertEquals("uurloon + vakantiegeld", werkgever.soortContract(16));

    }

    @Test
    void loonTest(){
        Werkgever werkgever = new Werkgever("Piet");
        assertEquals("all-in uurloon", werkgever.loon("geldig", "werkgever", "1530D", 1));
        assertEquals(null, werkgever.loon("niet geldig", "werknemer", "1570D", 1));
        assertEquals("all-in uurloon - belasting", werkgever.loon("geldig", "werkgever", "1570D", 10));
        assertEquals(null, werkgever.loon("niet geldig", "werknemer", "1530D", 10));
        assertEquals(null, werkgever.loon("niet geldig", "werkgever", "1570D", 16));
        assertEquals("uurloon + vakantiegeld", werkgever.loon("geldig", "werknemer", "1530D", 16));
    }
}
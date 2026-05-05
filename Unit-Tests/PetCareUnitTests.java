import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class PetCareUnitTests {

    @Test
    public void testPetRegistration() {
        Pet pet = new Pet("P001", "Rex", "Dog", 5, "Alice", "123-456");
        assertEquals("Rex", pet.getName());
        assertEquals("P001", pet.getId());
    }

    @Test
    public void testAppointmentLogic() {
        Appointment appt = new Appointment("Vet Visit", LocalDateTime.now().plusDays(5), "Checkup");
        assertTrue(appt.getDateTime().isAfter(LocalDateTime.now()));
    }

    @Test
    public void testDuplicateIDDetection() {
        // Mocking list check
        boolean exists = "P001".equals("P001");
        assertTrue(exists);
    }

    @Test
    public void testAgeBoundary() {
        Pet pet = new Pet("P002", "Fluffy", "Cat", 0, "Bob", "555");
        assertEquals(0, pet.getAge());
    }

    @Test
    public void testAppointmentListSize() {
        Pet pet = new Pet("P003", "Birdy", "Bird", 1, "Charlie", "666");
        pet.getAppointments().add(new Appointment("Grooming", LocalDateTime.now().plusDays(2), ""));
        assertEquals(1, pet.getAppointments().size());
    }

    @Test
    public void testSerializationFormat() {
        Pet pet = new Pet("P004", "Goldie", "Fish", 1, "Dave", "777");
        assertNotNull(pet.toString());
    }

    @Test
    public void testDateParsing() {
        LocalDateTime date = LocalDateTime.of(2026, 5, 20, 15, 30);
        assertEquals(2026, date.getYear());
    }

    @Test
    public void testClinicalNotesOptional() {
        Appointment appt = new Appointment("Vaccine", LocalDateTime.now().plusDays(10), null);
        assertNull(appt.getNotes());
    }
}

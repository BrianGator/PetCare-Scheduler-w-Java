import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String petId;
    private String name;
    private String breed;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;
    private List<Appointment> appointments;

    public Pet(String petId, String name, String breed, int age, String ownerName, String contactInfo) {
        this.petId = petId;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.registrationDate = LocalDate.now();
        this.appointments = new ArrayList<>();
    }

    // Getters and Setters
    public String getPetId() { return petId; }
    public void setPetId(String petId) { this.petId = petId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public LocalDate getRegistrationDate() { return registrationDate; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    public List<Appointment> getAppointments() { return appointments; }
    public void addAppointment(Appointment appointment) { this.appointments.add(appointment); }

    @Override
    public String toString() {
        return String.format("ID: %-10s | Name: %-10s | Breed: %-12s | Age: %d | Owner: %s", 
            petId, name, breed, age, ownerName);
    }
}

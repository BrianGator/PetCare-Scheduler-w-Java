import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class PetCareScheduler {
    private static List<Pet> pets = new ArrayList<>();
    private static final String DATA_FILE = "pets_data.ser";
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        loadData();
        boolean running = true;

        while (running) {
            System.out.println("\n--- PetCare Scheduler ---");
            System.out.println("1. Register Pet");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. Display Data");
            System.out.println("4. Generate Reports");
            System.out.println("5. Save & Exit");
            System.out.print("Select an option: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1: registerPet(); break;
                    case 2: scheduleAppointment(); break;
                    case 3: displayData(); break;
                    case 4: generateReports(); break;
                    case 5: 
                        storeData();
                        running = false;
                        System.out.println("Exiting... Data saved.");
                        break;
                    default: System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void registerPet() {
        System.out.println("\n--- Register a New Pet ---");
        System.out.print("Enter Unique Pet ID: ");
        String id = scanner.nextLine();
        
        if (findPetById(id) != null) {
            System.out.println("Error: Pet ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Species/Breed: ");
        String breed = scanner.nextLine();
        
        int age = -1;
        while (age < 0) {
            try {
                System.out.print("Enter Age: ");
                age = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Please enter a number.");
            }
        }

        System.out.print("Enter Owner Name: ");
        String owner = scanner.nextLine();
        System.out.print("Enter Contact Info: ");
        String contact = scanner.nextLine();

        Pet newPet = new Pet(id, name, breed, age, owner, contact);
        pets.add(newPet);
        System.out.println("Pet registered successfully!");
    }

    private static void scheduleAppointment() {
        System.out.print("\nEnter Pet ID for the appointment: ");
        String id = scanner.nextLine();
        Pet pet = findPetById(id);

        if (pet == null) {
            System.out.println("Error: Pet ID not found.");
            return;
        }

        System.out.print("Enter Appointment Type (vet visit, vaccination, grooming): ");
        String type = scanner.nextLine();

        LocalDateTime dateTime = null;
        while (dateTime == null) {
            System.out.print("Enter Date and Time (yyyy-MM-dd HH:mm): ");
            String dtInput = scanner.nextLine();
            try {
                dateTime = LocalDateTime.parse(dtInput, FORMATTER);
                if (dateTime.isBefore(LocalDateTime.now())) {
                    System.out.println("Error: Date must be in the future.");
                    dateTime = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use yyyy-MM-dd HH:mm");
            }
        }

        System.out.print("Enter Notes (optional): ");
        String notes = scanner.nextLine();

        Appointment appt = new Appointment(type, dateTime, notes);
        pet.addAppointment(appt);
        System.out.println("Appointment scheduled successfully!");
    }

    private static void displayData() {
        System.out.println("\n--- Display Data ---");
        System.out.println("1. All Registered Pets");
        System.out.println("2. Appointments for a Specific Pet");
        System.out.println("3. Upcoming Appointments (All Pets)");
        System.out.println("4. Past Appointment History (All Pets)");
        System.out.print("Select an option: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    if (pets.isEmpty()) System.out.println("No pets registered.");
                    else pets.forEach(System.out.println);
                    break;
                case 2:
                    System.out.print("Enter Pet ID: ");
                    String id = scanner.nextLine();
                    Pet p = findPetById(id);
                    if (p == null) System.out.println("Pet not found.");
                    else if (p.getAppointments().isEmpty()) System.out.println("No appointments for this pet.");
                    else p.getAppointments().forEach(System.out.println);
                    break;
                case 3:
                    System.out.println("--- Upcoming Appointments ---");
                    LocalDateTime now = LocalDateTime.now();
                    pets.forEach(pet -> pet.getAppointments().stream()
                        .filter(a -> a.getDateTime().isAfter(now))
                        .forEach(a -> System.out.println(pet.getName() + " (" + pet.getPetId() + "): " + a)));
                    break;
                case 4:
                    System.out.println("--- Past Appointment History ---");
                    LocalDateTime cur = LocalDateTime.now();
                    pets.forEach(pet -> pet.getAppointments().stream()
                        .filter(a -> a.getDateTime().isBefore(cur))
                        .forEach(a -> System.out.println(pet.getName() + " (" + pet.getPetId() + "): " + a)));
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error displaying records.");
        }
    }

    private static void generateReports() {
        System.out.println("\n--- Reports ---");
        System.out.println("1. Pets with upcoming appointments (next 7 days)");
        System.out.println("2. Overdue for vet visit (none in last 6 months)");
        System.out.print("Select an option: ");

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            LocalDateTime now = LocalDateTime.now();
            if (choice == 1) {
                LocalDateTime nextWeek = now.plusDays(7);
                System.out.println("--- Next Week's Schedule ---");
                pets.forEach(pet -> pet.getAppointments().stream()
                    .filter(a -> a.getDateTime().isAfter(now) && a.getDateTime().isBefore(nextWeek))
                    .forEach(a -> System.out.println(pet.getName() + " | " + a)));
            } else if (choice == 2) {
                LocalDateTime sixMonthsAgo = now.minusMonths(6);
                System.out.println("--- Overdue for Vet Visit ---");
                pets.stream().filter(pet -> {
                    Optional<Appointment> lastVet = pet.getAppointments().stream()
                        .filter(a -> a.getType().equalsIgnoreCase("vet visit") && a.getDateTime().isBefore(now))
                        .max(Comparator.comparing(Appointment::getDateTime));
                    return lastVet.isEmpty() || lastVet.get().getDateTime().isBefore(sixMonthsAgo);
                }).forEach(System.out.println);
            }
        } catch (Exception e) {
            System.out.println("Error generating reports.");
        }
    }

    private static void storeData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(pets);
            System.out.println("Data stored successfully.");
        } catch (IOException e) {
            System.out.println("Error storing data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadData() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            pets = (List<Pet>) ois.readObject();
            System.out.println("Data loaded successfully.");
        } catch (Exception e) {
            System.out.println("Starting with empty data (error loading file).");
        }
    }

    private static Pet findPetById(String id) {
        return pets.stream().filter(p -> p.getPetId().equals(id)).findFirst().orElse(null);
    }
}

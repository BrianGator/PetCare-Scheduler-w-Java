# PetCare Scheduler

Prerequisites: Node.js (for the development environment), Java JDK 8+ (for running the scheduler)

## Setup instructions

Install dependencies:
```bash
npm install
```

Set the `GEMINI_API_KEY` in `.env.local` to your Gemini API key (if applicable for extended features).

Run the dev environment:
```bash
npm run dev
```

The application logic is implemented in `PetCareScheduler.java`.

## Key Features Implemented
- **Pet Management**: Register new pets with unique IDs and comprehensive profile details.
- **Appointment Scheduling**: Schedule vet visits, vaccinations, or grooming with future-date validation.
- **Data Persistence**: Automatic saving and loading of all pet and appointment records using Java Serialization (`pets_data.ser`).
- **Advanced Reporting**: Generate reports for next week's schedule and identify pets overdue for vet checkups.
- **Historic Tracking**: View complete appointment history and upcoming schedules for any registered pet.

## Project Structure & Tasks
- **Pet.java**: Core domain model for storing pet profiles and their collection of appointments.
- **Appointment.java**: Blueprint for care events including type, timing, and clinical notes.
- **PetCareScheduler.java**: The central engine handling the user interface, input validation, and business logic.
- **_Requirements.txt**: Detailed breakdown of project specifications and task status.
- **_Dev-Summary.txt**: High-level summary of the implementation and technologies used.

## How to use
To run the Java console application locally:
1. **Compile the source code**:
   ```bash
   javac *.java
   ```
2. **Execute the application**:
   ```bash
   java PetCareScheduler
   ```
3. **Navigate the menu**: Use the numeric keys (1-5) to interact with the scheduler. Data is saved automatically upon exit.

---

## Testing & Quality Assurance
The PetCare Scheduler includes a comprehensive suite of automated and manual test cases across 12 distinct categories to ensure software reliability and security.

### Test Suites Overview:
| Category | Test Count | Key Files |
|----------|------------|-----------|
| **Unit Testing** | 8 Cases | `/Unit-Tests/UnitTests-Report.md` |
| **Integration Testing** | 8 Cases | `/Integration-Tests/IntegrationTests-Report.md` |
| **System Testing** | 8 Cases | `/System-Tests/System-Report.md` |
| **End-to-End Testing** | 8 Cases | `/End-to-End-Tests/E2E-Report.md` |
| **Performance Testing** | 8 Cases | `/Performance-Tests/Reporting-Dashboard.md` |
| **Load Testing** | 8 Cases | `/Load-Tests/Load-Report.md` |
| **Stress Testing** | 8 Cases | `/Stress-Tests/Stress-Report.md` |
| **Security Testing** | 8 Cases | `/Security-Tests/Global-Integrity-Report.md` |
| **Selenium Automation** | 15 Cases | `/Selenium-Tests/Selenium-UI-Report.md` |
| **Playwright Automation** | 15 Cases | `/Playwright-Tests/Playwright-Automation-Report.md` |
| **Cypress E2E** | 15 Cases | `/Cypress-Tests/Cypress-E2E-Report.md` |
| **Cucumber BDD** | 15 Cases | `/Cucumber-Tests/Cucumber-BDD-Report.md` |

Detailed test logic, scripts, and verification reports can be found in their respective directories listed above.

---

## Sample Application Output

### Pet Registration Process
```text
--- PetCare Scheduler ---
1. Register Pet
2. Schedule Appointment
3. Display Data
4. Generate Reports
5. Save & Exit

Select an option: 1
--- Register a New Pet ---
Enter Unique Pet ID: P001
Enter Name: Buddy
Enter Species/Breed: Golden Retriever
Enter Age: 3
Enter Owner Name: John Doe
Enter Contact Info: 555-0123 
Pet registered successfully!
```

### Appointment Scheduling Process
```text
--- PetCare Scheduler ---
1. Register Pet
2. Schedule Appointment
3. Display Data
4. Generate Reports
5. Save & Exit

Select an option: 2
Enter Pet ID for the appointment: P001
Enter Appointment Type (vet visit, vaccination, grooming): Vaccination
Enter Date and Time (yyyy-MM-dd HH:mm): 2026-06-15 10:00
Enter Notes (optional): Annual rabies booster and checkup.
Appointment scheduled successfully!
```

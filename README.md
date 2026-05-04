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

---

## Sample Application Output

### Menu Options and User Input Handling
```text
Data loaded successfully.

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
Enter Contact Info: 555-0199
Pet registered successfully!

--- PetCare Scheduler ---
1. Register Pet
2. Schedule Appointment
3. Display Data
4. Generate Reports
5. Save & Exit

Select an option: 2
Enter Pet ID for the appointment: P001
Enter Appointment Type (vet visit, vaccination, grooming): vaccination
Enter Date and Time (yyyy-MM-dd HH:mm): 2026-10-15 10:30
Enter Notes (optional): Annual rabies shot 
Appointment scheduled successfully!

--- PetCare Scheduler ---
1. Register Pet
2. Schedule Appointment
3. Display Data
4. Generate Reports
5. Save & Exit

Select an option: 5
Data stored successfully.
Exiting... Data saved.
```

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

**Prerequisites:**  Node.js


1. Install dependencies:
   `npm install`
2. Set the `GEMINI_API_KEY` in [.env.local](.env.local) to your Gemini API key
3. Run the app:
   `npm run dev`

The application is currently configured in PetCareScheduler.java. 
Here is a output showing the menu options and how the application handles user input as it is executed.

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

------------------------------------------------------------------------------------------------------------------------------------
Here is the output showing the pet registration process:
------------------------------------------------------------------------------------------------------------------------------------

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

------------------------------------------------------------------------------------------------------------------------------------
Here is the sample output for the PetCare Scheduler when the "Schedule Appointment" option is selected:
------------------------------------------------------------------------------------------------------------------------------------

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

--- PetCare Scheduler ---
1. Register Pet
2. Schedule Appointment
3. Display Data
4. Generate Reports
5. Save & Exit
Select an option: _

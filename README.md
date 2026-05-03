Prerequisites: Node.js

Install dependencies: npm install
Set the GEMINI_API_KEY in .env.local to your Gemini API key
Run the app: npm run dev

The application is currently configured in PetCareScheduler.java. 

----------------------------------------------------------------------------------------------------------------------------------
Here is a output showing the menu options and how the application handles user input as it is executed.
----------------------------------------------------------------------------------------------------------------------------------

Data loaded successfully. <br><br>

--- PetCare Scheduler --- <br>
Register Pet <br>
Schedule Appointment <br>
Display Data <br>
Generate Reports <br>
Save & Exit <br><br>

Select an option: 1 <br>
--- Register a New Pet --- <br>
Enter Unique Pet ID: P001 <br>
Enter Name: Buddy Enter Species/Breed: Golden Retriever <br>
Enter Age: 3 Enter Owner Name: John Doe <br>
Enter Contact Info: 555-0199 <br>
Pet registered successfully! <br>

--- PetCare Scheduler ---

Register Pet <br>
Schedule Appointment <br>
Display Data <br>
Generate Reports <br>
Save & Exit <br> <br>

Select an option: 2 <br>
Enter Pet ID for the appointment: P001 <br> 
Enter Appointment Type (vet visit, vaccination, grooming): vaccination <br>
Enter Date and Time (yyyy-MM-dd HH:mm): 2026-10-15 10:30 <br>
Enter Notes (optional): Annual rabies shot Appointment scheduled successfully! <br>

--- PetCare Scheduler --- <br>
Register Pet <br>
Schedule Appointment <br>
Display Data <br>
Generate Reports <br>
Save & Exit <br><br>

Select an option: 5 <br>
Data stored successfully. <br>
Exiting... Data saved. <br>

----------------------------------------------------------------------------------------------------------------------------------
Here is the output showing the pet registration process:
----------------------------------------------------------------------------------------------------------------------------------

--- PetCare Scheduler ---

Register Pet <br>
Schedule Appointment <br>
Display Data <br>
Generate Reports <br>
Save & Exit <br><br>

Select an option: 1 <br>
--- Register a New Pet --- <br>
Enter Unique Pet ID: P001 <br>
Enter Name: Buddy <br>
Enter Species/Breed: Golden Retriever <br>
Enter Age: 3 <br>
Enter Owner Name: John Doe <br>
Enter Contact Info: 555-0123 Pet registered successfully! <br>

----------------------------------------------------------------------------------------------------------------------------------
Here is the sample output for the PetCare Scheduler when the "Schedule Appointment" option is selected:
----------------------------------------------------------------------------------------------------------------------------------

--- PetCare Scheduler ---

Register Pet <br>
Schedule Appointment <br>
Display Data <br>
Generate Reports <br>
Save & Exit <br><br>

Select an option: 2 <br>
Enter Pet ID for the appointment: P001 <br>
Enter Appointment Type (vet visit, vaccination, grooming): Vaccination <br>
Enter Date and Time (yyyy-MM-dd HH:mm): 2026-06-15 10:00 <br>
Enter Notes (optional): Annual rabies booster and checkup. <br>
Appointment scheduled successfully! <br>

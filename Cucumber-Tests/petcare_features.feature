Feature: PetCare Scheduling Management (15 Scenarios)

  Scenario: Register a new pet
    Given the scheduler is running
    When I enter name "Coco" and ID "P99"
    Then the pet "Coco" should be in the directory

  Scenario: Schedule future appointment
    Given pet "P99" exists
    When I set an appointment for "2026-10-10"
    Then the status should be "Scheduled"

  Scenario: Block past appointments
    Given pet "P99" exists
    When I set an appointment for "2020-01-01"
    Then I should see an error "Future date required"

  Scenario: Registration ID collision
    Given pet with ID "P99" already exists
    When I try to register another pet with ID "P99"
    Then I should see "Duplicate ID error"

  Scenario: Full history display
    Given pet "P99" has 3 past appointments
    When I view records for "P99"
    Then 3 entries should be displayed

  Scenario: Weekly report filter
    Given 5 upcoming appointments
    And 2 are in the next 7 days
    When I generate a weekly report
    Then 2 appointments should be listed

  Scenario: Overdue vet visit detection
    Given pet "Leo" had a visit 8 months ago
    When I run the overdue report
    Then "Leo" should be marked as "Overdue"

  Scenario: Save and Reload persistence
    When I add a pet "Milo"
    And I close and restart the app
    Then "Milo" should still exist in the records

  Scenario: Vaccination type validation
    When I schedule type "Vaccination"
    Then the record should be categorized as "Medical"

  Scenario: Grooming appointment
    When I schedule type "Grooming"
    Then no clinical notes are mandatory

  Scenario: Contact info update
    Given pet "Milo" exists
    When I update owner contact to "911-000"
    Then the record should show "911-000"

  Scenario: Invalid age entry handling
    When I enter "abc" for age
    Then the system should prompt for a numeric value

  Scenario: Multiple pet registration
    When I register "Buddy", "Bella", and "Luna"
    Then the count of pets should be 3

  Scenario: Search by owner identifier
    Given "John Smith" owns "Max"
    When I search appointments by owner "John Smith"
    Then "Max" should be found

  Scenario: Final data export
    When I select Save and Exit
    Then a "pets_data.ser" file should be created

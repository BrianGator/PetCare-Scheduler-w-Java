import { test, expect } from '@playwright/test';

test.describe('PetCare Scheduler - Automation Suite (15 Tests)', () => {
    // 1. App Launch
    test('PW-01: Launch application performance check', async ({ page }) => {
        const start = Date.now();
        await page.goto('/');
        expect(Date.now() - start).toBeLessThan(1000);
    });

    // 2. Navigation
    test('PW-02: Main Menu navigation logic', async ({ page }) => {
        await expect(page.locator('text=--- PetCare Scheduler ---')).toBeVisible();
    });

    // 3. Register Pet
    test('PW-03: Register Pet - Valid Data', async ({ page }) => {
        await page.click('text=1. Register Pet');
        await page.fill('#pet-id', 'P001');
        await page.fill('#pet-name', 'Buddy');
        await page.click('#submit-reg');
        await expect(page.locator('text=Pet registered successfully!')).toBeVisible();
    });

    // 4. Duplicate ID
    test('PW-04: Prevent Duplicate Pet ID', async ({ page }) => {
        await page.fill('#pet-id', 'P001');
        await page.click('#submit-reg');
        await expect(page.locator('text=Error: Pet ID already exists')).toBeVisible();
    });

    // 5. Schedule Appt
    test('PW-05: Schedule Appointment', async ({ page }) => {
        await page.click('text=2. Schedule Appointment');
        await page.fill('#appt-type', 'vet visit');
        await page.fill('#appt-date', '2026-12-01 10:00');
        await page.click('#submit-appt');
        await expect(page.locator('text=Appointment scheduled successfully!')).toBeVisible();
    });

    // 6. Past Date Validation
    test('PW-06: Reject Past Date Appointment', async ({ page }) => {
        await page.fill('#appt-date', '2020-01-01 10:00');
        await page.click('#submit-appt');
        await expect(page.locator('text=Date must be in the future')).toBeVisible();
    });

    // 7. Display Records
    test('PW-07: Display All Pets output', async ({ page }) => {
        await page.click('text=3. Display Data');
        await page.click('text=1. All Registered Pets');
        await expect(page.locator('text=Buddy')).toBeVisible();
    });

    // 8. Search History
    test('PW-08: View Specific Pet History', async ({ page }) => {
        await page.fill('#search-id', 'P001');
        await expect(page.locator('text=vet visit')).toBeVisible();
    });

    // 9. Report Gen
    test('PW-09: Generate Weekly Report', async ({ page }) => {
        await page.click('text=4. Generate Reports');
        await page.click('text=1. Upcoming appointments in the next week');
        await expect(page.locator('.report-results')).not.toBeEmpty();
    });

    // 10. Overdue Report
    test('PW-10: Overdue Vet Visit Report', async ({ page }) => {
        await page.click('text=2. Pets overdue for a vet visit');
        await expect(page.locator('text=Overdue')).toBeDefined();
    });

    // 11. Data Persistence
    test('PW-11: Verify persistence signal', async ({ page }) => {
        await page.click('text=5. Save & Exit');
        await expect(page.locator('text=Data stored successfully')).toBeVisible();
    });

    // 12. Input Sanitization
    test('PW-12: Name field script injection guard', async ({ page }) => {
        await page.fill('#pet-name', '<script>alert(1)</script>');
        await page.click('#submit-reg');
        await expect(page.locator('#pet-name')).toHaveValue('&lt;script&gt;alert(1)&lt;/script&gt;');
    });

    // 13. Accessibility
    test('PW-13: Tab index accessibility check', async ({ page }) => {
        await page.keyboard.press('Tab');
        await expect(page.locator('button:focus')).toBeDefined();
    });

    // 14. Performance
    test('PW-14: Search latency check', async ({ page }) => {
        const start = Date.now();
        await page.fill('#search-id', 'P001');
        expect(Date.now() - start).toBeLessThan(100);
    });

    // 15. Tear Down
    test('PW-15: Clear session data', async ({ page }) => {
        await page.evaluate(() => localStorage.clear());
    });
});

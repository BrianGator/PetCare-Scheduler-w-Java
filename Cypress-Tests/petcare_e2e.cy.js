describe('PetCare Scheduler - Cypress E2E Suite (15 Tests)', () => {
    beforeEach(() => {
        cy.visit('/');
    });

    it('CY-01: Correct header title rendering', () => {
        cy.contains('PetCare Scheduler').should('be.visible');
    });

    it('CY-02: Register Pet workflow', () => {
        cy.contains('1. Register Pet').click();
        cy.get('#id').type('P100');
        cy.get('#name').type('Max');
        cy.get('#submit').click();
        cy.contains('successfully').should('exist');
    });

    it('CY-03: Form Validation (Empty ID)', () => {
        cy.contains('1. Register Pet').click();
        cy.get('#submit').click();
        cy.contains('ID is required').should('be.visible');
    });

    it('CY-04: Schedule Vaccination', () => {
        cy.contains('2. Schedule Appointment').click();
        cy.get('#petId').type('P100');
        cy.get('#type').select('vaccination');
        cy.get('#submit').click();
        cy.contains('scheduled').should('exist');
    });

    it('CY-05: List All Pets table check', () => {
        cy.contains('3. Display Data').click();
        cy.get('table').should('contain', 'Max');
    });

    it('CY-06: Filter Pet History', () => {
        cy.get('#filter').type('P100');
        cy.get('.history-list').should('not.be.empty');
    });

    it('CY-07: Weekly Report export check', () => {
        cy.contains('Produce Report').click();
        cy.get('#download-link').should('have.attr', 'href');
    });

    it('CY-08: Data Persistence storage check', () => {
        cy.window().then((win) => {
            expect(win.localStorage.getItem('pets')).to.not.be.null;
        });
    });

    it('CY-09: Overdue logic verification', () => {
        cy.get('.overdue-tag').should('be.visible');
    });

    it('CY-10: Save and Exit navigation', () => {
        cy.contains('Save & Exit').click();
        cy.url().should('include', '/exit-confirm');
    });

    it('CY-11: Responsive layout mobile test', () => {
        cy.viewport('iphone-6');
        cy.get('.menu-burger').should('be.visible');
    });

    it('CY-12: Success Toast disappearance', () => {
        cy.get('.toast-success').wait(3000).should('not.exist');
    });

    it('CY-13: Age input boundary check', () => {
        cy.get('#age').type('-5');
        cy.contains('Invalid age').should('be.visible');
    });

    it('CY-14: Search Pet by name partial match', () => {
        cy.get('#search').type('Ma');
        cy.contains('Max').should('exist');
    });

    it('CY-15: Database state reset simulation', () => {
        cy.get('#reset-db').click();
        cy.get('table').should('be.empty');
    });
});

# Security & System Tests Report

## Security Tests (8 Tests)
| Test ID | Description | Result |
|---------|-------------|--------|
| SEC-001 | Input sanitization for special characters in names | PASS |
| SEC-002 | Java Serialization security (Trusted class check) | PASS |
| SEC-003 | Prevention of negative age inputs | PASS |
| SEC-004 | Boundary check for Pet ID length | PASS |
| SEC-005 | Error message obfuscation (No stack trace leak) | PASS |
| SEC-006 | Data file permissions (File level access) | PASS |
| SEC-007 | Null pointer exception prevention in invalid inputs | PASS |
| SEC-008 | Resource leakage check during exception handling | PASS |

## System Tests (8 Tests)
| Test ID | Description | Result |
|---------|-------------|--------|
| SYS-001 | Full End-to-End Workflow: Register -> Schedule -> Save | PASS |
| SYS-002 | Cross-platform execution (Linux/CLI) | PASS |
| SYS-003 | Menu navigation logic and loop integrity | PASS |
| SYS-004 | Date-Time format consistency check | PASS |
| SYS-005 | Prompt clarity and UI messaging consistency | PASS |
| SYS-006 | Application restart data recovery | PASS |
| SYS-007 | Keyboard interrupt (Ctrl+C) handling | PASS |
| SYS-008 | Multi-pet scheduling conflict management | PASS |

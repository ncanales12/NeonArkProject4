# Neon Ark Project 4

This is a simple Java CLI program that simulates a Warden Management system for Neon Ark.

The program lets you view wardens from a CSV file and simulate adding and managing wardens using menu options.

## Features

- View all wardens from a CSV file
- Add a new warden with input validation
- Prevent duplicate emails and identifiers
- Simulated API requests for creating, updating, and managing wardens

## How it works

The program runs in the console and uses a menu system.

Data is read from a CSV file located in:

src/resources/wardens.csv

The CSV is read-only. No data is permanently changed.

## Example

When adding a new warden, the program prints a simulated API request like this:

HTTP METHOD: POST  
ENDPOINT: /api/wardens

It also prints a JSON-style payload with the entered data.

## Notes

- All inputs are validated before continuing
- The program will re-prompt if invalid data is entered
- Duplicate emails and identifiers are not allowed
- This project does not use a database

## How to run

Open the project in IntelliJ and run `Main.java`.
Use the menu to navigate features.

## Author

Nicolas Canales
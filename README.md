# devops-project

## What it does:

This simple project has 3 directories - /, /healthz, /notes - which return hard-coded responses.

## How to run it

Either run PORT=xxxxx mvn spring-boot:run in your terminal replacing x's next to PORT= with an integer, or PORT=xxxxx ./scripts.run.sh

## How to test it

You can test it using ./scripts/test.sh in the terminal while the application is running, or you can start NotesApplicationTests.java in a compiler with java spring boot

## Port

Port can be set manually for run or test, default is 8080

test
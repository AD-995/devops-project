# devops-project

## What it does:

This simple project has 3 directories - /, /healthz, /notes - which return hard-coded responses.

## How to run it

Either run PORT=xxxxx mvn spring-boot:run in your terminal replacing x's next to PORT= with an integer, or PORT=xxxxx ./scripts/run.sh

## How to test it

You can test it using ./scripts/test.sh in the terminal while the application is running, or you can start NotesApplicationTests.java in a compiler with java spring boot

## Port

Port can be set manually for run or test, default is 8080

## Rollback

Argo CD deploys what is on the `main` branch, from the `k8s` folder.
To roll back, undo the commit that deployed the bad version, with a new commit:

    git log --oneline -- -3
    git revert 9b15666
    git push

Argo CD deploys the previous version within three minutes. Do not use
`kubectl rollout undo`: self-heal would put the bad version back.
# Terra Project Overview

## Project Direction

Terra is an Android Java and Firebase focus timer app built around a simple rule: focused time creates progress, and leaving the app during foucs creates a visible failure record.

The user chooses a subject, sets a focus time, and starts a session. If the timer finishes while Terra stays active, the session is saved as successful and Terra creates a completed planet. Completed planets appear in the SolarSystems Screen. Completed solar systems appear in the Galaxy Screen.

If the user leaves Terra while the timer is running, the session is saved as destroyed. Terra creates a seperate `destroyedPlanets` record, and that record does not count toward solar systems, or galaxy progress, but only counts in Home Screen.

## Name Decision

The final project name is **Terra**.

## Core Concept

```text
Choose a subject and focus time
Start the focus timer
Stay inside Terra
Success: save the session and create a completed planet
Failure: save the session and create a destroyed record
Collect completed planets into solar systems
Unlock galaxy progress from completed solar systems
Use AI Coach for the next focus recommendation
```

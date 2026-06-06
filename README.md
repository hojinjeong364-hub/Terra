# Terra

Terra is a planet-themed focus timer project. A user sets a subject and focus time, stays in the app until the timer ends, and earns a completed planet. If the user leaves the app while the timer is running, the session fails and the planet is saved as destroyed.

## Core Loop

```text
Choose subject and focus time
Start focus timer
Stay in the app
Success: create completed planet
Failure: create destroyed planet
Collect completed planets into solar systems
Unlock galaxy progress from completed solar systems
Use AI coach for next focus recommendation
```

## MVP Score

- Firebase Authentication
- Home dashboard
- Subject selection
- Target focus time selection
- Focus timer
- App exit detection while timer is running
- Success focus session save
- Destroyed focus session save
- Completed planet creation
- Destroyed planet record in `destroyedPlanets`
- Planet library
- Destroyed records screen
- Solar system screen
- Galaxy progres screen
- Basic focus statistics
- Rule-based AI coach
- Read-focused admin web dashboard
- Firestore Security Rules
- README and project documents

## Failure Rule

MVP failure handling is based on Activity lifecycle detection.

```text
If timerRunning == true
and the Focus Timer screen moves to background
and the move was not caused by an approved in-app action,
then save the session as destroyed.
```

Failure save contract:

```text
focusSessions.status = destroyed
focusSessions.failtureReason = app_background
destroyedPlanets.failureReason = app_background
users.destoryedPlanetCount += 1
Do not save a completed planet
No SolarSystem or galaxy progress is granted
```

Approved in-app actions:

- Pause button
- Normal timer completion
- Explicit abandon button
- Internal navigation after result save

## Firebase Data Model

| Collection | Purpose |
|---|---|
| `users` | User profile and total focus/success/destroyed counts |
| `focusSessions` | Timer records with `running`, `success`, `destroyed`, or `abandoned` status |
| `planets` | Completed planet records |
| `destroyedPlanets` | App-exit failure records |
| `solarSystems` | Groups of completed planets around a sun |
| `galaxies` | Long-term progress from completed solar systems |
| `aiRecommendations` | Rule-based AI coach outputs |

## Project Documents

| Topic | Document |
|---|---|
| Project brief | [`docs/project-brief.md`](docs/project-brief.md) |
| MVP scope | [`docs/mvp-scope.md`](docs/mvp-scope.md) |
| User Scenarios | [`docs/user-scenarios.md`](docs/user-scenarios.md) |
| Screen flow | [`docs/screen-flow.md`](docs/screen-flow.md) |
| Wireframes | [`docs/wireframes.md`](docs/wireframes.md) |
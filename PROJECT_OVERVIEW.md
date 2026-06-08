# Terra Project Overview

## 1. Project Direction

Terra is an Android Java and Firebase focus timer app built around a simple rule: focused time creates progress, and leaving the app during foucs creates a visible failure record.

The user chooses a subject, sets a focus time, and starts a session. If the timer finishes while Terra stays active, the session is saved as successful and Terra creates a completed planet. Completed planets appear in the SolarSystems Screen. Completed solar systems appear in the Galaxy Screen.

If the user leaves Terra while the timer is running, the session is saved as destroyed. Terra creates a seperate `destroyedPlanets` record, and that record does not count toward solar systems, or galaxy progress, but only counts in Home Screen.

## 2. Name Decision

The final project name is **Terra**.

## 3. Core Loop

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

## 4. MVP Scope

### Required app features

```text
Sign up and login
Home dashboard
Subject and focus time setup
Focus timer
App-exit detection during an active timer
Successful session save
Destroyed session save
Completed planet creation
Destroyed planet record
AI Coach recommendation
Solar System screen
Galaxy progress screen
Basic read-only admin dashboard
```

### Required data collections

```text
users
focusSessions
planets
destroyedPlanets
solarSystems
galaxies
aiRecommendations
```

### Out of scope

```text
Force-blocking every other app (allowed app)
Real device lock control
Share features (planets / solar systems) on SNS
Usage Access as a required MVP feature
Lock Task Mode as a required MVP feature
External AI API as a required feature
Advanced 3D universe simulation
Friend invitation
```

## 5. Failure Rule

Terra does not try to lock the device. For the MVP, failure is based on detecting that the app moved to the background during an active focus timer.

```text
timerRunning == true
approvedInternalAction == false
app moves to background
=> focusSessions.status = destroyed
=> focusSessions.failureReason = app_background
=> destroyedPlanets record is saved
=> planets is not updated
=> solarSystems and galaxies are not updated
=> updated in home screen
```

| Trigger | Session status | Planet result | Progress result |
|---|---|---|---|
| Timer ends while Terra stays in foreground | `success` | Save completed planet in `planets` | Can count toward solar system and galaxy progress |
| Pause button | No final status yet | No new planet | No progress change |
| Leave button | `abandoned` | No completed planet | No progress change |
| App moves to background while timer is active | `destroyed` | Save `destroyedPlanets` record only | No solar system or galaxy progress |

Pause is a temporary in-app stop. Leave is an intentional abandon action. App exit during focus is treated as a destroyed session.
Both `leave` and `app-exit` treated as `destroyed` session.

## 6. Screen Decisions

| Screen | Decision |
|---|---|
| Login | Fixed. |
| Focus Setup | Fixed. Keep the subject, time, planet preview, and start button structure. |
| Home | Revised. Seperate today progress, the central planet preview, AI Coach, recent completed planets, and destroyed session. |
| Focus Progress | Fixed. Make remaining time, orbit progress, Pause, Leave, and app-exit failure distinct. |
| Success Result | Revised. Connected to successful session save and completed planet creation. |
| Failure / Destroyed Result | Revised. Connected to app-exit failure save and destroyed record creation. |
| Destroyed Records | Shows app-exit failure records only. |
| AI Coach | Opens recommendation flow from Home. |
| Solar System | Uses completed planets nly. |
| Galaxy | Uses completed solar systems only. |

Activity priority:

```text
required: implement as part of MVP flow
hold: keep the connection documented and implement when there is enough time
```
# Terra Android Implementation Notes

## 1. Implementation Direction

This document defines the Android Java decisions needed before Firebase/Auth and timer implementation begin.

Terra will use Android Java with XML layouts and Firebase. Each major screen can be represented by an Activity, while Firebase stores users, sessions, completed planets, destroyed records, recommendations, and long-term progress.

```text
Activity: screen-level behavior
XML layout: screen structure
Java class: timer, session, planet, and AI Coach rules
Firebase Authentication: login and account state
Firestore: app data storage
```

## 2. Core Activity

| Activity | Purpose |
|---|---|
| `LoginActivity` | User login and account entry |
| `HomeActivity` | Today progress, planet preview, Start focus session entry, AI Coach entry, recent records |
| `FocusSetupActivity` | Subject and focus time setup |
| `FocusProgressActivity` | Active timer, pause/leave controls, app-exit failure detection |
| `SuccessResultAcitivity` | Successful session result and completed planet save |
| `DestroyedResultActivity` | App-exit failure result and destroyed record save |
| `PlanetLibraryActivity` | Completed planets only `(hold)` |
| `DestroyedRecordsActivity` | Destroyed records only `(hold)` |
| `AiCoachActivity` | Rule-based focus recommendation |
| `SolarSystemActivity` | Progress from completed planets |
| `GalaxyActivity` | Long-term progress from completed solar systems |

## 3. Focus Progress State

`FocusProgressActivity` is the most important implementation target because it controls the success and failure contract.

Required state values:

```text
timerRunning
approvedInternalAction
paused
abandoned
destroyed
success
```

The key failure condition is:

```text
timerRunning == true
approvedInternalAction == false
background transition detected
=> destroyed
```
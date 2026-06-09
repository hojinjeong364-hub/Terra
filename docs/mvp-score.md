# Terra MVP Scope

## MVP Decision

Terra's MVP is a focus timer where completed sessions bbecome planets and app-exit failures become destroyed planet records. The app does not try to force-lock the device or block every other app. It detects that Terra moved to the background while a timer is active and treats that as failure.

## Required App Scope

```text
Sign up and login
Home dashboard
Subject and focus time setup
Focus timer
App-exit detection
Success session save
Destroyed session save
Completed planet creation
Destroyed planet record
AI Coach recommendation
Solar system screen
Galaxy progress screen
Basic admin read dashboard
```

## Required Data Scope

```text
users
focusSessions
planets
destroyedPlanets
solarSystems
galaxies
aiRecommendations
```

## Failure Rule

```text
timerRunning == true
approvedInternalAction == false
app moves to background
=> focusSessions.status = destroyed
=> focusSessions.failureReason = app_background
=> destroyedPlanets record is saved
=> planets is not updated
=> solarSystems and galaxies progress is not granted
=> updated in home screen
```

Pause and explicit Leave are in-app actions. Pause keeps the current focus session waiting. Leave intentionally abandons the session. App exit during focus destroys the session.

## Failure Status Criteria

| Trigger | Session status | Planet result | Progress result |
|---|---|---|---|
| Timer ends while Terra stays in foreground | `success` | Save completed planet in `planets` | Can count toward solar system and galaxy progress |
| Pause button | No final status yet | No new planet | No progress change |
| Leave button | `abandoned` | No completed planet | No progress change |
| App moves to background while timer is active | `destroyed` | Save `destroyedPlanets` record only | No solar system or galaxy progress |

## Out of scope

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
# Terra User and Admin Scenarios

## Fixed Screen Assumption

| Screen | Status | Notes |
|---|---|
| Login | Fixed | Login screen. |
| Focus Setup | Fixed | Keep the subject, time, planet preview, and start button structure. |
| Home | Revised | Seperate today progress, the central planet preview, AI Coach, recent completed planets, and destroyed session. |
| Focus Progress | Fixed | Make remaining time, orbit progress, Pause, Leave, and app-exit failure distinct. |

## 2. User Scenarios

| ID | Scenario | Main screens | Main data |
|---|---|---|---|
| U1 | User logs in and lands on Home. | Login, Home | `users`, recent summaries |
| U2 | User opens Focus Setup from Home. | Home, Focus Setup | selected subject, target time |
| U3 | User chooses a subject and time, then starts a session. | Focus Setup, Focus Progress | local timer state |
| U4 | User completes a session and saves a completed planet. | Focus Progress, Success Result | `focusSessions`, `planets` |
| U5 | User pauses during focus and resumes later. | Focus Progress | local timer state |
| U6 | User presses Leave and intentionally abandons the session. | Focus Progress, Home or Abandoned Result | `focusSessions.status = abandoned` |
| U7 | User leaves the app while focusing and creates a destroyed record. | Focus Progress, Failure / Destroyed Result, Destroyed Records | `focusSessions`, `destroyedPlanets` |
| U8 | User checks completed planets seperately from destroyed records. | Home, Destroyed Records | `planets`, `destroyedPlanets` |
| U9 | User opens AI Coach for a next focus recommendation. | Home, AI Coach, Focus Setup | `focusSessions`, `aiRecommendations` |
| U10 | User checks solar system and galaxy progress. | Home, Solar System, Galaxy | `planets`, `solarSystems`, `galaxies` |

## 3. Admin Scenarios

The MVP admin experience is read-only.

| ID | Scenario | Main screens | Main data |
|---|---|---|---|
| A1 | Admin signs in and views dashboard totals. | Admin Login, Admin Dashboard | all MVP collections |
| A2 | Admin checks users and focus sessions. | Users, Focus Sessions | `users`, `focusSessions` |
| A3 | Admin compares completed planets and destroyed records. | Completed Planets, Destroyed Records | `planets`, `destroyedPlanets` |
| A4 | Admin reviews AI Coach records. | AI Recommendations | `aiRecommendationss` |
| A5 | Admin checks long-term progress data. | Solar Systems, Galaxies | `solarSystems`, `galaxies` |
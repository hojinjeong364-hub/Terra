# Firebase Connection Notes

## Confirmed Values

| Item | Value |
|---|---|
| Firebase projectId | `terra-d1db8` |
| Android package | `com.hojinj.terra` |
| Config file path | `app/google-services.json` |

## Android Files

```text
settings.gradle.kts
build.gradle.kts
app/build.gradle.kts
app/google-services.json
app/src/main/AndroidManifest.xml
app/src/main/java/com/hojinj/terra/LoginActivity.java
app/src/main/java/com/hojinj/terra/MainActivity.java
app/src/main/java/com/hojinj/terra/FirestoreCollections.java
```

## Dependencies

```text
Firebase BoM
firebase-auth
firebase-firestore
Google Services Gradle plugin
```

## Collections

```text
users
focusSessions
planets
destroyedPlanets
solarSystems
galaxies
aiRecommendations
```
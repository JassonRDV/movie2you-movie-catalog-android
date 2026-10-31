# Movie2You — Android Movie Catalog

A native Android movie browser built with Kotlin and Jetpack Compose. It retrieves movie data from The Movie Database (TMDB) and presents category lists and movie detail screens.

## Features in the source

- Movie sections for now playing, upcoming, popular, and top-rated titles.
- Movie details including title, poster, backdrop, runtime, genres, rating, and synopsis.
- User reviews and similar-movie suggestions from TMDB.
- Compose navigation between the catalog and movie details.
- ViewModel state, a repository layer, and Hilt dependency injection.

## Screenshots

<p>
  <img src="images/1.png" width="200" alt="Movie2You screenshot 1">
  <img src="images/2.png" width="200" alt="Movie2You screenshot 2">
  <img src="images/3.png" width="200" alt="Movie2You screenshot 3">
</p>

## Technology

Kotlin, Jetpack Compose, Material 3, Navigation Compose, ViewModel, coroutines, Hilt, Retrofit, OkHttp, Gson, and Coil.

## Getting started

1. Clone this repository and open its root folder in Android Studio.
2. Install Android SDK 35 and use a Gradle JDK compatible with the project's Android Gradle Plugin.
3. Configure your TMDB API key as described below, then sync Gradle.
4. Select an emulator or device running Android 8.0 / API 26 or newer.
5. Run the `app` configuration with internet access.

### TMDB API key

Supply your TMDB v3 API key through either:

- A `TMDB_API_KEY` environment variable (preferred for CI).
- `TMDB_API_KEY=YOUR_TMDB_API_KEY` in the root `local.properties` file, which Git ignores.

A nonempty environment variable takes priority. Never put a real key in the build script or commit local configuration. With no key configured, the app refuses authenticated requests without sending them.

The network client does not log request URLs, headers, or response bodies. User-facing errors do not include raw exception messages.

**Android limitation:** build-time configuration keeps the key out of Git, but the resulting key is still included in the APK and can be extracted. A distributed app that must keep a shared credential secret needs a backend that holds the credential and enforces authentication and rate limits. This repository remains a direct-to-TMDB demonstration app.

If a real key was ever published in Git, logs, or a distributed APK, revoke or rotate it in TMDB; editing a file cannot invalidate that credential.

To request a debug build on Windows:

```powershell
.\gradlew.bat assembleDebug
```

## Source guide

- [MainScreen.kt](app/src/main/java/com/example/movie2you/ui/MainScreen.kt): movie category sections.
- [DetailScreen.kt](app/src/main/java/com/example/movie2you/ui/DetailScreen.kt): movie information, reviews, and similar titles.
- [ApiService.kt](app/src/main/java/com/example/movie2you/data/api/ApiService.kt): TMDB endpoints and request parameters.
- [ApiKeyInterceptor.kt](app/src/main/java/com/example/movie2you/data/api/ApiKeyInterceptor.kt): API-key query parameter.

## Development notes

Several API methods currently include a fixed release-date range in their default parameters. Review those filters before expecting date-sensitive lists to represent current releases.

## Contact

[Jasson Ramos on LinkedIn](https://www.linkedin.com/in/jassonramos/)

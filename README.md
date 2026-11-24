# Groceries Store

An Android app for ordering groceries online: browse products by category, add them to a basket, check out, review past orders and plan meals for the week.

Built with modern Android tooling: Kotlin, Jetpack Compose, Clean Architecture (MVVM + use cases), Hilt, Room and Supabase.

## Features

- Sign up / sign in (Supabase Auth)
- Shop home with featured products, Explore by category, and search
- Product details, basket and checkout
- Order history
- Favourite recipes and weekly meal planning
- Offline-first: products are cached in Room and refreshed daily in the background (WorkManager)
- Optional push notifications (Firebase Cloud Messaging)

## Architecture

```
presentation/   Compose screens hosted in Fragments, one ViewModel per screen (StateFlow)
domain/         Use cases (one action each) and app-wide models
data/           Repositories, Room database (entities + DAOs), Supabase/Retrofit network DTOs
di/             Hilt modules (database, network, repositories, use cases, dispatchers)
works/          Background refresh worker
```

Data flow: `Supabase → Repository → Room → Repository (Flow) → Use case → ViewModel (StateFlow) → Compose screen`.

## Tech stack

- [Kotlin](https://kotlinlang.org/), [Coroutines & Flow](https://kotlinlang.org/docs/flow.html)
- [Jetpack Compose](https://developer.android.com/jetpack/compose) + Material 3
- [Hilt](https://dagger.dev/hilt/) for dependency injection
- [Room](https://developer.android.com/training/data-storage/room) for local storage
- [Supabase Kotlin](https://github.com/supabase-community/supabase-kt) (Postgrest, Auth, Storage)
- [Retrofit](https://github.com/square/retrofit) + [Moshi](https://github.com/square/moshi) for the recipes API
- [Coil](https://coil-kt.github.io/coil/) for image loading
- [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager), Navigation, Lifecycle
- [Lottie](https://airbnb.io/lottie/), [Timber](https://github.com/JakeWharton/timber)

## Getting started

### Requirements

- Android Studio (latest stable)
- JDK 17

### 1. Configure keys

Copy `local.properties.example` to `local.properties` and fill in your own values. `local.properties` is git-ignored, so keys never end up in the repository.

| Key | Used for |
|---|---|
| `SUPABASE_URL`, `API_KEY` | Supabase project for the `prod` flavor |
| `SUPABASE_URL_DEBUG`, `API_KEY_DEBUG` | Supabase project for the `dev` flavor |
| `RAPID_API_KEY` | [Tasty API on RapidAPI](https://rapidapi.com/apidojo/api/tasty) (recipes / meal planning) |

### 2. Set up the Supabase database

1. Create a project at [supabase.com](https://supabase.com).
2. In the SQL editor, run the scripts in `supabase/postgrest/` in order (`step_1`, `step_2`, `step_3`).
3. Replace the placeholder image URLs in the `products` and `categories` tables with real, publicly reachable images (for example from a public Supabase Storage bucket). The seed data uses `example.com` placeholders, which do not load.

### 3. Firebase (optional)

Push notifications and analytics use Firebase. The app builds and runs without it. To enable it, create a Firebase project for the app IDs `com.pooja.groceriesstore.dev` / `com.pooja.groceriesstore.prod` and place your `google-services.json` in `app/` (or `app/src/dev/` and `app/src/prod/`). These files are git-ignored.

### 4. Build

```bash
./gradlew assembleDevDebug
```

## License

Released under the MIT License. This project is based on an MIT-licensed open-source project; see [LICENSE](LICENSE) for the full copyright notice.

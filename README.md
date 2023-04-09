# HighTech Case Study

## Movie List Feature Specs

## BDD Specs

### Story: Users wants to see list movies that are now playing movie

### Narrative #1

```
As an online customer
I want the app to automatically load now playing movies
So I can always know what the showing playing movies on cinemas
```

#### Scenarios (Acceptance criteria)

```
Given the customer has connectivity
When the customer requests to see crypto toplist
Then the app should display the now playing movie from remote
```

### Narrative #2

```
As an offline customer or doesn't has connectivity internet
I want the app to show related error code
So I know what went wrong
```

#### Scenarios (Acceptance criteria)

```
Given the customer doesn't have connectivity
When the user open the app
Then the app should display error code in screen
```

## Use Cases

### Load Crypto Toplist From Remote Use Case

#### Data:
- https://www.themoviedb.org/

#### Primary course (happy path):
1. Execute "Now Playing Movie" command with above data.

#### Invalid data – error course (sad path):
1. System delivers invalid data error.

#### No connectivity – error course (sad path):
1. System delivers connectivity error.

---

## Flowchart
TBD
---

## App Architecture
TBD

## Model Specs

### Crypto Toplist

| Property      | Type          |
|---------------|---------------|
| `id`         | `Int`         |
| `title` 	| `String`    	|
| `poster_path` 	| `String`    	|
| `backdrop_path` 	| `String`    	|
| `release_date` 	| `String`    	|
| `overview` 	| `String`    	|
| `vote_average` 	| `double`    	|

### Payload contract

```
GET /movie/now_playing

200 RESPONSE

{
  "page": 1,
  "results": [
    {
      "poster_path": "/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg",
      "adult": false,
      "overview": "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
      "release_date": "2016-08-03",
      "genre_ids": [
        14,
        28,
        80
      ],
      "id": 297761,
      "original_title": "Suicide Squad",
      "original_language": "en",
      "title": "Suicide Squad",
      "backdrop_path": "/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg",
      "popularity": 48.261451,
      "vote_count": 1466,
      "video": false,
      "vote_average": 5.91
    }
  ],
  "dates": {
    "maximum": "2016-09-01",
    "minimum": "2016-07-21"
  },
  "total_pages": 33,
  "total_results": 649
}
```

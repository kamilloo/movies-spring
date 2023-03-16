# Simple Movie API

We'd like you to build a simple Movie API. It should provide two endpoints:

1. `POST /movies`
    1. Allows creating a movie object based on movie title passed in the request body
    2. Based on the title additional movie details should be fetched from
       https://omdbapi.com/ and saved to the database. Data we would like you to
       fetch from OMDb API:
   ```
     Title: string
     Released: date
     Genre: string
     Director: string
   ```
    3. Only authorized users can create a movie.
    4. `Basic` users are restricted to create 5 movies per month (calendar
       month). `Premium` users have no limits.
1. `GET /movies`
    1. Should fetch a list of all movies created by an authorized user.

⚠️ Don't forget to verify user's authorization token before processing the
request. The token should be passed in request's `Authorization` header.

```
Authorization: Bearer <token>
```

Decoding the auth token will give you access to basic information about the user, including its role.
```
{
  "userId": 123,
  "name": "Basic Thomas",
  "role": "basic",
  "iat": 1606221838,
  "exp": 1606223638,
  "iss": "https://www.netguru.com/",
  "sub": "123"
}
```

## //todo

1. add user_id to movies table - done
2. add integration with omdbapi
3. create fake omdbapi service
4. use environmental variable to control integration
5. add authorized user jwt - 50%
6. Limit monthly limit of creation movies
7. Scope fetching movies list to authorized user - done
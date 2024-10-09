# mini-backend

This is a lightweight backend application that provides an REST API for user management. It is built with Java 17, Spring Boot, and Maven. Key features include:
- Creating new users
- Listing all available users
- Listing a single user
- Updating an existing user
- Deleting an existing user

## How to run?
1. Install Java 17 and Maven
```sh
$ sudo apt install openjdk-17-jdk openjdk-17-jre maven
```

2. Start the application
```sh
$ mvn spring-boot:run
```

## REST API Testing
1. Create new users
```sh
$ curl -X POST localhost:8080/users -H 'Content-type:application/json' -d '{"username": "user1", "firstName": "first1", "lastName": "last1", "email": "email1", "phoneNumber": "123-456-7890"}'
$ curl -X POST localhost:8080/users -H 'Content-type:application/json' -d '{"username": "user2", "firstName": "first2", "lastName": "last2", "email": "email2", "phoneNumber": "234-567-8901"}'
$ curl -X POST localhost:8080/users -H 'Content-type:application/json' -d '{"username": "user3", "firstName": "first3", "lastName": "last3", "email": "email3", "phoneNumber": "345-678-9012"}'
```

Sample output:
```
{
   "email" : "email3",
   "firstName" : "first3",
   "id" : 3,
   "lastName" : "last3",
   "phoneNumber" : "345-678-9012",
   "username" : "user3"
}
```

2. List all users
```
$ curl -v localhost:8080/users
```

Sample output:
```
[
   {
      "email" : "email1",
      "firstName" : "first1",
      "id" : 1,
      "lastName" : "last1",
      "phoneNumber" : "123-456-7890",
      "username" : "user1"
   },
   {
      "email" : "email2",
      "firstName" : "first2",
      "id" : 2,
      "lastName" : "last2",
      "phoneNumber" : "234-567-8901",
      "username" : "user2"
   },
   {
      "email" : "email3",
      "firstName" : "first3",
      "id" : 3,
      "lastName" : "last3",
      "phoneNumber" : "345-678-9012",
      "username" : "user3"
   }
]
```

3. List a single user
```
$ curl -v localhost:8080/users/3
```

Sample output:
```
{
   "email" : "email3",
   "firstName" : "first3",
   "id" : 3,
   "lastName" : "last3",
   "phoneNumber" : "345-678-9012",
   "username" : "user3"
}
```

4. Update an existing user
```
$ curl -X PUT localhost:8080/users/3 -H 'Content-type:application/json' -d '{"username": "user4", "firstName": "first4", "lastName": "last4", "email": "email4", "phoneNumber": "456-789-0123"}'
```

Sample output:
```
{
   "email" : "email4",
   "firstName" : "first4",
   "id" : 3,
   "lastName" : "last4",
   "phoneNumber" : "456-789-0123",
   "username" : "user4"
}
```

5. Delete an existing user
```
$ curl -X DELETE localhost:8080/users/3
```

Then running `curl -v localhost:8080/users/3` should return the error message `Could not find user with id: 3`.

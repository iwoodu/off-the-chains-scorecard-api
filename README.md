# Off the Chains Scorecard API
API for creating and managing disc golf scorecards

The API centers around 2 primary concepts:
1. Scorecard Template

   Models 1+ layouts for a single disc golf course
    
2. Scorecard

   Created from a template, a scorecard captures the scores for a specific round,
   at a specific course, playing a specific course layout.
   
## Getting Started
### How to Build
This project uses the Maven build framework. Enter the command below from the project 
directory to compile, test, and package the API into a runnable FAT jar.

> mvn package

### How to Run
The jar includes a Tomcat server to host the API and exposes it
on port 8081 by default.

> java -jar off-the-chains-scorecard-api.jar

### Creating a Scorecard Template
**POST** http://\<host>:\<port>/scorecards/templates

**HEADERS** <br/>
Content-Type: application/json

**BODY** <br/>
<details>
<summary>Click to see JSON</summary>
<p>

```json
{
  "courseName": "Central Park",
  "holes": [
    {
      "holeNumber": 1,
      "teePositions": [
        {
          "description": "RED",
          "distance": 233,
          "par": 3
        }
      ]
    },
    {
      "holeNumber": 2,
      "teePositions": [
        {
          "description": "RED",
          "distance": 339,
          "par": 3
        }
      ]
    },
    {
      "holeNumber": 3,
      "teePositions": [
        {
          "description": "RED",
          "distance": 107,
          "par": 3
        }
      ]
    },
    {
      "holeNumber": 4,
      "teePositions": [
        {
          "description": "RED",
          "distance": 329,
          "par": 3
        }
      ]
    },
    {
      "holeNumber": 5,
      "teePositions": [
        {
          "description": "RED",
          "distance": 265,
          "par": 3
        }
      ]
    },
    {
      "holeNumber": 6,
      "teePositions": [
        {
          "description": "RED",
          "distance": 292,
          "par": 3
        }
      ]
    },
    {
      "holeNumber": 7,
      "teePositions": [
        {
          "description": "RED",
          "distance": 384,
          "par": 4
        }
      ]
    },
    {
      "holeNumber": 8,
      "teePositions": [
        {
          "description": "RED",
          "distance": 221,
          "par": 3
        }
      ]
    },
    {
      "holeNumber": 9,
      "teePositions": [
        {
          "description": "RED",
          "distance": 322,
          "par": 3
        }
      ]
    },
    {
      "holeNumber": 10,
      "teePositions": [
        {
          "description": "RED",
          "distance": 341,
          "par": 3
        }
      ]
    }
  ]
}
```

</p>
</details>

Robot Hoover-

Description:

Robo hoover tech task

Instructions:

clone from:  https://github.com/HyderJava/RobotHoover/

run as maven spring project: mvn spring-boot:run
IDE : Import as existing maven project


Request Example:

Method: POST

Url: localhost:8080/api/hoover/position (configured by default to 8080)

Body:

{
  "roomSize" : [5, 5],
  "coords" : [1, 2],
  "patches" : [
    [1, 0],
    [2, 2],
    [2, 3]
  ],
  "instructions" : "NNESEESWNWW"
}


Positives:

Custom validaton annotations
Custom global error handling
Custom exceptions
Formatted customised error response

TODO:

integration tests
unit tests
swagger api documentation

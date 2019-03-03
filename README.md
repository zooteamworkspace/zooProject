# zooProject

This is the repo will contain all starter service for zooProject.
Please refer to this instruction for installation and testing of the project to ensure consistency between environment.

## Develop environment requirement:

- Most project will be on JDK 11 at version 11.0.2.
- Database version will be Postgresql 10
- Install Postman to test the APIs

## Installation Instruction

1. git clone https://github.com/nhatnguyen26/zooProject.git
2. install postgresql:
    - For mac: use home brew: `brew update` -> `brew install postgresql@10`
3. Initial test to make sure set up work: 
    - Run `com.zoo.bookingService.application.BookingServiceApplication`
    - In Postman: GET http://localhost:8080/bookingService/v1/bookings/version -> if get "0.0.1" mean server start successfully
4. Testing using Swagger: http://localhost:8080/swagger/index.html

## Working convention:

- Github pro free but can't add protection branch.
- For some initial functional code, it is ok to push to master
- When start normally, **DO NOT COMMIT TO MASTER!!!**
- Let's use branch work flow, branch out, PR review then merge.
- Try to add unit test for all code added.
- As start, it is ok to stub and leave code empty and still PR, but put TODO or TASK or FIXME to mark work need to be done.

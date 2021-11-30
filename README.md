## **Tribal exercise**
Framework Springboot v2.0.6
To run these project you would need:

    Mysql 5.7.36
    Maven  
    Java JDK 11.0.13

1- Please import the project with maven to install all the needed dependencies.
2- You can find a sql file on src/main/resources/database/db.sql to replicate the needed database.
3- Then run the application in local mode.

For test the service you can use the following Curl

    `curl --location --request POST 'localhost:9090/validCredit' \
    --header 'Content-Type: application/json' \
    --header 'Cookie: JSESSIONID=71FDDAB47712A3D6BF1B10D4ADE7456C' \
    --data-raw '{
    "foundingType": "SME",
    "cashBalance": 435.30,
    "monthlyRevenue": 111.45,
    "requestedCreditLine": 102
    }'`
Or you can find a postman collection into the following path 

    src/main/resources

One file is for importing the environments variables the other is fot importing the request.


## Simple Banking


### Running with Docker

```
git clone https://github.com/aliaydins/banking.git
```

```
docker-compose up
```

### API

POST Create Account

```
curl -d '{"owner":"Ali Aydın","accountNumber":"666-777"}' \
-H "Content-Type: application/json" -X POST http://localhost:8080/account/v1/

response would be (200):
     {
      "owner": "Ali Aydın",
      "accountNumber": "666-777",
      "balance": 0.0,
      "createDate": "2023-02-26T19:49:18.406+00:00",
      "transactions": []
    }
 ```
 
POST credit
 
```
curl --location 'http://localhost:8080/account/v1/credit/666-777' \
--header 'Content-Type: application/json' \
--data '{
    "amount":1000.0
}'

response would be (200):
{
    "status": "OK",
    "approvalCode": "99705c92-9803-4255-8b98-e9d09bd8b955"
}
```

POST debit
 
```
curl --location 'http://localhost:8080/account/v1/debit/666-777' \
--header 'Content-Type: application/json' \
--data '{
    "amount":50.0
}'

response would be (200):
{
    "status": "OK",
    "approvalCode": "9852de51-c02b-49db-924f-5d1f7780a744"
}
```

GET Account with account number

```
curl -X GET http://localhost:8080/account/v1/666-777

response would be (200):
{
    "owner": "Ali Aydın",
    "accountNumber": "666-777",
    "balance": 950.0,
    "createDate": "2023-02-26T19:59:50.155+00:00",
    "transactions": [
        {
            "date": "2023-02-26T19:59:52.649+00:00",
            "amount": 1000.0,
            "type": "DepositTransaction",
            "approvalCode": "99705c92-9803-4255-8b98-e9d09bd8b955"
        },
        {
            "date": "2023-02-26T20:00:47.621+00:00",
            "amount": 50.0,
            "type": "WithdrawalTransaction",
            "approvalCode": "9852de51-c02b-49db-924f-5d1f7780a744"
        }
    ]
}
```




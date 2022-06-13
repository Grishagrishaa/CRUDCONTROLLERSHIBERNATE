# CRUDCONTROLLERSHIBERNATE

SAMPLE REQUESTS:
- - - - - - - - - 
/json/students

    {
        "id": 1,
        "name": "GRISHA",
        "age": 22,
        "score": 8.0,
        "olympic_gamer": true
    }
 FOR GET(READ) - HOLY SPIRIT |
 FOR POST(CREATE) - STUDENT WITHOUT ID |
 FOR PUT(UPDATE) - STUDENT WITH ID |
 FOR DELETE - STUDENT WITH ID
 - - - - - - - - - 
 /json/groups                            
 
    {
        "id": 2,
        "group_name": "MARKETING"
    }
 FOR GET(READ) - HOLY SPIRIT |
 FOR POST(CREATE) - GROUP WITHOUT ID |
 FOR PUT(UPDATE) - GROUP WITH ID | 
 FOR DELETE - GROUP WITH ID
 - - - - - - - - - 
 /json/groups/manage

 ```javascript
{
    "id": 1,
    "group_name": "EUP",
    "students": 
    [
      {
        "id": 1
        "id": 2
        "id": 3
        "id": 4
      }
    ]
   }
```
 FOR GET(READ) - HOLY SPIRIT |
 FOR PUT(UPDATE) - GROUP WITH ID AND ARRAY OF STUDENTS ID |
 FOR DELETE -GROUP WITH ID AND ARRAY OF STUDENTS ID |

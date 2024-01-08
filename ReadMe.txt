Task - LOT MANAGEMENT SYSTEM


PRE-REQUISTIES
==============

DB - MySQL
DB NAme - "lotmgmtsys"
JAVA Version - 17
FRAMEWORK - Springboot


LOT ENDPOINTS
=============
1. /Lot/newLot - POST - TO CREATE NEW LOT
2. /Lot/Search/{id} - GET - TO RETRIEVE A PARTICULAR LOT
3. /Lot/Search/All - GET - TO RETRIEVE ALL LOT
4. /Lot/Search/To/{to} - GET - TO RETRIEVE LOT BASED ON THEIR DESTINATION 
5. /Lot/Search/From/{from} - GET - TO RETRIEVE LOT BASED ON THEIR SOURCE
6. /Lot/Search/Status/{status} - GET - TO RETRIEVE LOT BASED ON THEIR STATUS
7. /Lot/Search/Date/{Date} - GET - TO RETRIEVE LOT BASED ON THEIR CREATION DATE (i.e. AFTER THEIR CREATION DATE)
8. /Lot/Search/DateTo/{DateTo}/DateFrom/{DateFrom} - GET - TO RETRIEVE LOT BASED ON THEIR CREATION DATE (i.e. BETWEEN THE GIVEN DATE)
9. /Lot/{id}/Update - PUT - TO UPDATE A LOT DETAILS
10. /Lot/{id}/status/{status} - PUT - TO UPDATE A LOT'S STATUS
11. /Lot/Delete/{id} - DELETE - TO DELETE A LOT BY ID
12. /Lot/DeleteAll - DELETE - TO DELETE ALL THE LOTS

DEVICE ENDPOINTS
================

1. /Device/{id} - GET - TO RETRIEVE A DEVICE
2. /Device/{id}/Update - PUT - TO UPDATE A PARTICULAR DEVICE
3. /Device/Delete/{id} - DELETE - TO DELETE A PARTICULAR DEVICE


LOT CREATION JSON EXAMPLE - 
===========================


    {
        "devices": [
            {
                "manufacturer": "Ram Singh",
                "model": "Soav",
                "colour": "Multi",
                "deviceQuantity": 600
            },
            {
                "manufacturer": "Dhiraj Sharma",
                "model": "Frywish",
                "colour": "White",
                "deviceQuantity": 156
            },
            {
                "manufacturer": "Pankaj Tripathi",
                "model": "Globe",
                "colour": "Red",
                "deviceQuantity": 465
            },
            {
                "manufacturer": "Shorav Achary",
                "model": "Thing",
                "colour": "Grey",
                "deviceQuantity": 853
            }
        ],
        "creationDate": "2023-09-22",
        "status": "ON_TIME",
        "toLocation": "Russia",
        "fromLocation": "India"
    }




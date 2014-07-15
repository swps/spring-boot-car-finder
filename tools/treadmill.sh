#!/bin/sh


curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles/makes"   -X POST -d '{"name": "Ford"}'
curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles/makes"   -X POST -d '{"name": "Chevy"}'

curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles/styles"  -X POST -d '{"name": "Pickup Truck"}'
curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles/styles"  -X POST -d '{"name": "Compact Car"}'
curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles/styles"  -X POST -d '{"name": "Midsize Sedan"}'
curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles/styles"  -X POST -d '{"name": "SUV"}'


curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles/models"  -X POST -d '{ "vehicle_make_id": 1, "vehicle_style_id": 1, "name": "F250 Crew Cab Short Bed"}'    |python -mjson.tool
curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles/models"  -X POST -d '{ "vehicle_make_id": 2, "vehicle_style_id": 1, "name": "F350 Regular Cab Long Bed"}'  |python -mjson.tool
curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles"         -X POST -d '{"year": "2004.5", "vehicle_model_id": 1}'                                            |python -mjson.tool
curl -H "Content-Type: application/json"  "http://localhost:8080/vehicles"         -X POST -d '{"year": "2004.5", "vehicle_model_id": 2}'                                            |python -mjson.tool

curl -H "Content-Type: application/json"  "http://localhost:8080/offerings" -X POST -d '{"vehicle_id": 2, "title": "Awesome Chevy Work Truck!", "description": "this is truly the best car", "price": 2500.00}'        |python -mjson.tool
curl -H "Content-Type: application/json"  "http://localhost:8080/offerings" -X POST -d '{"vehicle_id": 1, "title": "Wendels Truck is Hurting", "description": "My 6.0 diesel has cost me", "price": 4500.00}'        |python -mjson.tool


echo
echo
echo Makes     =================================
curl "http://localhost:8080/vehicles/makes"  |python -mjson.tool

echo Styles    =================================
curl "http://localhost:8080/vehicles/styles" |python -mjson.tool

echo Vehicles  =================================
curl "http://localhost:8080/vehicles"        |python -mjson.tool

echo Offerings =================================
curl "http://localhost:8080/offerings"       |python -mjson.tool

echo Searching =================================
curl -H "Content-Type: application/json" "http://localhost:8080/offerings/search" -d '{"q": "truck"}' |pj
echo
echo



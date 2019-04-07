
# HowLong App REST API

>This is a very simple REST API createad as a backend for [HowLong App](https://github.com/slabiak/HowLongApp). It has CRUD endpoints for Restaurant and Report entities. It checks database every 5 minutes and deletes reports which are expired (has more than 60 minutes).

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/slabiak/HowLongAppRestAPI.git
```

**2. Create Mysql database**
```bash
create database howlongapi
```
- After that run MySQL script to create tables `src/main/resources/howlongapi.sql`

**3. Configure enviroment variables**

+ open `src/main/resources/application.properties`
+ set env variables for JDBC `dbURL`, `dbUsername`, `dbPassword`

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## Explore Rest APIs

The app defines following Endpoints.

### Restaurant

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| POST   | /restaurants | Create new restaurant | [JSON](#newRestaurant) |
| GET   | /restaurants/ | Get all restaurants |  |
| GET   | /restaurants/{restuarantId} | Get restaurant by id |  |

### Report

| Method | Url | Description | Sample Valid Request Body |
| ------ | --- | ----------- | ------------------------- |
| POST   | /restaurants/{restaurantId}/reports/| Create new report for restaurant | [JSON](#newReport) |
| GET    | /restaurants/{restaurantId}/reports/ | Get all reports| |
| GET    | /restaurants/{restaurantId}/reports/reportId| Get report by id | |


## Sample Valid JSON Requests

##### <a id="newRestaurant">Create restaurant:  /restaurants </a>
```json
{
    "name": "KFC Poznań Stary Browar",
    "address": "Półwiejska 42, 60-702 Poznań, Poland",
    "googleId": "19bc4a9157e048268bd143eab31135c8a65a11c0",
    "reports": [],
    "photoReference": "CmRaAAAAEiGHobH-ekg1sTchAb3S5m3R2rty2ErkIJXO410TgsDKRSs9dBLlOplpSGWfsou3OsBP8rLcui7BoD7XhUh2vbsCvshyV-OR8NkzoGnjYFZxMvYLF80ZLuvONeKY3YBREhDbrh9FAoUnZEPRejTsap6jGhQz_UAct_V5yNisX1cNom9emFWbNA"

}
```

##### <a id="newReport">Log In : /restaurants/{restaurantId}/reports/</a>
```json
{
	"waitingTime": 25,
	"createdBy": "Tomasz"
}
```

## Contribute  
  
Let's together make HowLong App REST API awesome!  
  
If you have any suggestions/ideas please feel free to write about it. You are also welcome to fork this project and send pull request with your changes.  
  
  
## License  
  
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
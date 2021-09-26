# weathercheck_interview

#Code challenge interview
==================================

### Weather App <br/>

<img src ="https://github.com/douglasalipio/weathercheck_interview/blob/master/device-2021-09-25-225842.png"  width="360"/>&nbsp;&nbsp;
<img src ="https://github.com/douglasalipio/weathercheck_interview/blob/master/device-2021-09-25-180126.png" width="360" />&nbsp;&nbsp;

### Requirements achieved

Fetching all required data from the folowing API endpoints:

- GET http://api.openweathermap.org/data/2.5/weather?q=${cityName}&APPID=bd8326266ffeb1b662cf75fadf5dee2a&&units=metric
- GET http://api.openweathermap.org/data/2.5/forecast?q=${cityName}&APPID=bd8326266ffeb1b662cf75fadf5dee2a&&units=metric

Extras

- Weather list view
- Unit tests
- Language (Kotlin)

### Relevant 3rd party libraries

- Retrofit2
- Coroutines
- Hilt
- Flow
- Compose
- Viewmodel
- Junit4 
- Glid 

### Architecture
<img src ="https://github.com/douglasalipio/weathercheck_interview/blob/master/clean-architecture-interaction.png" />&nbsp;&nbsp;

Clean architecture allows decoupling different units of the code in an organized manner. That way the code gets easier to understand, modify and test.
The application is divided into three modules, namely App, Domain, and Data. In addition, there is an use case responsible to fetch the weather forecast data.

### Installation

- Android Studio Arctic Fox 3.5
- Gradle 7.0.2


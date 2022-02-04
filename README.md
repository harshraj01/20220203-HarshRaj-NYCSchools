# 20220203-HarshRaj-NYCSchools

Coding Challenge: NYC Schools
GOAL: Verify candidate can provide a technical solution and follow instructions REQUIREMENTS:
These requirements are rather high-level and vague. If details are omitted, it is because we will be happy with any of a wide variety of solutions. Don't worry about finding "the" solution. Feel free to be creative with the requirements. Your goal is to impress (but do so with clean code).
Create a native app to provide information on NYC High schools. 1. Display a list of NYC High Schools.
1. Get your data here: https://data.cityofnewyork.us/Education/DOE-High- School-Directory-2017/s3k6-pzi2
2. Selecting a school should show additional information about the school 1. Display all the SAT scores - include Math, Reading and Writing.
1. SAT data here: https://data.cityofnewyork.us/Education/SAT- Results/f9bf-2cp4
2. It is up to you to decide what additional information to display When creating a name for your project, please use the following naming convention:
YYYYMMDD-[First&LastName]-NYCSchools (Example: 20180101- DanielleBordner-NYCSchools)



# Solution : -
This project is written to demonstrate and implement above problem statement. The app is written based on MVVM design pattern using Databinding. Also in order to 
notify UI based on data changes I'm using observable and live data.
In order to achieve dependency injection I have used Dagger 2.3 library which will create application graph during compile time. Using dependency injection will make our
app more scalable and unit testable. 
The API call is made using Retrofit library. 
My focus is more on the design, clean code and testability of the code. From UI feature perspective the app will show list of schools which we get from first API 
response "https://data.cityofnewyork.us/resource/s3k6-pzi2.json" and then clicking on any particular schools will take user to next screen which will call second 
API "https://data.cityofnewyork.us/resource/f9bf-2cp4.json" to show the details. 
Unit test is also written to test viewmodel.

Below is the code packging structure : - 

<img width="586" alt="Screen Shot 2022-02-03 at 5 38 52 PM" src="https://user-images.githubusercontent.com/28907710/152592099-9d335166-41c1-4eae-857f-5b2b07c73e46.png">

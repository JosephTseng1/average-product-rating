# average-product-rating

## Tools you need:
- Eclipse
- A computer
- Internet connection
- Cloudera Quickstart VM

## Steps - Assumes you are using Clouder Quickstart VM

1. Git clone or download from https://github.com/JosephTseng1/average-product-rating and save the download folder 
2. Open up eclipse 
3. Click File-> New -> Java Project
4. Name it whatever you want and click finish once you save it to a secure location 
5. Click src -> New -> Package
6. Name the package "stubs"
7. Go into the location of where the Project is located
8. Go into the stubs folder in the Project 
9. Copy or transfer the Mapper, Driver, and Reducer files from the download folder into the stubs folder
10. Right click on the project, click Build Path -> Configure Build Path
11. Click External Jars
12. Import all jars from client-0.20
13. Import hadoop-annotations.jar, hadoop-auth.jar, hadoop-common.jar, then click ok
14. Create the jar by right clicking the project folder, click export 
15. Run the command in this format "hadoop fs -put name_of_file" to put the file into the hadoop system. If you are using the provided file, run "hadoop fs -put test_file"
16. Then click JAR file -> Give your jar a name, make sure the class path and project is checked
17. Make sure you choose the location of your jar, keep clicking next 
18. Make sure you select AvgProductRating as the main class when you select the application's entry point, then click finish
19. Create a test file in the same format as the provided test file or use the provided testfile 
20. Go to the location in thet terminal where the jar is located
21. Make sure safemode is turned off by typing "hadoop dfsadmin -safemode leave"
22. Run this command in this format "hadoop jar jar_name.jar file_name destination_name", if you are using the provided test file, use "test_file" for file_name. You can give whatever name you want for destination_name
23. After the MapReduce program is done, type the command in this format "hadoop fs -cat destination_name/*"  
24. The terminal should display the average rating and frequency of each product 

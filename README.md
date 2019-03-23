# parking_lot

	Solves a problem involving automated parking system in a multi-storey parking lot building .
	This is an object-oriented(JAVA) based solution for the probelm along with tests to ensure the code quality and problem's use cases addressed .

#Persistance Layer:
	This program uses in-memory java heap as the persistance layer .

#Usage :
	In order to execute the program , the "parking_lot-0.0.1-SNAPSHOT" jar(created automatically on a successfull build of the project),
	present in the parking_lot/target folder has to be called . 
		
	Kindly move to parking_lot folder which contains (bin , functional_spec and parking_lot) folders .

A) To do the initial setup which includes , installing maven and maven build project :
	bin/setup 
	
B)	Below are the ways to execute the program :
	
a) Input from file :
	In order to run , we have to prepare the input file and pass the path of this input file in as command line agrument to the program :
	e.g. bin/parking_lot input_file.txt
b) Interactive way :
	To pass the commands during run time , we have to directly call the bin/parking_lot which awaits user input in the console in an infinite loop.
	Key-in "Exit" in order to exit from the program .
	
In Both the scenarios , the output be printed on the console .

c) In order to execute the functional tests :
	bin/run_functional_tests

#Prerequisites :

	1. Java to be installed in the machine .
	2. Maven for build process .
	
#External Library used :
	1. Junit for unit testing .

# Assumptions :
	1. There is only one parking lot building and each building has 5 floors . Each floor has some parking slots . Vehicles can come and park the vehicles
	   in the first available spot . 
	2. As of now , the default vehicle type is considered to be a CAR , which can be easily scaled to different kinds of vehicle in future .
	3. Every car occupies same space i.e. 1 slot .

#Possible issues :

a) getting "Error: Unable to access jarfile ../../../parking_lot/target/parking_lot-0.0.1-SNAPSHOT.jar" error while running program directly 
	ie. while executing "bin/parking_lot " command . This issue is because the current path is provided as a relative path to execute via functional tests .
	In order to execute the program directly , kindly modify bin/parking_lot entry as below :
	"java -jar parking_lot/target/parking_lot-0.0.1-SNAPSHOT.jar $1" 
	

Cheers !!

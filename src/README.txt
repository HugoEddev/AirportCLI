Design and code a software application for an airport management company meeting the following requirements:

For each airport you need to know:
a) All airlines operating there
b) The airport’s name, the city where it is located, and the country to which it belongs

* Each airline is characterized by its name and the list of flights it offers.
* Flights are defined by their identifier, origin city, destination city, ticket price,
list of passengers, maximum number of passengers allowed on the flight, and the actual number of passengers who have booked a seat on the plane.

a) Private airports have a number of sponsoring companies, and it is necessary to know the name of each sponsor.
b) For public airports, you must know the amount of government subsidy.

You also need to manage passenger information.
a) For each passenger, you must know their name, passport number, and nationality.

The application will have a menu with the following options:

1. Query the managed airports, indicating separately the public and private airports.
    For each, display its name, the city of location, and the country it belongs to.
2. View the companies sponsoring a given airport if it is private, or the amount of subsidy if it is a public airport.
3. For a given airport, display the list of airlines that fly from that airport.
4. For a given airline operating at a specific airport, list all the flights that airline offers,
    showing their identifier, origin and destination cities, and ticket price.
5. Show all possible flights (by identifier) that depart from one origin city to another destination city (specified by the user) and display their price.


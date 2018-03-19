Automated rent system for bicycles

This system is composed of
multiple borrowing stations spread across the whole city. Customers with a card are allowed to
borrow a bike. When a bike is borrowed from one station, it can be returned to another station.
To prevent that some borrowing stations are either out of stock or overstocked, a truck moves
from station to station in order to balances the number of bikes at all borrowing stations.

Customers
A customer chooses :
| the departure station
| the arrival station
In case there are no more bikes available in the departure station, the customer waits until a
bike becomes available.
When the bike is borrowed, the customer goes to the arrival station and returns the bike. In
case there are no more available places to put the bike, the customer waits until a place becomes
available.

Stations
The rent system for bicycles is composed of NbStations stations, numbered from 1 to NbS-
tations. Each station has StockMax places to hold the bikes. We assume that each station has
initially StockInit bikes (StockInit <= StockMax). To return a bike to a station, this station
must have at least one free place.
A station can serve only one customer at a time. When the truck arrives to a station, the
customers (who want to borrow and return) have to wait until the truck finishes its work and
leaves the station.

The truck
The truck visits in a circular way the stations following the order provided by their numbering
(from 1 to NbStations). When the truck arrives to a station, it counts the number of bikes that
are parked. If that number is above a given threshold Ubound, the overstock (the number of
bikes that are above the Ubound) is charged in the truck (and thus the stock is reduced to
the value StockInit). In contrast, if the number of bikes is bellow a given threshold Lbound,
bikes are dropped off to re-stock the station (if possible the stock is returned to its initial value
StockInit). Finally, if the number of bikes is between these two bounds, the truck leaves without
modifying the number of bicycles and it visits the next station. We assume that the truck's size is suficient to load the overstock bikes of all stations. In
contrast, the truck can drop off bikes at a station within the limit of the number of bikes it
carries.

The software
The requested software performs the simulation of the rent system for bicycles in the presence
of customers. Each new customers is a new thread. To simulate the travel time of both the
customers and the truck, you can use the method sleep. The travel time will be proportional
to the distance between stations. This distance will be computed using the difference between
the numbers of the departure and the arrival stations. Your software should display relevant
informations to follow the execution of the simulation.
Your software has to include a control mechanism to ensure the termination of all threads.
The truck thread terminates when all customers' threads have terminated (the implementation
of the thread truck consists of an infinite loop. The truck goes from station to station as long as
customers' threads still exist). You must ensure that no deadlock occurs in your software.
For the implementation, you will use the following parameters :
| StockInit=6
| StockMax=10
| UBound=8
| LBound=2
| NbStations=5
| NbCustomers = 100


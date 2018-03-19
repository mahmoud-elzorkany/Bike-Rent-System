import java.util.Random;

public class Customer extends Thread {

    Stations[] stations;

    int name;
    int Starts;
    int Ends;
    static int NbCustomers=100;

    //customer constructor
    //adding a stations refrence to select a start and an end station
    Customer(Stations[] stations)
    {

        this.stations=stations;

    }//customer

    Customer()
    {

    }

    //initializing customers
    public static Customer[] InitializeCustomer(Stations[] stations, int number)
    {
        Customer[] customers=new Customer[number];

        for (int i=0;i<number;i++)
        {
            customers[i]=new Customer(stations);
            customers[i].name=i;
        }//for

        return customers;

    }//constructor


    //customer thread
    @Override
    public void run() {

        //asigning a rent and a return station to a customer randomly
        Random random=new Random();
        Starts=random.nextInt(stations.length);
        Ends=random.nextInt(stations.length);

        //ensuring that the start and the end stations are not the same
        while(Starts==Ends)
        {
            Ends=random.nextInt(stations.length);

        }//while

        stations[Starts].burrow(stations[Starts]);
        System.out.println();
        try {

            Thread.sleep(Math.abs(Ends - Starts));

        }

        catch (InterruptedException e)
        {

        }

        stations[Ends].Return(stations[Ends]);
        System.out.println();
        NbCustomers--;
        System.out.println(" number of customers are "+ NbCustomers);

    }//customer thread
}

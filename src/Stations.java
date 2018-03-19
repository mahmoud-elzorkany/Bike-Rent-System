public class Stations {

    int name;
    final int StockInit;
    int Nbbikes;
    final int Stockmax;
    final int UBound;
    final int LBound;
    boolean occupied;


   //constructor
    public Stations(int name)
    {
        this.name=name;
        StockInit=6;
        Nbbikes=StockInit;
        Stockmax=10;
        UBound=8;
        LBound=2;
        occupied=false;

    }//constructor

    //static method to intialize a number of stations according to the provided parameter
    public static Stations[] InitializeStation(int number)
    {
        Stations[] station= new Stations[number];

        for(int i=0;i<number;i++)
        {
            station[i]=new Stations(i);
            //System.out.println(i);
        }

        return station;
    }//constructor

    //custmer burrow method
    public synchronized void burrow(Stations station)
    {
        while (station.Nbbikes<=0)
        {
            //System.out.println("customer "+id+" is waiting for a bike");
            try {
                wait();
            }

            catch (InterruptedException e)
            {

            }
        }//while

       // System.out.println("customer "+id+" is renting a bike from "+station.name);
        --station.Nbbikes;
        if(station.Nbbikes<station.LBound)
        {
            //System.out.println("station "+station.name+" has reached the lower bound "+station.Nbbikes);
        }
       System.out.println("station "+station.name+" has "+station.Nbbikes+" bikes"+" burrow");
        notify();

    }//burrow method


    //return method
    public synchronized  void Return(Stations station)
    {
        while (station.Nbbikes==station.Stockmax)
        {
            //System.out.println("customer "+id+ " is waiting to return the bike");
            try {
                wait();
            }

            catch (InterruptedException e)
            {

            }

        }//while

       // System.out.println("customer "+id +" is returning a bike to station "+station.name);
        ++station.Nbbikes;
        if(station.Nbbikes>station.UBound){
        // System.out.println(" station "+station.name+" has reached the upper bound "+station.Nbbikes);
        }
            System.out.println("Station "+station.name+" has "+station.Nbbikes+" bikes"+" return");
        notify();

    }//return method


    public synchronized void Remove(Stations station, Truck truck)
    {

        int bikes;
        System.out.println(" Truck is in station "+station.name);
        bikes=station.Nbbikes-station.StockInit;
        truck.Nbbikes+= bikes;
        station.Nbbikes=station.StockInit;
        System.out.println(" Truck Removed "+bikes+" bikes "+"station "+station.name+" has "+station.Nbbikes+" bikes");
        notify();
    }


    public synchronized void Load(Stations station, Truck truck)
    {
        int bikes;
        System.out.println(" Truck is in station "+station.name);
        bikes=station.StockInit-station.Nbbikes;
        if(truck.Nbbikes>=bikes)
        {
            station.Nbbikes+=bikes;
            System.out.println(" Truck added "+bikes+" bikes "+"station "+station.name+" has "+station.Nbbikes+" bikes");
        }

        else if(truck.Nbbikes<bikes)
        {
            station.Nbbikes+= truck.Nbbikes;
            System.out.println(" Truck added "+truck.Nbbikes+" bikes "+"station "+station.name+" has "+station.Nbbikes+" bikes");
        }
        notify();
    }


    //main
    public static void main(String[] args)
    {

        Stations [] stations=Stations.InitializeStation(5);
        Customer [] customer=Customer.InitializeCustomer(stations,100);
        Truck truck=new Truck(stations);
        //truck.setPriority(Thread.MAX_PRIORITY);
        truck.start();

        for (int i=0;i<100;i++)
        {
            customer[i].start();



        }



    }

}//main

public class Truck extends Thread {

    Stations[] stations;
    Customer customer;
    int Nbbikes;

     Truck(Stations[] stations)
    {
        this.stations=stations;
        customer=new Customer();
        Nbbikes=10;
    }

    @Override
    public void run() {

         int counter=0;

        while(customer.NbCustomers!=0)
        {

            counter ++;
            System.out.println("truck started"+ " iteration "+ counter);
            for(int i=0;i<stations.length;i++)
            {
                if(stations[i].Nbbikes> stations[i].UBound)
                {

                    System.out.println("truck is at station "+ i);
                    stations[i].Remove(stations[i], this);
                    System.out.println();

                }//if

                else if(stations[i].Nbbikes<stations[i].LBound)
                {
                    stations[i].Load(stations[i],this);
                    System.out.println();

                }//elseif

              /*  try {
                    Thread.sleep(50);
                }

                catch (InterruptedException e)
                {

                }*/

            }//for

        }//while

    }//run

}//truck class

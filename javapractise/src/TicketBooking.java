public class TicketBooking implements Runnable{
    @Override
    public void run(){
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("State of booking thread while main thread is waiting "  + TicketSystem.mainThread.getState());
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

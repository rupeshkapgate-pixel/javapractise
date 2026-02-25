import java.sql.SQLOutput;

public class TicketSystem implements Runnable  {
    public static  Thread mainThread;
    public static TicketSystem ticketSystem;

    @Override
    public void run(){
        TicketBooking booking = new TicketBooking();
        Thread bookingThread = new Thread(booking);
        System.out.println("State after creating bookingThread: " + bookingThread.getState());

        bookingThread.start();;
        System.out.println("State after starting bookingThread: " + bookingThread.getState());
        try{
            bookingThread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ticketSystem = new TicketSystem();
        mainThread = new Thread(ticketSystem);
        System.out.println("State after creating mainThread: " + mainThread.getState());
        mainThread.start();
        System.out.println("State after starting mainThread: " + mainThread.getState());
    }
}

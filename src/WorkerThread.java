class WorkerThread implements Runnable {
    private String message;

    public WorkerThread(String s){
        this.message=s;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+" (Start) message = "+message);
        try {
            processmessage();//call processmessage method that sleeps the thread for 2 seconds
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(Thread.currentThread().getName()+" (End)");//prints thread name
    }

    private void processmessage() throws Exception{
        try {
            Httpcalls googleCall = new Httpcalls();
            googleCall.sendGet();
            Thread.sleep(2000);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}

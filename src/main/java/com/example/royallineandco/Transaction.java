package com.example.royallineandco;

public class Transaction implements Comparable<Transaction>  {

    /***
     * Timer that transaction initialized
     */
    long timer;

    /***
     * ID of the transaction
     */
    String id;

    /***
     * Tier of the user for this transaction
     */
    String tier;

    /***
     * The starting time of this transaction
     */
    Long stime;

    /***
     * Initialize the transaction
     * @param timer the timer of the transaction
     * @param id ID of this transaction
     * @param tier Tier of the user for this transaction
     */
    public Transaction(long timer, String id, String tier) {
        this.timer = timer;
        this.id = id;
        this.tier = tier;
        getStartingTime();
    }

    /***
     * Get the starting time of transaction
     * @return starting time of transaction
     */
    public Long getSTime() {
        return stime;
    }

    /***
     * Get the time of transaction
     * @return time of transaction
     */
    public Long getTimer() {
        return timer;
    }

    /***
     * return the starting time based on the tier
     */
    public void getStartingTime() {
        switch (tier) {
            case "PLATINUM":
                stime = timer - 3000;
                break;
            case "GOLD":
                stime = timer - 2000;
                break;
            case "SILVER":
                stime = timer - 1000;
                break;
            case "BRONZE":
                stime = timer;
                break;
        }
    }

    /***
     * Compare the starting time for the transaction and timer if the starting time is the same
     * @param o1 the object to be compared.
     * @return integer to show which object first
     */
    @Override
    public int compareTo(Transaction o1) {
        if(this.getSTime().compareTo(o1.getSTime())== 0){
            return this.getTimer().compareTo(o1.getTimer());
        }else{
            return this.getSTime().compareTo(o1.getSTime());
        }
    }

    /***
     * Print ID of the transaction
     * @return
     */
    @Override
    public String toString() {
        return id + " ";
    }
}


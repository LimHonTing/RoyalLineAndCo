package com.example.royallineandco;

public class Transaction implements Comparable<Transaction>  {
    long timer;
    String id;
    String tier;
    Long stime;

    public Transaction(long timer, String id, String tier) {
        this.timer = timer;
        this.id = id;
        this.tier = tier;
        getStartingTime();
    }

    public Long getSTime() {
        return stime;
    }

    public Long getTimer() {
        return timer;
    }

    public String getId() {
        return id;
    }

    public String getTier() {
        return tier;
    }

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

    @Override
    public int compareTo(Transaction o1) {
        if(this.getSTime().compareTo(o1.getSTime())== 0){
            return this.getTimer().compareTo(o1.getTimer());
        }else{
            return this.getSTime().compareTo(o1.getSTime());
        }
    }

    @Override
    public String toString() {
        return id + " ";
    }
}


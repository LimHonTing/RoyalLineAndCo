package com.example.royallineandco;

import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Payment {
    public static void main(String[] args) {
        PriorityQueue<Transaction> q = new PriorityQueue<>();
        String transaction;
        String[] details;
        long timer;
        String id;
        String tier;
        int digit1=0;
        long timer1;
        int digit2;
        long timer2;
        int digit3=0;

        Scanner in = new Scanner(System.in);

        while (true) {
            transaction = in.nextLine();
            if (transaction.equals("EXIT")) {
                break;
            }
            if (transaction.equals("REBOOT")) {
                q.clear();
                continue;
            }
            details = transaction.split(" ");
            timer = Long.valueOf(details[0]);
            id = details[1];
            tier = details[2];
            Transaction t1 = new Transaction(timer, id, tier);
            if (q.peek() != null && digit3 < digit1) {
                timer1 = q.peek().getTimer();
                digit1 = (int) (timer1 % 10000 / 1000);
            }
            q.offer(new Transaction(timer, id, tier));
            timer2 = t1.getTimer();
            if(timer2 %1000 ==0){
                digit2 = digit1;
            }else{
                digit2 = (int) (timer2 % 10000 / 1000);
            }
            while (q.size() == 1) {
                timer1 = timer2;
                digit1 = (int) (timer1 % 10000 / 1000);
                break;
            }
            String ans = "";
            if (digit2 != digit1) {
                int size = q.size();
                if(size<100){
                    while(!q.isEmpty()){
                        Transaction t = q.poll();
                        ans = ans + t;
                    }
                }else {
                    for (int i = 0; i < 100; i++) {
                        if (!q.isEmpty()) {
                            Transaction t = q.poll();
                            ans = ans + t;
                        }
                    }
                }
                System.out.println(ans);
            }
            digit1 = digit3 = digit2;
        }
    }
}
package com.example.royallineandco;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HistogramDatabase {
    private String jdbcURL = "jdbc:mysql://localhost:3306/histogram";
    private String username = "root";
    private String password = "Lhtmilk2027";
    private ArrayList<Double> dataPoints = new ArrayList<>();
    private int bin,data;
    private ArrayList<Double> cutsoffs = new ArrayList<>();
    private ArrayList<Integer> dataInRange = new ArrayList<>();

    public void retrieveNumberOfData(){
        try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);

            String sql = "SELECT numberdata, bins FROM histogramdata";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            if(result.next()) {
                data = result.getInt("numberdata");
                bin = result.getInt("bins");
            }
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }


    public void retrieveData(){
        try{
            Connection connection = DriverManager.getConnection(jdbcURL,username,password);

            String sql = "SELECT data FROM histogramdata";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while(result.next()){
                double data = result.getInt("data");
                dataPoints.add(data);
            }
            Collections.sort(dataPoints);
            connection.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public double[] getData(){
        double[] datapoint = new double[dataPoints.size()];
        for(int i=0;i<dataPoints.size();i++) {
            datapoint[i] = dataPoints.get(i);
        }
        return datapoint;
    }

    public int getBin(){
        return bin;
    }

//    public ArrayList<Integer> getCutsoffs(){
//        double min = dataPoints.get(0);
//        double max = dataPoints.get(dataPoints.size()-1);
//        double interval = (max-min)/bin;
//        double temp = min;
//        for(int i=0;i<bin;i++){
//            cutsoffs.add(temp);
//            temp += interval;
//        }
//        return cutsoffs;
//    }

//    public ArrayList<Integer> getDataInRange(){
//        int temp = 1;
//        int k = cutsoffs.get(temp);
//        int counter = 0;
//        for (int i = 0; i < dataPoints.size(); i++) {
//            if (dataPoints.get(i) < k) {
//                counter++;
//            } else {
//                temp++;
//                if (temp == cutsoffs.size()) {
//                    dataInRange.add(++counter);
//                    break;
//                }
//                dataInRange.add(counter);
//                counter = 1;
//                k = cutsoffs.get(temp);
//            }
//        }
//        return dataInRange;
//    }
}

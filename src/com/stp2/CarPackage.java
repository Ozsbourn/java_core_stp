package com.stp2;

import javax.annotation.processing.FilerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class CarPackage {

    final private HashMap<String, ArrayList<String>> map;

    public CarPackage(){
        map = new HashMap<String, ArrayList<String>>();
    }

    public void addCar(String name, String... params){
        ArrayList<String> parameters = new ArrayList<>();

        for (Integer i = 0x1; i < params.length; i++) {
            parameters.add(params[i]);
        }

        map.put(name, parameters);
    }

    public boolean modifyCar(String name, String oldValue, String newValue){
        ArrayList<String> i = map.get(name);

        Integer j;
        if ((j = i.indexOf(oldValue)) != -1) {
            i.set(j, newValue);
            return true;
        }

        return false;
    }

    public void showCarPackage(){
        for (Map.Entry<String, ArrayList<String>> pair : map.entrySet()) {
            System.out.print(pair.getKey());
            System.out.println(pair.getValue());
        }
    }

    public boolean deleteCar(String name){
        if (map.containsKey(name)) {
            map.remove(name);
            return true;
        }

        return false;
    }

    public void writeToFile(){
        try (FileWriter writter = new FileWriter("_ae.txt", false)) {
            for (Map.Entry<String, ArrayList<String>> pair : map.entrySet()) {
                writter.write(pair.getKey());
                writter.append(' ');

                for (String str : pair.getValue()) {
                    writter.write(str + " ");
                }
                writter.append('\n');

                writter.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFromFile(){
        try (BufferedReader reader = new BufferedReader(new FileReader("_ae.txt"))) {
            Integer c;
            String buf = new String();

            while (true) {
                if ((buf = reader.readLine()) == null) {
                    return;
                }

                String[] str = buf.split(" ");
                String[] str2 = new String[str.length - 0x1];
                for (Integer i = 0x1; i < str.length; i++) {
                    str2[i - 0x1] = str[i];
                }

                this.addCar(str[0x0], str2);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
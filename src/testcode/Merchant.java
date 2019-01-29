/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcode;

import java.util.*;
import javafx.util.Pair;

/**
 *
 * @author ricky
 */
public class Merchant {

    HashMap<String, Integer> data = new HashMap<String, Integer>();
    HashMap<String, Double> MineralPrice = new HashMap<String, Double>();

    public HashMap<String, Integer> Roman;

    {
        Roman = new HashMap<>();
        Roman.put("I", 1);
        Roman.put("V", 5);
        Roman.put("X", 10);
        Roman.put("L", 50);
        Roman.put("C", 100);
        Roman.put("D", 500);
        Roman.put("M", 1000);

    }

    public void process(String text) {

        String str[] = text.split(" ");
        String temp = str[str.length - 1];

        //Check Symbol Value
        if ((Roman.containsKey(temp)) && (str[str.length - 2].equals("is"))) {
            data.put(str[0], Roman.get(temp));
            //     System.out.println(data.entrySet());
        } //Check Metals Credits
        else if ((temp.equals("Credits") && (str[str.length - 3].equals("is")))) {

            Double credits = Double.valueOf(str[str.length - 2]);//Nilai Credits
            int countIterasi = 0;
            Double countSumData = 0.0;
            String check = str[countIterasi];
            Boolean condition = true;
            int valueBefore = 0;
            while (!check.equals("Silver") && !check.equals("Gold") && !check.equals("Iron")) {

                if (data.containsKey(check)) {
                    if (valueBefore == 0) {
                        valueBefore = data.get(check);
                        countIterasi++;
                        countSumData += data.get(check);
                    } else {
                        if (valueBefore < data.get(check)) {
                            countSumData = Double.valueOf(data.get(check) - valueBefore);
                            valueBefore = data.get(check);
                            countIterasi++;

                        } else {
                            valueBefore = data.get(check);
                            countSumData += data.get(check);
                            countIterasi++;
                        }
                    }

                } else {
                    condition = false;
                    System.out.println("I have no idea what you are talking about");
                    break;
                }
                check = str[countIterasi];
            }
            if (condition == true) {
                MineralPrice.put(check, Double.valueOf(credits / countSumData));
                // System.out.println(MineralPrice.entrySet());
            }
        } else if ((temp.equals("?")) && (str[0].equals("how"))) {
            int result = 0;
            String Result = "";
            if (str[1].equals("much")) {
                int n = 3;
                String temp1 = str[n];
                if (!data.containsKey(temp1)) {
                    System.out.println("I have no idea what you are talking about");
                } else {
                    int checkBefore = data.get(temp1);
                    result += data.get(temp1);
                    Result += temp1 + " ";
                    n++;
                    temp1 = str[n];
                    while (data.containsKey(temp1)) {

                        if (checkBefore < data.get(temp1)) {
                            result = data.get(temp1) - result;
                        } else {
                            result += data.get(temp1);
                        }
                        Result += temp1 + " ";
                        n++;
                        temp1 = str[n];
                    }
                    while (data.containsKey(temp1)) {
                        result += data.get(temp1);
                        Result += temp1 + " ";
                        n++;
                        temp1 = str[n];
                    }

                    Result += "is " + result;
                    System.out.println(Result);
                }
            } else if (str[1].equals("many")) {
                int n = 4;
                String temp1 = str[n];
                String ore = str[str.length - 2];

                if (!data.containsKey(temp1)) {
                    System.out.println("I have no idea what you are talking about");
                } else {
                    int checkBefore = data.get(temp1);
                    result += data.get(temp1);
                    Result += temp1 + " ";
                    n++;
                    temp1 = str[n];
                    while (data.containsKey(temp1)) {

                        if (checkBefore < data.get(temp1)) {
                            result = data.get(temp1) - result;
                        } else {
                            result += data.get(temp1);
                        }
                        Result += temp1 + " ";
                        n++;
                        temp1 = str[n];
                    }
                    result *= MineralPrice.get(ore);
                    Result += ore + " is " + result + " Credits";
                    System.out.println(Result);
                }
            }

        } else {
            System.out.println("I have no idea what you are talking about");

        }

    }

    public boolean checkCondition(String roman) {
        ArrayList<String> I = new ArrayList<String>();
        ArrayList<String> X = new ArrayList<String>();
        ArrayList<String> neverSubs = new ArrayList<String>();

        I.add("V");
        I.add("X");
        X.add("L");
        X.add("C");
        neverSubs.add("V");
        neverSubs.add("L");
        neverSubs.add("D");
        
        boolean result = true;
        char temp =roman.charAt(0);
        
        for(int i=1;i<roman.length();i++)
        {
          //  if(temp)
        }
        
        return result;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testcode;

import java.util.*;

/**
 *
 * @author ricky
 */
public class TestCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Merchant proses = new Merchant();
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (input != "end") {
            input = sc.nextLine();
            proses.process(input);

        }

    }

}

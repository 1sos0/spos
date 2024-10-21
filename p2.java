// Program to implement Pass-2 assembler.

import java.io.*;
import java.util.*;

class p2 {
    public static void main(String args[]) throws Exception {

        String s;
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> s3 = new ArrayList<>();

        FileWriter f1 = new FileWriter("output2.txt");
        BufferedWriter b1 = new BufferedWriter(f1);

        FileReader f2 = new FileReader("intermediate.txt");
        BufferedReader b2 = new BufferedReader(f2);

        FileReader f3 = new FileReader("symboltab.txt");
        BufferedReader b3 = new BufferedReader(f3);

        FileReader f4 = new FileReader("literaltab.txt");
        BufferedReader b4 = new BufferedReader(f4);

        while ((s = b2.readLine()) != null) {
            s1.clear(); // Clear previous values
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                s1.add(st.nextToken());
            }
            // Process tokens in s1 as needed
        }

        while ((s = b3.readLine()) != null) {
            s2.clear(); // Clear previous values
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                s2.add(st.nextToken());
            }
            // Process tokens in s2 as needed
        }

        while ((s = b4.readLine()) != null) {
            s3.clear(); // Clear previous values
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                s3.add(st.nextToken());
            }
            // Process tokens in s3 as needed
        }

        // Add the rest of the processing logic here

        b1.close();
        b2.close();
        b3.close();
        b4.close();
    }
}

// Input Files:

// intermedi1.txt
// AD 01 C 100
// 100       IS     05     R1  L  1

// 101       IS     06     R2 S  1

// 102       IS     03     R1  L  2

// 103       AD     04     R1  L  2

// 104       IS     06     R1 S  1

// 105  

// 106       IS     02

// 107       DL     01

// 108       DL     02

// 109  AD 02 C 1

// 110  AD 02 C 2

// symbol2.txt
// L1 100
//  X 107
//  Y 108

// literal2.txt
// 1 =7
//  2 =2

// *************************************OUTPUT********************************

// output3.txt
// 100	05	R1 	2
// 101	06	R2 
// 102	03	R1 	null
// 	R1 	null
// 104	06	R1 
// 106	02
// 107	-	-	00DL
// 109	-	-	001
// 110	-	-	002

// This code is contributed by Prof. Anand Gharu
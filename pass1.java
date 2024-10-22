package pass1;
// Program to implement Pass-1 assembler.

import java.io.*;
import java.util.*;

class p1{
public static void main(String args[])throws Exception
{
int loc=0,loc1=0;
int j=0,k,sym=0,lit=0,v=0,w=0;

FileReader f1=new FileReader("in.txt");
BufferedReader b1=new BufferedReader(f1);

FileWriter f3=new FileWriter("symboltab.txt");
BufferedWriter b3=new BufferedWriter(f3);

FileWriter f4=new FileWriter("intermediate.txt");
BufferedWriter  b4=new BufferedWriter(f4);

FileWriter f5=new FileWriter("literaltab.txt");
BufferedWriter b5=new BufferedWriter(f5);

StringBuffer sb = new StringBuffer();
String s,s3,s4,tmp,sd,sl;
String s1[]=new String[4];
String s2[]=new String[4];
String s5[][]=new String[4][2];
while((s=b1.readLine())!=null)
{
	int flag=0;
	int m=0;
	StringTokenizer st=new StringTokenizer(s);
	while(st.hasMoreTokens())
	{
	s1[m]=st.nextToken();
	m++;
	}
	if(s1[1].equals("START"))
	{
		b4.write("AD 01");		
		b4.write(" C "+s1[2]);		
		loc=Integer.parseInt(s1[2]);
		b4.newLine();
	}
	else if(s1[1].equals("END"))
	{
		for(int i=1;i<=lit;i++)
		{
		b4.write(loc+"  ");
		b4.write("AD 02");
				
		b4.write(" C "+i);		
		loc=loc+1;
		b4.newLine();
	}
	}
	else
	{
		b4.write(loc+"  ");
		if(s1[0].equals("-")!=true)
		{
		sym++;
		b3.write(" "+s1[0]);
		b3.write(" "+loc+" ");
		}
FileReader f2=new FileReader("op.txt");
BufferedReader b2=new BufferedReader(f2);
		while((sl=b2.readLine())!=null)
		{
			j=0;
			StringTokenizer se=new StringTokenizer(sl);
			while(se.hasMoreTokens())
			{
				s2[j]=se.nextToken();
				j++;
			}
			if(s1[1].equals(s2[0])==true)
			{
				for(int a=1;a<3;a++)
				{
					b4.write("  ");
					b4.write("   "+s2[a]);
				}
			}
			if(s1[2].equals(s2[0])==true)
			{
				for(int a=1;a<2;a++)
				{
					b4.write("  ");
					b4.write("   "+s2[a]);
				}
			}
					
		}
		if(s1[3].contains("="))
			{
int i;flag=0;
for( i=0;i<lit;i++)
{
if(s5[i][1].equals(s1[3]))
{flag=1;
break;}
}
if(flag!=1)
{
				lit++;
s5[v][0]=Integer.toString(lit);
s5[v][1]=s1[3];
v++;
				b5.newLine();
				b5.write(" "+lit);
				b5.write(" "+s1[3]);
				//b6.write(" "+loc1+" ");
				b4.write(" ");
				b4.write(" "+"L  "+lit);
}
else
{
b4.write(" ");
b4.write(" "+"L  "+s5[i][0]);
}
				
			}

			else if((s1[3]).matches("[a-zA-Z]"))
			{
				//b4.write(" ");
				b4.write(" "+"S  "+sym);	
				
			}
		loc=loc+1;

		b4.newLine();
		
		b4.newLine();
		b3.newLine();

	}
			
}
b4.close();
b3.close();
b5.close();
}
}

/*
Initialize loc, loc1, sym, lit, v, w to 0
Open in.txt for reading
Open symboltab.txt, intermediate.txt, literaltab.txt for writing

While there are more lines in in.txt:
    Read line into s
    Split s into tokens and store in s1

    If s1[1] is "START":
        Write "AD 01" and s1[2] to intermediate.txt
        Set loc to s1[2]
    Else if s1[1] is "END":
        For each literal:
            Write loc and "AD 02" to intermediate.txt
            Write literal number to intermediate.txt
            Increment loc
    Else:
        Write loc to intermediate.txt
        If s1[0] is not "-":
            Increment sym
            Write s1[0] and loc to symboltab.txt
        Open op.txt for reading
        While there are more lines in op.txt:
            Read line into sl
            Split sl into tokens and store in s2
            If s1[1] matches s2[0]:
                Write corresponding operation code to intermediate.txt
            If s1[2] matches s2[0]:
                Write corresponding operation code to intermediate.txt
        If s1[3] contains "=":
            Check if literal is in literal table:
                If not, add to literal table and write to literaltab.txt
                Write literal reference to intermediate.txt
            Else, write existing literal reference to intermediate.txt
        Else if s1[3] is a symbol:
            Write symbol reference to intermediate.txt
        Increment loc
        Write new line to intermediate.txt and symboltab.txt

Close intermediate.txt
Close symboltab.txt
Close literaltab.txt
 */


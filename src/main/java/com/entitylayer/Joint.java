package com.entitylayer;
import java.io.IOException;
import com.servicelayer.TaxComputation;

public class Joint {

	public static long compute(long salary,String type) throws IOException
	{
	    //System.out.print(status);
		int percent[]=new int[7];
		percent[0]=10;
		percent[1]=12;
		percent[2]=22;
		percent[3]=24;
		percent[4]=32;
		percent[5]=35;
		percent[6]=37;
		long cap[]=new long[6];
		cap[0]=19900;
		cap[1]=81050;
		cap[2]=172750;
		cap[3]=329850;
		cap[4]=418850;
		cap[5]=628300;
		long tax=0;
		//System.out.print(salary+" "+2+"\n");
		tax=TaxComputation.compute(salary, percent, cap);	
		return tax;	

	}

}
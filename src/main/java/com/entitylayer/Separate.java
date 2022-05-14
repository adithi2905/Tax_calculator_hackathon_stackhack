package com.entitylayer;

import java.io.IOException;

import com.servicelayer.TaxComputation;

public class Separate {

	public static long compute(long salary,String type) throws IOException
	{
	    //System.out.print(status);
		int percent[]=new int[7];
		int stdamount;
		
		percent[0]=10;
		percent[1]=12;
		percent[2]=22;
		percent[3]=24;
		percent[4]=32;
		percent[5]=35;
		percent[6]=37;
		long cap[]=new long[6];
		cap[0]=9950;
		cap[1]=40525;
		cap[2]=86375;
		cap[3]=164925;
		cap[4]=209425;
		cap[5]=314150;
		//if(type.equalsIgnoreCase("Standardised"))
		long tax=0;
		tax=TaxComputation.compute(salary, percent, cap);
		return tax;
	}
}
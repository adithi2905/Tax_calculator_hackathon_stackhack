package com.entitylayer;

import java.io.IOException;

import com.servicelayer.TaxComputation;


public class Head {
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
		cap[0]=14200;
		cap[1]=54200;
		cap[2]=86350;
		cap[3]=164900;
		cap[4]=209400;
		cap[5]=523600;
		System.out.print(salary);
		long tax=0;
		tax=TaxComputation.compute(salary, percent, cap);
		return tax;
			
		

	}
	}



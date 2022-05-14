package com.servicelayer;

public class TaxComputation {
	 public static long compute(long salary,int[]percent,long[]cap)
	 {

			long tax=0;
			int i=0;
			while(salary>0)
			{
				
				System.out.print(salary+" ");
				if(salary>cap[i]) {
					salary-=cap[i];
					tax+=(cap[i]*percent[i])/100;
				}
				else if((salary<=cap[i]))
				{
					tax+=(salary*percent[i])/100;
					salary-=cap[i];
				}
				else if(i==6)
				{
				tax+=(salary*percent[i]/100);
				break;
				}
				i+=1;
			}
			return tax;
	 }
	
}	
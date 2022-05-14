package com.servicelayer;

import java.io.IOException;

import com.entitylayer.Head;
import com.entitylayer.Joint;
import com.entitylayer.Separate;
import com.entitylayer.Single;

public class StatusImplementation implements StatusInterface {

	@Override
	public long computePercentageAndCap(long salary, String status,String type) throws IOException {
		// TODO Auto-generated method stub
		long tax=0;
		if(status.equalsIgnoreCase("Single"))
			tax=Single.compute(salary,type);
		else if(status.equalsIgnoreCase("Joint"))
			tax=Joint.compute(salary,type);
		else if(status.equalsIgnoreCase("Separate"))
			tax=Separate.compute(salary,type);
		else
			tax=Head.compute(salary,type);
		return tax;
		
		
		
	}

}
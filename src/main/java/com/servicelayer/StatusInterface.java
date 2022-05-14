package com.servicelayer;

import java.io.IOException;

public interface StatusInterface {
	public long computePercentageAndCap(long salary,String status,String type) throws IOException;

}
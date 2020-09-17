package com.nt.experiments;

public class ExperimentsForTwo_ExpectedAnd_Timeout{ 

	
	//method-1
    public Integer div(Integer a, Integer b) {
    	return a/b;
    }

    
    
	//method-2
    public String time() {

    	// any b.logic
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	return null;
    }
}

package com.travels.newtours.test.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailRetry implements IRetryAnalyzer{

	int min =0;
	int max =2;
	
	
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(min<max){
			min++;
			return true;
		}
		return false;
	}
	}
	
	




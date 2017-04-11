package server;

import IdljTest.GoldbashPOA;

public class IdljTestImpl extends GoldbashPOA{
	public String checkNum(float a) {

		for(int i=2;i<(a/2+1);i++){
//			System.out.println(i);
			if(isPrimeNum(i)&&isPrimeNum(a-i)){
				return "the two number "+ (i-0.0) +" and "+(a-i);
			}
		}
		return 2333333+"";
	
	}
	
	
  public Boolean isPrimeNum(float num){
		
		for(int i=2;i<(num/2+1);i++){
			if(num%i==0){
			  return false;
			}
		}
		return true;
	}
}

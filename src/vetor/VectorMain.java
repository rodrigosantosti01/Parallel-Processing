package vetor;

import java.util.Arrays;
import java.util.Vector;

public class VectorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<Integer> vec = new Vector<Integer>();		
		Integer result;

		
		//	preenche o vetor principal
		for (int i = 0; i<10000;i++ ) {
			vec.add(i);
		}
		
		// Paralelo
		CalculaVector calcula1 = new CalculaVector(vec,"thread1: ",0,2500);
		CalculaVector calcula2 = new CalculaVector(vec,"thread2: ",2500,5000);
		CalculaVector calcula3 = new CalculaVector(vec,"thread3: ",5000,7500);
		CalculaVector calcula4 = new CalculaVector(vec,"thread4: ",7500,10000);
		
	
		Thread thread1 = new Thread(calcula1);
		Thread thread2 = new Thread(calcula2);
		Thread thread3 = new Thread(calcula3);
		Thread thread4 = new Thread(calcula4);
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		
		 try {
	            thread1.join();
	            thread2.join();
	            thread3.join();
		        thread4.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		 
		 result = calcula1.getResult() + calcula2.getResult() + calcula3.getResult() + calcula4.getResult() ;
		 System.out.println("Resultado do paralelo: "+ result);
		 
		 
		//	sequencial
		CalculaVector sequencial = new CalculaVector(vec,"sequencial",0,10000);
		sequencial.run();
		
		System.out.println("Resultado do sequencial: "+ sequencial.getResult());
	}	
	

}

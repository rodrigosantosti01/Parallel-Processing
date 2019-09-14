//fazer um programa paralelo que calcule a expressão abaixo:
//y = 3x^4 + 10x^3 -5x^2 + 7x + 10;
//a) Fazer uma solução sequencial
//b) Fazer uma solução paralela, onde cada parcela seja uma Thread


import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.script.ScriptException;

public class Main {
	
    public static void main(String[] args) throws ScriptException, InterruptedException {
    	 	
        	for (double x = 1.0; x<2.0;x++) {
//        	b) 
        			paralela(x);
//			a)
        			sequencial(x);
       }        
    }

    public static void paralela(double x){
        Double result = 0.0;

//      3x^4
        Calcula funcao = new Calcula(x,4., "Thread 1",3.0);
        Thread thread = new Thread(funcao);
        thread.start();
       

//      10x^3
        Calcula funcao2 = new Calcula(x,3., "Thread 2",10.0);
        Thread thread2 = new Thread(funcao2);
        thread2.start();
        

//      -5x^2
        Calcula funcao3 = new Calcula(x,2., "Thread 3",-5.0);
        Thread thread3 = new Thread(funcao3);
        thread3.start();
        
//      7x
        Calcula funcao4 = new Calcula( 7.0,x, "Thread 4",1.0);
        Thread thread4 = new Thread(funcao4);
        thread4.start();
        
        try {
            thread.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        result += funcao4.getResult() + 10;
        result += funcao.getResult();
	    result += funcao2.getResult();
	    result += funcao3.getResult();

        System.out.println("Resultado Paralela: " + result);

    }


    public static void sequencial(double x){
        Double result = 0.0;

//      3x^4
        Calcula funcao = new Calcula(x,4., "Thread 1",3.);
        funcao.run();
        result += funcao.getResult();


//      10x^3
        Calcula funcao3 = new Calcula(x,3., "Thread 2",10.);
        funcao3.run();
        result += funcao3.getResult();


//      -5x^2
        Calcula funcao5 = new Calcula(x,2., "Thread 3",-5.);
        funcao5.run();
        result += funcao5.getResult();

//      7x
        Calcula funcao7 = new Calcula(7.0,x, "Thread 4",1.);
        funcao7.run();
        result += funcao7.getResult() + 10 ;
        System.out.println("Resultado Sequencial: " + result);
    }

}
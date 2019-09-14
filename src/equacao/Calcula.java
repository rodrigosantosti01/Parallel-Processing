import javax.xml.ws.handler.Handler;

public class Calcula extends Thread{

    private Double numberA, numberB, result,fator;
    private String name;

    public Calcula(Double numberA, Double numberB, String name,Double fator){
        this.numberA = numberA;
        this.numberB = numberB;
        this.name = name;
        this.fator = fator;
    }

    private Double exponentiation(Double a, double b,double fator ){
        return Math.pow(a,b) * (fator);
    }

    public Double getResult(){
        return this.result;
    }

    @Override
    public void run() {
    		this.result= exponentiation(this.numberA, this.numberB,this.fator);
        System.out.println(name);
    }
}
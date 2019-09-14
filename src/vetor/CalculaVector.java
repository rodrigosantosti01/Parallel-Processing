package vetor;

import java.util.Vector;

public class CalculaVector extends Thread {
	
	private int result,inicio,fim;
	private Vector<Integer> vetor;
	private String nome;
	
	public CalculaVector(Vector<Integer> vet,String nome,int inicio,int fim) {
		this.vetor=vet;
		this.nome=nome;
		this.inicio=inicio;
		this.fim=fim;
	}
	
	
	public Integer getResult() {
		return this.result;
		
	} 
	
	@Override
	public void run() {
		for (int i=inicio; i<this.fim;i++) {
			this.result = this.result+ this.vetor.get(i); 
		}
		System.out.println(this.nome + this.result);
		
		
	}
}

package swiniak;

public abstract class But {
    
	String model;
	String model2;
	String typObuwia;
	String material;
	String materialPodszewki;
	String kolor;
	String materialPodeszwy;
	int iloscPar;
	
	public But(){
			
	}
	
	public But(String model,String model2,String material,String materialPodszewki,String kolor,String materialPodeszwy,int iloscPar){
		this.model=model;
		this.model2=model2;
		this.material=material;
		this.materialPodszewki=materialPodszewki;
		this.kolor=kolor;
		this.materialPodeszwy=materialPodeszwy;
		this.iloscPar=iloscPar;
	}
	
	
}

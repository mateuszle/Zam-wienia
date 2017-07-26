package swiniak;

public class Botek extends But {
	
	
	public Botek(){
		this.model="nieznany";
		this.model2="nieznany";
		this.material="натуральный велюр";
		this.materialPodszewki="шерстяной мех";
		this.kolor="черный";
		this.materialPodeszwy="полимерный материал";
		this.iloscPar=8;
		this.typObuwia="ботинки женские";
}

public Botek(String model,String model2,String material,String materialPodszewki,String kolor,String materialPodeszwy,int iloscPar){
	super(model,model2,material,materialPodszewki,kolor,materialPodeszwy,iloscPar);
	typObuwia="ботинки женские";
}
}

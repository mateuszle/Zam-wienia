package swiniak;

public class Polbut extends But {

	
	
	public Polbut(){
		this.model="nieznany";
		this.model2="nieznany";
			this.material="нат. Кожа";
			this.materialPodszewki="нат. Кожа";
			this.kolor="черный";
			this.materialPodeszwy="полимерный материал";
			this.iloscPar=8;
			this.typObuwia="туфли женские";
	}
	
	public Polbut(String model,String model2,String material,String materialPodszewki,String kolor,String materialPodeszwy,int iloscPar){
		super(model,model2,material,materialPodszewki,kolor,materialPodeszwy,iloscPar);
		typObuwia="туфли женские";
	}
}

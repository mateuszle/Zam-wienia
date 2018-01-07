package swiniak;

public class Kozak extends But {


	public Kozak(){
		    this.model="342342";
		    this.model2="nieznany";
			this.material="натуральный велюр";
			this.materialPodszewki="шерстяной мех";
			this.kolor="черный";
			this.materialPodeszwy="полимерный материал";
			this.iloscPar=8;
			this.typObuwia="Женские сапоги";
	}
	
	public Kozak(String model,String model2,String material,String materialPodszewki,String kolor,String materialPodeszwy,int iloscPar){
		super(model,model2,material,materialPodszewki,kolor,materialPodeszwy,iloscPar);
		typObuwia="kozak damski/ Женские сапоги";
	}
}

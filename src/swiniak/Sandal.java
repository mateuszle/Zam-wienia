package swiniak;

public class Sandal extends But {

	
	
	public Sandal(){
		    this.model="nieznany";
		    this.model2="nieznany";
			this.material="tekstyl/текстиль";
			this.materialPodszewki="нат. Кожа";
			this.kolor="черный";
			this.materialPodeszwy="полимерный материал";
			this.iloscPar=8;
			this.typObuwia="сандалии";
	}
	
	public Sandal(String model,String model2,String material,String materialPodszewki,String kolor,String materialPodeszwy,int iloscPar){
		super(model,model2,material,materialPodszewki,kolor,materialPodeszwy,iloscPar);
		typObuwia="сандалии";
	}
}

package dependencies;

public class MTLMaterial {
	String name;
	double[] ambientColor = {0.2, 0.2, 0.2};
	double[] diffuseColor = {0.8, 0.8, 0.8};
	double[] specularColor = {1.0, 1.0, 1.0};
	double Ns = 1;
	
	byte illum = 0;
	
	public MTLMaterial(String name) {
		this.name = name;
	}
}

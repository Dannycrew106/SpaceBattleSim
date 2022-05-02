package objects;

public class MTLMaterial {
	double[] ambientColor;
	double[] diffuseColor;
	double[] specularColor;
	
	byte illum = 0;
	
	public MTLMaterial(double[] ka, double[] kd, double[] ks, byte illum) {
		ambientColor = ka;
		diffuseColor = kd;
		specularColor = ks;
		this.illum = illum;
	}
}

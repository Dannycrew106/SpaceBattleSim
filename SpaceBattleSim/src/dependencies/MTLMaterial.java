package dependencies;

import java.awt.Color;

public class MTLMaterial {
	String name;
	float[] ambientColor = {0.2f, 0.2f, 0.2f};
	float[] diffuseColor = {0.8f, 0.8f, 0.8f};
	float[] specularColor = {1.0f, 1.0f, 1.0f};
	double Ns = 1;
	
	byte illum = 0;
	
	public MTLMaterial(String name) {
		this.name = name;
	}
	public Color getBasicColor() {
		//System.out.println("Color " + name + " Requested!");
		return new Color(diffuseColor[0], diffuseColor[1], diffuseColor[2]);
	}
}

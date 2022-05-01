package objects;

public class Quaternion{
	// S is defined as the scalar quantity, while xi,yj,zk are defined as the vector coordinates of the quaternion
	public double s;
	public double xi;
	public double yj;
	public double zk;
	
	public Quaternion(double scalar, double xValue, double yValue, double zValue) {
		s = scalar;
		xi = xValue;
		yj = yValue;
		zk = zValue;
	}
	
	public void multiply(Quaternion secondQuaternion) {
		Quaternion newQuaternion = multiply(this, secondQuaternion);
		s = newQuaternion.s;
		xi = newQuaternion.xi;
		yj = newQuaternion.yj;
		zk = newQuaternion.zk;
	}
	
	public void rotate(Quaternion q, double degrees) {
		degrees /= 2;
		double sinTheta = Math.sin((degrees/360)*(Math.PI*2));
		Quaternion qp = multiply(new Quaternion(Math.cos((degrees/360)*(Math.PI*2)), q.xi*sinTheta, q.yj*sinTheta, q.zk*sinTheta), new Quaternion(0, xi, yj, zk));
		Quaternion finalQuaternion = multiply(qp, new Quaternion(Math.cos((degrees/360)*(Math.PI*2)), -q.xi*sinTheta, -q.yj*sinTheta, -q.zk*sinTheta));
		xi = finalQuaternion.xi;
		yj = finalQuaternion.yj;
		zk = finalQuaternion.zk;
	}
	public void rotate(double xValue, double yValue, double zValue, double degrees) {
		rotate(new Quaternion(0, xValue, yValue, zValue), degrees);
	}
	
	// Static Methods
	public static Quaternion multiply(Quaternion firstQuaternion, Quaternion secondQuaternion) {
		// This looks like a mess, and it absolutely is....
		// Its returning a new quaternion that is the product of the first and second quaternion using the Hamilton Product
		return new Quaternion(((firstQuaternion.s * secondQuaternion.s) - (firstQuaternion.xi * secondQuaternion.xi) - (firstQuaternion.yj * secondQuaternion.yj) - (firstQuaternion.zk * secondQuaternion.zk))
				, ((firstQuaternion.s * secondQuaternion.xi) + (firstQuaternion.xi * secondQuaternion.s) + (firstQuaternion.yj * secondQuaternion.zk) - (firstQuaternion.zk * secondQuaternion.yj))
				, ((firstQuaternion.s * secondQuaternion.yj) + (firstQuaternion.yj * secondQuaternion.s) - (firstQuaternion.xi * secondQuaternion.zk) + (firstQuaternion.zk * secondQuaternion.xi))
				, ((firstQuaternion.s * secondQuaternion.zk) + (firstQuaternion.zk * secondQuaternion.s) + (firstQuaternion.xi * secondQuaternion.yj) - (firstQuaternion.yj * secondQuaternion.xi)));
	}
	
	
}

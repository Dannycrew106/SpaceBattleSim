package dependencies;

public class PureQuaternion {
	public double s;
	public double xi;
	public double yj;
	public double zk;
	
	public PureQuaternion(double scalar, double xValue, double yValue, double zValue) {
		s = scalar;
		xi = xValue;
		yj = yValue;
		zk = zValue;
	}
	
	public void multiply(PureQuaternion secondQuaternion) {
		PureQuaternion newQuaternion = multiply(this, secondQuaternion);
		s = newQuaternion.s;
		xi = newQuaternion.xi;
		yj = newQuaternion.yj;
		zk = newQuaternion.zk;
	}
	
	public void rotate(PureQuaternion q, double degrees) {
		degrees /= 2;
		double sinTheta = Math.sin((degrees/360)*(Math.PI*2));
		PureQuaternion qp = multiply(new PureQuaternion(Math.cos((degrees/360)*(Math.PI*2)), q.xi*sinTheta, q.yj*sinTheta, q.zk*sinTheta), new PureQuaternion(s, xi, yj, zk));
		PureQuaternion finalQuaternion = multiply(qp, new PureQuaternion(Math.cos((degrees/360)*(Math.PI*2)), -q.xi*sinTheta, -q.yj*sinTheta, -q.zk*sinTheta));
		s = finalQuaternion.s;
		xi = finalQuaternion.xi;
		yj = finalQuaternion.yj;
		zk = finalQuaternion.zk;
	}
	public void rotate(double xValue, double yValue, double zValue, double degrees) {
		rotate(new PureQuaternion(1, xValue, yValue, zValue), degrees);
	}
	public String toString() {
		return "S: " + s + " Xi: " + xi + " Yj: " + yj + "Zk:" + zk;
	}
	
	// Static Methods
	public static PureQuaternion multiply(PureQuaternion firstQuaternion, PureQuaternion secondQuaternion) {
		// This looks like a mess, and it absolutely is....
		// Its returning a new quaternion that is the product of the first and second quaternion using the Hamilton Product
		return new PureQuaternion(((firstQuaternion.s * secondQuaternion.s) - (firstQuaternion.xi * secondQuaternion.xi) - (firstQuaternion.yj * secondQuaternion.yj) - (firstQuaternion.zk * secondQuaternion.zk))
				, ((firstQuaternion.s * secondQuaternion.xi) + (firstQuaternion.xi * secondQuaternion.s) + (firstQuaternion.yj * secondQuaternion.zk) - (firstQuaternion.zk * secondQuaternion.yj))
				, ((firstQuaternion.s * secondQuaternion.yj) + (firstQuaternion.yj * secondQuaternion.s) - (firstQuaternion.xi * secondQuaternion.zk) + (firstQuaternion.zk * secondQuaternion.xi))
				, ((firstQuaternion.s * secondQuaternion.zk) + (firstQuaternion.zk * secondQuaternion.s) + (firstQuaternion.xi * secondQuaternion.yj) - (firstQuaternion.yj * secondQuaternion.xi)));
	}
}

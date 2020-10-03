// Design 2
public class PointCP4
{
	// Always stores points in polar coordinates.  
	private char typeCoord;
	private double x;
	private double y;
	private double rho;
	private double theta;
	
	// Constructor
	// Takes in either rectangular or polar coordinates. Stores the values in the corresponding variables and converts them to assign to the other type
	PointCP4(char typeCoord, double xOrRho, double yOrTheta)
	{
		if(typeCoord == 'P')
		{
			rho = xOrRho;
			theta = yOrTheta;
			x = xOrRho * Math.cos(Math.toRadians(yOrTheta));
			y = xOrRho * Math.sin(Math.toRadians(yOrTheta));
		}
		else if(typeCoord == 'C')
		{
			x = xOrRho;
			y = yOrTheta;
			rho = Math.sqrt(xOrRho * xOrRho + yOrTheta * yOrTheta);
			theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
		}
		else
		{
			// If not type polar or type cartesian, throw illegal argument exception
			throw new IllegalArgumentException();
		}
		this.typeCoord = 'C';
		
	}

	// Instance methods
	
	// computes and returns value of x
	public double getX()
	{
		return x;
	}

	// computes and returns value of y
	public double getY()
	{
		return y;
	}

	// Directly returns value for rho
	public double getRho()
	{
		return rho;
	}
	
	// Directly returns value for theta
	public double getTheta()
	{
		return theta;
	}
	
	// Returns distance betwen this point and point B
	public double getDistance(PointCP4 pointB)
	{
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	
	/**
	* Copied from PointCP4 class 
	* Rotates the specified point by the specified number of degrees.
	* Not required until E2.30
	*
	* @param point The point to rotate
	* @param rotation The number of degrees to rotate the point.
	* @return The rotated image of the original point.
	*/
	public PointCP4 rotatePoint(double rotation)
	{
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		return new PointCP4('C', (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}
	
	// Returns string representation of PointCP4
	public String toString()
	{
		return "Stored as both rectangular and polar : (" + getX() + "," + getY() + ")"
		   + "Polar [" + getRho() + "," + getTheta() + "]";
	}
}
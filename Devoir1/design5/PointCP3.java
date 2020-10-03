// Design 5(3)
public class PointCP3 extends PointCP5
{
	// Always stores points in polar coordinates.  
	private char typeCoord;
	private double x;
	private double y;
	
	// Constructor
	// If alreadty polar, stores the double values
	// If cartesian, converts and assigns values to rho and theta
	PointCP3(char typeCoord, double xOrRho, double yOrTheta)
	{
		if(typeCoord == 'P')
		{
			x = xOrRho * Math.cos(Math.toRadians(yOrTheta));
			y = xOrRho * Math.sin(Math.toRadians(yOrTheta));
		}
		else if(typeCoord == 'C')
		{
			x = xOrRho;
			y = yOrTheta;
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
		return Math.sqrt(x * x + y * y);
	}
	
	// Directly returns value for theta
	public double getTheta()
	{
		return Math.toDegrees(Math.atan2(y, x));
	}
	
	// Returns distance betwen this point and point B
	public double getDistance(PointCP5 pointB)
	{
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	
	/**
	* Copied from PointCP3 class 
	* Rotates the specified point by the specified number of degrees.
	* Not required until E2.30
	*
	* @param point The point to rotate
	* @param rotation The number of degrees to rotate the point.
	* @return The rotated image of the original point.
	*/
	public PointCP3 rotatePoint(double rotation)
	{
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		return new PointCP3('C', (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}
	
	// Returns string representation of PointCP3
	public String toString()
	{
		return "Stored as Rectangular : (" + getX() + "," + getY() + ")"
		   + "Polar value [" + getRho() + "," + getTheta() + "]";
	}
}
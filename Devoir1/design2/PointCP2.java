// Design 2
public class PointCP2
{
	// Always stores points in polar coordinates.  
	private char typeCoord;
	private double rho;
	private double theta;
	
	// Constructor
	// If alreadty polar, stores the double values
	// If cartesian, converts and assigns values to rho and theta
	PointCP2(char typeCoord, double xOrRho, double yOrTheta)
	{
		if(typeCoord == 'P')
		{
			rho = xOrRho;
			theta = yOrTheta;
		}
		else if(typeCoord == 'C')
		{
			rho = Math.sqrt(xOrRho * xOrRho + yOrTheta * yOrTheta);
			theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
		}
		else
		{
			// If not type polar or type cartesian, throw illegal argument exception
			throw new IllegalArgumentException();
		}
		this.typeCoord = 'P';
		
	}

	// Instance methods
	
	// computes and returns value of x
	public double getX()
	{
		return rho * Math.cos(Math.toRadians(theta));
	}

	// computes and returns value of y
	public double getY()
	{
		return rho * Math.sin(Math.toRadians(theta));
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
	public double getDistance(PointCP2 pointB)
	{
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	
	/**
	* Copied from PointCP2 class 
	* Rotates the specified point by the specified number of degrees.
	* Not required until E2.30
	*
	* @param point The point to rotate
	* @param rotation The number of degrees to rotate the point.
	* @return The rotated image of the original point.
	*/
	public PointCP2 rotatePoint(double rotation)
	{
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		return new PointCP2('C', (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),(Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
	}
	
	// Returns string representation of PointCP2
	public String toString()
	{
		return "Stored as Polar : (" + getX() + "," + getY() + ")"
		   + "Cartesian value [" + getRho() + "," + getTheta() + "]";
	}
}
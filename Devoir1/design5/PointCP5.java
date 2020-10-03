public abstract class PointCP5
{
	public abstract double getX();
	public abstract double getY();
	public abstract double getRho();
	public abstract double getTheta();
	public abstract PointCP5 rotatePoint(double rotation);
	public abstract double getDistance(PointCP5 pointB);
	public abstract String toString();
}
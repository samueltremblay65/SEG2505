// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.util.Random;

public class PointCPTest
{
	public final static int NOMBRE_POINTS = 200000;
	
	public static void main(String args[])
	{
		// Test aura deux parties : une partie pour verifier le fonctionnement et une partie pour mesurer la performance
		
		// Partie verification
		
		// On cree des points avec type original cartesien et des points avec type original polaire et on verifie que les methodes fonctionnent correctement
		// En imprimant la valeur de la fonction toString, nous testons aussi les fonctions getX(), getY(), getRho() et getTheta()
		PointCP4 pointC1;
		PointCP4 pointP1;

		PointCP4 pointC2;
		PointCP4 pointP2;

		PointCP4 pointC3;
		PointCP4 pointP3;
	
		pointC1 = new PointCP4('C', 5, 0);
		pointP1 = new PointCP4('P', 5, 0);
		
		pointC2 = new PointCP4('C', 0, 5);
		pointP2 = new PointCP4('P', 5, 90);
		
		pointC3 = new PointCP4('C', 3, 4);
		pointP3 = new PointCP4('P', 5, 53.1301);
		
		System.out.println("\nPointC1 : ");
		System.out.println(pointC1);
		System.out.println("PointP1 : ");
		System.out.println(pointP1 + "\n");
		
		System.out.println("PointC2 : ");
		System.out.println(pointC2);
		System.out.println("PointP2 : ");
		System.out.println(pointP2 + "\n");
		
		System.out.println("PointC3 : ");
		System.out.println(pointC3);
		System.out.println("PointP3 : ");
		System.out.println(pointP3 + "\n");
		
		System.out.println("On fait tourner les points par 90 degres : ");
		
		System.out.println("PointC1 : ");
		System.out.println(pointC1.rotatePoint(90));
		System.out.println("PointP1 : ");
		System.out.println(pointP1.rotatePoint(90) + "\n");
		
		System.out.println("PointC2 : ");
		System.out.println(pointC2.rotatePoint(90));
		System.out.println("PointP2 : ");
		System.out.println(pointP2.rotatePoint(90) + "\n");
		
		System.out.println("PointC3 : ");
		System.out.println(pointC3.rotatePoint(90));
		System.out.println("PointP3 : ");
		System.out.println(pointP3.rotatePoint(90) + "\n");
		
		System.out.println("On calcule la distance entre les points et le pointC1 et le point p1: ");
		
		System.out.println("Distance entre pointC1 et pointC1 : " + Double.toString(pointC1.getDistance(pointC1)));
		System.out.println("Distance entre pointP1 et pointC1 : " + Double.toString(pointP1.getDistance(pointC1)));
		
		System.out.println("Distance entre pointC2 et pointC1 : " + Double.toString(pointC2.getDistance(pointC1)));
		System.out.println("Distance entre pointP2 et pointC1 : " + Double.toString(pointP2.getDistance(pointC1)));
		
		System.out.println("Distance entre pointC3 et pointC1 : " + Double.toString(pointC3.getDistance(pointC1)));
		System.out.println("Distance entre pointP3 et pointC1 : " + Double.toString(pointP3.getDistance(pointC1)));
		
		System.out.println("\nPartie verification terminee...\n");
						
		// Partie performance : 
		// Nous allons creer un nombre NOMBRE_POINTS d'objets PointCP4. Nous allons appeller toutes les methodes publiques de la classe, dont le calcul
		// de la distance entre le PointCP4 et un autre PointCP4. Pour creer le point, nous allons utiliser des valeurs aleatoires
		
		long startTime = System.nanoTime();
		
		Random rnd = new Random();
		boolean  polar;
		char coordType;
		double xOrRho;
		double yOrTheta;
		double rotation;
		
		PointCP4 point;
		PointCP4 autre;
		// Generation des parametres pour la creation de l'objet
		polar = rnd.nextBoolean();
		if(polar)
		{
			coordType = 'P';
			xOrRho = rnd.nextDouble() * 100;
			yOrTheta = rnd.nextDouble() * 360;
		}
		else
		{
			coordType = 'C';
			yOrTheta = rnd.nextDouble() * 100;
			xOrRho = rnd.nextDouble() * 100;
		}
		
		autre = new PointCP4(coordType, xOrRho, yOrTheta);
		
		for(int i = 0; i < NOMBRE_POINTS; i++)
		{
			// Generation des parametres pour la creation de l'objet
			polar = rnd.nextBoolean();
			if(polar)
			{
				coordType = 'P';
				xOrRho = rnd.nextDouble() * 100;
				yOrTheta = rnd.nextDouble() * 360;
			}
			else
			{
				coordType = 'C';
				yOrTheta = rnd.nextDouble() * 100;
				xOrRho = rnd.nextDouble() * 100;
			}
			
			// Creation de l'objet
			point = new PointCP4(coordType, xOrRho, yOrTheta);
			
			// On appelle toutes les methodes de l'objet
			point.getX();
			point.getY();
			point.getRho();
			point.getTheta();			
			
			// On calcule la distance entre le point et l'autre
			point.getDistance(autre);
			
			// On performe une rotation d'un nombre aleatoire de degres
			point.rotatePoint(rnd.nextDouble() * 360);
			
			// On appelle toString mais pour mieux mesurer la difference de performance, nous n'affichons rien a l'ecran
			point.toString();
		}
		
		long elapsedTime = System.nanoTime() - startTime;
		System.out.println("Performance : temps ecoule en ms : " + Long.toString(elapsedTime / 1000000));
		
	}
	
}

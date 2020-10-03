import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Exercice2
{
	public static void main(String args[])
	{
		// On cree un tableau qui tient toutes les valeurs possible pour ajouter aux listes
		char[] possibleValues = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		
		// Tient la valeur presente pour le temps
		long start = System.nanoTime();
		// Va tenir la valeur du temps a la fin de l'operation
		long finish;
		
		// Va tenir le temps qu'a pris l'operation
		long timeElapsed;
		
		// Instance de l'objet Random
		Random rnd = new Random();
		
		// Testing ArrayList
		ArrayList<Character> arrayList = new ArrayList<Character>();
		for(int i = 0; i < 20000000; i++)
		{
			arrayList.add(possibleValues[rnd.nextInt(26)]);
		}
		
		finish = System.nanoTime();
		timeElapsed = finish - start;
		arrayList = null;
		
		System.out.println("ArrayList : Temps ecoule pour 20 000 000 elements en milisecondes (ms): " + Long.toString(timeElapsed / 1000000));
		
		start = System.nanoTime();
		// Testing LinkedList
		LinkedList<Character> linkedList = new LinkedList<Character>();
		for(int i = 0; i < 20000000; i++)
		{
			linkedList.addFirst(possibleValues[rnd.nextInt(26)]);
		}
		finish = System.nanoTime();
		timeElapsed = finish - start;
		
		System.out.println("LinkedList: Temps ecoule pour 20 000 000 elements en milisecondes (ms): " + Long.toString(timeElapsed / 1000000));
		linkedList = null;
		
		// Testing Tableau
		start = System.nanoTime();
		char[] tableau = new char[20000000];
		for(int i = 0; i < 20000000; i++)
		{
			tableau[i] = possibleValues[rnd.nextInt(26)];
		}
		finish = System.nanoTime();
		timeElapsed = finish - start;
		
		System.out.println("Tableau: Temps ecoule pour 20 000 000 elements en milisecondes (ms): " + Long.toString(timeElapsed / 1000000));
	}	
}
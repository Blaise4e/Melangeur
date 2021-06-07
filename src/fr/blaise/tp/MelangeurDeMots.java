package fr.blaise.tp;

import java.util.Random;
import java.util.Scanner;

public class MelangeurDeMots {

	private static Random rnd = new Random();
	
	public static void main(String[] args) {

		String phrase = saisir("Veuillez saisir voitre mot :");
		String[] mots = phrase.split(" ");
		String resultat = "";
		
		for(int i=0; i<mots.length; i++)
		{
			if(i>0) resultat += " ";
			resultat += melangeur(mots[i]);
		}
		System.out.println("Phrase : " + resultat);
	}
	
	/**
	 * 
	 * @param mot
	 * @return le mot mélangé en gardant la première et dernière lettre
	 */
	private static String melangeur(String mot)
	{
		String resultat = "";
		if(mot.length()<= 2) resultat = mot;
		else 
		{
			String tempMot = mot.substring(1, mot.length() -1);
			
			while(tempMot.length()>=2)
			{
			int rndValue = 1 + rnd.nextInt(tempMot.length()-1);
			resultat += tempMot.charAt(rndValue);
			tempMot = tempMot.substring(0, rndValue) + tempMot.substring(rndValue+1);
		}
		resultat = mot.substring(0,1) + resultat + tempMot + mot.substring(mot.length()-1);
		}
		return resultat;
	}

	/**
	 * 
	 * @param message
	 * @return saisie de l'utilisateur
	 */
	private static String saisir(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}

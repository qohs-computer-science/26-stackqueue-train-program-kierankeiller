/*
 * Kieran Keiller
 * 1/10/25
 * Pd: 3
 * Program Description: This program sorts train cars onto tracks based on destination, weight, and mileage. It also outputs whenever an engine takes a train to the destination.
 */
import java.util.Scanner;
import java.io.File;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class MyProgram {
	public static int val = 0;
	public static void main(String[] args) {
		System.out.println();
		int limitTrackA = 100000, limitTrackB = 100000, limitTrackC = 100000;
	
		Scanner x = new Scanner(System.in);
		Queue <Train> track0 = new LinkedList <Train> ();
		try{
			File f = new File("HelloWorldProject/src/data.txt");
			x = new Scanner (f);
			String name = x.nextLine();
			while (!name.equals("END")){
				if (name.substring(0,3).equals("CAR")){
					String product = x.nextLine();
					String origin = x.nextLine();
					String destination = x.nextLine();
					int weight = x.nextInt();
					int miles = x.nextInt();
					Train t = new Train(name, product, origin, destination, weight, miles);
					track0.add(t);
					name = x.nextLine();
					name = x.nextLine();
				}//end if
				else {
					String destination = x.nextLine();
					Train t = new Train(name, destination);
					track0.add(t);
					name = x.nextLine();
				}//end else
			}//end while
		}//end try
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}//end catch
		
		Queue <Train> track1 = new LinkedList <Train> ();
		Stack <Train> trackA = new Stack <Train> ();
		Stack <Train> trackB = new Stack <Train> ();
		Stack <Train> trackC = new Stack <Train> ();
		Stack <Train> trackD = new Stack <Train> ();
		int weightA = 0;
		int weightB = 0;
		int weightC = 0;

		while (track0.isEmpty()==false){
			Train car = track0.peek();
			if (car.getName().substring(0,3).equals("CAR") && car.getMiles()>700){
					track1.add(track0.remove());
					//System.out.println(car.getName() + " has over 700 miles, moved to Track 1");
			}//end if


			else if (car.getDestination().equals("Trenton")){
				if (car.getName().substring(0,3).equals("ENG")){
					//System.out.println(car.getName() + " added to track A");
					trackA.push(track0.remove());
					System.out.println(trackA.peek().getName() + " leaving for " + trackA.pop().getDestination() + " with the following cars:");
					while(trackA.isEmpty() == false){
						System.out.println(trackA.peek().getName() + " containing " + trackA.pop().getProduct());
					}//end while
					System.out.println();
					weightA = 0;
				}//end if
				else if(car.getWeight() + weightA <= limitTrackA){
					trackA.push(track0.remove());
					//System.out.println(car.getName() + " added to track A");
					weightA += car.getWeight();
				}//end else if
				else{
					trackA.push(new Train("ENG00000", "Trenton"));
					System.out.println(trackA.peek().getName() + " leaving for " + trackA.pop().getDestination() + " with the following cars:");
					while(trackA.isEmpty() == false){
						System.out.println(trackA.peek().getName() + " containing " + trackA.pop().getProduct());
					}//end while
					System.out.println();
					weightA = 0;
				}//end else
			}//end if


			else if (car.getDestination().equals("Charlotte")){
				if (car.getName().substring(0,3).equals("ENG")){
					//System.out.println(car.getName() + " added to track B");
					trackB.push(track0.remove());
					System.out.println(trackB.peek().getName() + " leaving for " + trackB.pop().getDestination() + " with the following cars:");
					while(trackB.isEmpty() == false){
						System.out.println(trackB.peek().getName() + " containing " + trackB.pop().getProduct());
					}//end while
					System.out.println();
					weightB = 0;
				}//end if
				else if(car.getWeight() + weightB <= limitTrackB){
					trackB.push(track0.remove());
					//System.out.println(car.getName() + " added to track B");
					weightB += car.getWeight();
				}//end else if
				else{
					trackB.push(new Train("ENG00000", "Charlotte"));
					System.out.println(trackB.peek().getName() + " leaving for " + trackB.pop().getDestination() + " with the following cars:");
					while(trackB.isEmpty() == false){
						System.out.println(trackB.peek().getName() + " containing " + trackB.pop().getProduct());
					}//end while
					System.out.println();
					weightB = 0;
				}//end else
			}//end if


			else if (car.getDestination().equals("Baltimore")){
				if (car.getName().substring(0,3).equals("ENG")){
					//System.out.println(car.getName() + " added to track C");
					trackC.push(track0.remove());
					System.out.println(trackC.peek().getName() + " leaving for " + trackC.pop().getDestination() + " with the following cars:");
					while(trackC.isEmpty() == false){
						System.out.println(trackC.peek().getName() + " containing " + trackC.pop().getProduct());
					}//end while
					System.out.println();
					weightC = 0;
				}//end if
				else if(car.getWeight() + weightC <= limitTrackC){
					trackC.push(track0.remove());
					//System.out.println(car.getName() + " added to track C");
					weightC += car.getWeight();
				}//end else if
				else{
					trackC.push(new Train("ENG00000", "Baltimore"));
					System.out.println(trackC.peek().getName() + " leaving for " + trackC.pop().getDestination() + " with the following cars:");
					while(trackC.isEmpty() == false){
						System.out.println(trackC.peek().getName() + " containing " + trackC.pop().getProduct());
					}//end while
					System.out.println();
					weightC = 0;
				}//end else
			}//end if

			else {
				trackD.push(track0.remove());
				//System.out.println(car.getName() + " added to track D");
			}//end if
		}//end while

		while(track1.isEmpty() == false){
			track1.peek().setMiles(100);
			if (track1.peek().getDestination().equals("Trenton")){
				if(track1.peek().getWeight() + weightA <= limitTrackA){
					//System.out.println(track1.peek().getName() + " reset to 100 miles and added to track A");
					trackA.push(track1.remove());
					weightA += track1.peek().getWeight();
				}//end if
				else{
					trackA.push(new Train("ENG00000", "Trenton"));
					System.out.println(trackA.peek().getName() + " leaving for " + trackA.pop().getDestination() + " with the following cars:");
					while(trackA.isEmpty() == false){
						System.out.println(trackA.peek().getName() + " containing " + trackA.pop().getProduct());
					}//end while
					System.out.println();
					weightA = 0;
				}//end else
			}//end if

			else if (track1.peek().getDestination().equals("Charlotte")){
				if(track1.peek().getWeight() + weightB <= limitTrackB){
					//System.out.println(track1.peek().getName() + " reset to 100 miles and added to track B");
					trackB.push(track1.remove());
					weightB += track1.peek().getWeight();
				}//end if
				else{
					trackB.push(new Train("ENG00000", "Charlotte"));
					System.out.println(trackB.peek().getName() + " leaving for " + trackB.pop().getDestination() + " with the following cars:");
					while(trackB.isEmpty() == false){
						System.out.println(trackB.peek().getName() + " containing " + trackB.pop().getProduct());
					}//end while
					System.out.println();
					weightB = 0;
				}//end else
			}//end else if
			
			else if (track1.peek().getDestination().equals("Baltimore")){
				if(track1.peek().getWeight() + weightC <= limitTrackC){
					//System.out.println(track1.peek().getName() + " reset to 100 miles and added to track C");
					trackC.push(track1.remove());
					weightC += track1.peek().getWeight();
				}//end if
				else{
					trackC.push(new Train("ENG00000", "Baltimore"));
					System.out.println(trackC.peek().getName() + " leaving for " + trackC.pop().getDestination() + " with the following cars:");
					while(trackC.isEmpty() == false){
						System.out.println(trackC.peek().getName() + " containing " + trackC.pop().getProduct());
					}//end while
					System.out.println();
					weightC = 0;
				}//end else
			}//end else if
			else {
				//System.out.println(track1.peek().getName() + " reset to 100 miles and added to track D");
				trackD.push(track1.remove());
			}//end else
		}//end while

		trackA.push(new Train("ENG00000", "Trenton"));
		System.out.println(trackA.peek().getName() + " leaving for " + trackA.pop().getDestination() + " with the following cars:");
		while(trackA.isEmpty() == false){
			System.out.println(trackA.peek().getName() + " containing " + trackA.pop().getProduct());
		}//end while
		System.out.println();
		weightA = 0;		

		trackB.push(new Train("ENG00000", "Charlotte"));
		System.out.println(trackB.peek().getName() + " leaving for " + trackB.pop().getDestination() + " with the following cars:");
		while(trackB.isEmpty() == false){
			System.out.println(trackB.peek().getName() + " containing " + trackB.pop().getProduct());
		}//end while
		System.out.println();
		weightB = 0;		

		trackC.push(new Train("ENG00000", "Baltimore"));
		System.out.println(trackC.peek().getName() + " leaving for " + trackC.pop().getDestination() + " with the following cars:");
		while(trackC.isEmpty() == false){
			System.out.println(trackC.peek().getName() + " containing " + trackC.pop().getProduct());
		}//end while
		System.out.println();
		weightC = 0;

		System.out.println("Cars in the \"other\" track:");
		while(trackD.isEmpty() == false){
			System.out.println(trackD.peek().getName() + " containing " + trackD.pop().getProduct());
		}//end while
		System.out.println();
	}//end main
}//end class
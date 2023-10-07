package Flight_Management;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FlightManagement1 {


	
	static ArrayList<Passenger> al = new ArrayList();
	
	static
	{
		try
		{
			readarrayfile();
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
	}

	public static void flightManagement() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		boolean canIkeeprunningprogram = true;
		
		while(canIkeeprunningprogram == true)
		{
			System.out.println("1.add passenger");
			System.out.println("2.exit");
			
			int selectaboveoption = sc.nextInt();
			
			if(selectaboveoption == 1)
			{
				addPassenger();
			}
			
			else if(selectaboveoption == 2)
			{
				File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\Project_30sep\\src\\Flight_Management\\passenger.txt");
				
				FileWriter fw = new FileWriter(file, false);
				
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(Passenger u:al)
				{
					bw.write(u.name +","+u.from +","+ u.to +","+ u.date +","+ u.no_of_person +"\n");
				}
				
				bw.close();
				fw.close();
				file = null;
				
				System.out.println("program stopped");
				canIkeeprunningprogram = false;
			}
		}
	}
	
	public static void addPassenger()
	{
		Scanner sc = new Scanner(System.in);
		
		Passenger u = new Passenger();
		
		System.out.println("Passenger name : ");
		u.name = sc.nextLine();
		
		System.out.println("from : ");
		u.from = sc.nextLine();
		
		System.out.println("to : ");
		u.to = sc.nextLine();
		
		System.out.println("date : ");
		u.date = sc.nextLine();
		
		System.out.println("no of person : ");
		u.no_of_person = sc.nextLine();
		
		System.out.println("Passenger name is : " +u.name);
		System.out.println("Passenger seeting from : " +u.from);
		System.out.println("Passenger arrival city : " +u.to);
		System.out.println("Passenger ticket date : " +u.date);
		System.out.println("No of Passengers : " +u.no_of_person);
		
		al.add(u);
	}
	
	
	
	public static void readarrayfile() throws IOException
	{
		File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\Project_30sep\\src\\Flight_Management\\passenger.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		
		while((line = br.readLine())!= null)
		{
			Passenger u = new Passenger();
			
			String[] a  = line.split(",");
			
			u.name = a[0];
			u.from = a[1];
			u.to = a[2];
			u.date = a[3];
			u.no_of_person = a[4];
			
			al.add(u);
		}
		br.close();
		fr.close();
		file = null;
	}

}

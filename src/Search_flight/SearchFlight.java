package Search_flight;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Flight_Management.FlightManagement;
import Flight_Management.FlightManagement1;

public class SearchFlight {
	
	static List<Flight1> al = new ArrayList();

	public static void searchFlight() throws IOException
	{
		readfiledata();
		Scanner sc = new Scanner(System.in);
		
		boolean canIkeeprunningprogram = true;
		
		System.out.println("search flight");
		String flight = sc.nextLine();
		
		for(Flight1 u:al)
		{
			if(u.flight.equalsIgnoreCase(flight))
			{
				System.out.println("flight is available");
				
				System.out.println("Can you book flight");
				
				System.out.println("1.yes");
				System.out.println("2.no");
				int selectaboveoption = sc.nextInt();
				
				if(selectaboveoption == 1)
				{
					FlightManagement1.flightManagement();
					return;
				}
				else if(selectaboveoption == 2)
				{
					canIkeeprunningprogram = false;
					return;
				}
			}
		}
		System.out.println("flight is not available");
	}
	
	public static void readfiledata() throws IOException
	{
		File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\Project_30sep\\src\\Book_Ticket\\flight.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		
		while((line = br.readLine())!= null)
		{
			Flight1 f1 = new Flight1();
			
			String[] s = line.split(",");
			
			f1.flight = s[0];
			f1.fdate = s[1];
			f1.ftime = s[2];
			f1.fstation = s[3];
			
			al.add(f1);
		}
		br.close();
		fr.close();
		file = null;
	}
}

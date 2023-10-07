package Book_Ticket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import User_Management.User;

public class BookTicket {
	
	static List<Flight> al = new ArrayList();

	public static void bookTicket() throws IOException
	{
		readarrayfile();
		
		Scanner sc = new Scanner(System.in);
		
		boolean canIkeeprunningprogram = true;
		
		while(canIkeeprunningprogram == true)
		{
			System.out.println("1.add flight");
			System.out.println("2.search flight");
			System.out.println("3.edit flight");
			System.out.println("4.delete flight");
			System.out.println("5.exit");
			
			int selectaboveoption = sc.nextInt();
			
			if(selectaboveoption == 1)
			{
				addFlight();
			}
			else if(selectaboveoption == 2)
			{
				System.out.println("enter flight name to search flight : ");
				sc.nextLine();
				String s = sc.nextLine();
				searchFlight(s);
			}
			else if(selectaboveoption == 3)
			{
				System.out.println("enter flight name to edit flight : ");
				sc.nextLine();
				String e = sc.nextLine();
				editFlight(e);
			}
			else if(selectaboveoption == 4)
			{
				System.out.println("enter flight name to delete flight : ");
				sc.nextLine();
				String d = sc.nextLine();
				deleteFlight(d);
			}
			else if(selectaboveoption == 5)
			{
				File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\Project_30sep\\src\\Book_Ticket\\flight.txt");
				
				FileWriter fw = new FileWriter(file, false);
				
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(Flight u:al)
				{
					bw.write(u.flight +","+ u.fdate +","+ u.ftime +","+ u.fstation +"\n");
				}
				
				bw.close();
				fw.close();
				file = null;
				
				System.out.println("program stopped");
				canIkeeprunningprogram = false;
			}
		}
		for(Flight u:al)
		{
			System.out.println(u.flight);
			System.out.println(u.fdate);
			System.out.println(u.ftime);
			System.out.println(u.fstation);
		}
	}
	
	public static void addFlight()
	{
		Scanner sc = new Scanner(System.in);
		
		Flight u = new Flight();
		
		System.out.println("flight name : ");
		u.flight = sc.nextLine();
		
		System.out.println("flight date : ");
		u.fdate = sc.nextLine();
		
		System.out.println("flight time : ");
		u.ftime = sc.nextLine();
		
		System.out.println("flight station : ");
		u.fstation = sc.nextLine();
		
		System.out.println("flight name is : " +u.flight);
		System.out.println("flight date is : " +u.fdate);
		System.out.println("flight time is : " +u.ftime);
		System.out.println("flight station is : " +u.fstation);
		
		al.add(u);
	}
	
	public static void searchFlight(String flight)
	{
		for(Flight u:al)
		{
			if(u.flight.equalsIgnoreCase(flight))
			{
				System.out.println("flight name is : " +u.flight);
				System.out.println("flight date is : " +u.fdate);
				System.out.println("flight time is : " +u.ftime);
				System.out.println("flight station is : " +u.fstation);
				return;
			}
		}
		System.out.println("flight not found");
	}
	
	public static void editFlight(String flight)
	{
		Scanner sc = new Scanner(System.in);
		
		for(Flight u:al)
		{
			if(u.flight.equalsIgnoreCase(flight))
			{
				System.out.println("flight name is : ");
				
				System.out.println("new flight name : ");
				u.flight = sc.nextLine();
				
				System.out.println("new flight date : ");
				u.fdate = sc.nextLine();
				
				System.out.println("new flight time : ");
				u.ftime = sc.nextLine();
				
				System.out.println("new flight station : ");
				u.fstation = sc.nextLine();
				
				return;
			}
		}
		System.out.println("flight not found");
	}
	
	public static void deleteFlight(String flight)
	{
		Iterator<Flight> it = al.iterator();
		
		while(it.hasNext())
		{
			Flight u = it.next();
			
			if(u.flight.equalsIgnoreCase(flight))
			{
				System.out.println("flight " +u.flight+ " has been deleted");
				it.remove();
				return;
			}
		}
		System.out.println("flight not found");
	}
	
	public static void readarrayfile() throws IOException
	{
		File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\Project_30sep\\src\\Book_Ticket\\flight.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		
		while((line = br.readLine())!= null)
		{
			Flight u = new Flight();
			
			String[] a  = line.split(",");
			
			u.flight = a[0];
			u.fdate = a[1];
			u.ftime = a[2];
			u.fstation = a[3];
			
			al.add(u);
		}
		
		br.close();
		fr.close();
		file = null;
	}
}

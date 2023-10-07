package Application_Management;

import java.io.IOException;
import java.util.Scanner;

import Book_Ticket.BookTicket;
import Flight_Management.FlightManagement;
import Search_flight.SearchFlight;
import User_Management.UserManagement;

public class ApplicationManagement {

	public static void main(String args[]) throws IOException
	{
		System.out.println("welcome to flight booking management");
		System.out.println("\n");
		System.out.println("please select bellow option");
		
		boolean canIkeeprunningprogram = true;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1.admin");
		System.out.println("2.customer");
		int selectoption = sc.nextInt();
		
		if(selectoption == 1)
		{
			admin();
			return;
		}
		else if(selectoption == 2)
		{
			SearchFlight.searchFlight();
		}
	}
	
	public static void admin() throws IOException
	{
		boolean canIkeeprunningprogram = true;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter login name : ");
		String login = sc.nextLine();
		
		System.out.println("enter password : ");
		String pass = sc.nextLine();
		
		if(!UserManagement.loginpassdata(login, pass))
		{
			System.out.println("login failed");
			return;
		}
		
		while(canIkeeprunningprogram == true)
		{
			System.out.println("1.user management");
			System.out.println("2.flight management");
			System.out.println("3.passanger");
			System.out.println("4.Quit");
			
			int selectaboveoption = sc.nextInt();
			
			if(selectaboveoption == 1)
			{
				UserManagement.userManagement();
			}
			else if(selectaboveoption == 2)
			{
				BookTicket.bookTicket();
			}
			else if(selectaboveoption == 3)
			{
				FlightManagement.flightManagement();
			}
			else if(selectaboveoption == 4)
			{
				System.out.println("program closed");
				break;
			}
		}
	}
}

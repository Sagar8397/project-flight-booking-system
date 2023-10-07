package Application_Management;

import java.util.Scanner;

import User_Management.UserManagement;

public class Admin {

	public static void admin()
	{
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
	}
}

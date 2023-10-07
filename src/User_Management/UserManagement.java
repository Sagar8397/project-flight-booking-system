package User_Management;

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

public class UserManagement {
	
	static List<User> al = new ArrayList();
	
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

	public static void userManagement() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		boolean canIkeeprunningprogram = true;
		
		while(canIkeeprunningprogram == true)
		{
			System.out.println("1.add user");
			System.out.println("2.search user");
			System.out.println("3.edit user");
			System.out.println("4.delete user");
			System.out.println("5.exit");
			
			int selectaboveoption = sc.nextInt();
			
			if(selectaboveoption == 1)
			{
				addUser();
			}
			else if(selectaboveoption == 2)
			{
				System.out.println("enter user name to search user : ");
				sc.nextLine();
				String s = sc.nextLine();
				searchUser(s);
			}
			else if(selectaboveoption == 3)
			{
				System.out.println("enter user name to edit user : ");
				sc.nextLine();
				String e = sc.nextLine();
				editUser(e);
			}
			else if(selectaboveoption == 4)
			{
				System.out.println("enter user name to delete user : ");
				sc.nextLine();
				String d = sc.nextLine();
				deleteUser(d);
			}
			else if(selectaboveoption == 5)
			{
				File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\Project_30sep\\src\\User_Management\\user.txt");
				
				FileWriter fw = new FileWriter(file, false);
				
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(User u:al)
				{
					bw.write(u.user +","+u.login +","+ u.pass +","+ u.conPass +","+ u.type +"\n");
				}
				
				bw.close();
				fw.close();
				file = null;
				
				System.out.println("program stopped");
				canIkeeprunningprogram = false;
			}
		}
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).user);
			System.out.println(al.get(i).login);
			System.out.println(al.get(i).pass);
			System.out.println(al.get(i).conPass);
			System.out.println(al.get(i).type);
			System.out.println("\n");
		}
	}
	
	public static void addUser()
	{
		Scanner sc = new Scanner(System.in);
		
		User u = new User();
		
		System.out.println("user name : ");
		u.user = sc.nextLine();
		
		System.out.println("login name : ");
		u.login = sc.nextLine();
		
		System.out.println("user password : ");
		u.pass = sc.nextLine();
		
		System.out.println("user confirm password : ");
		u.conPass = sc.nextLine();
		
		System.out.println("user type : ");
		u.type = sc.nextLine();
		
		System.out.println("user name is : " +u.user);
		System.out.println("login name is : " +u.login);
		System.out.println("password is : " +u.pass);
		System.out.println("uconfirm password is : " +u.conPass);
		System.out.println("user type is : " +u.type);
		
		al.add(u);
	}
	
	public static void searchUser(String user)
	{
		for(User u:al)
		{
			if(u.user.equalsIgnoreCase(user))
			{
				System.out.println("user name is : " +u.user);
				System.out.println("login name is : " +u.login);
				System.out.println("password is : " +u.pass);
				System.out.println("uconfirm password is : " +u.conPass);
				System.out.println("user type is : " +u.type);
				return;
			}
		}
		System.out.println("user not found");
	}
	
	public static void editUser(String user)
	{
		Scanner sc = new Scanner(System.in);
		
		for(User u:al)
		{
			if(u.user.equalsIgnoreCase(user))
			{
				System.out.println("user name is : ");
				
				System.out.println("new user name : ");
				u.user = sc.nextLine();
				
				System.out.println("new login name : ");
				u.login = sc.nextLine();
				
				System.out.println("new user password : ");
				u.pass = sc.nextLine();
				
				System.out.println("new user confirm password : ");
				u.conPass = sc.nextLine();
				
				System.out.println("new user type : ");
				u.type = sc.nextLine();
				return;
			}
		}
		System.out.println("user not found");
	}
	
	public static void deleteUser(String user)
	{
		Iterator<User> it = al.iterator();
		
		while(it.hasNext())
		{
			User u = it.next();
			
			if(u.user.equalsIgnoreCase(user))
			{
				System.out.println("user " +u.user+ " has been deleted");
				it.remove();
				return;
			}
		}
		System.out.println("user not found");
	}
	
	public static void readarrayfile() throws IOException
	{
		File file = new File("C:\\Users\\Sagar\\eclipse-workspace\\Project_30sep\\src\\User_Management\\user.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String line = "";
		
		while((line = br.readLine())!= null)
		{
			User u = new User();
			
			String[] a  = line.split(",");
			
			u.user = a[0];
			u.login = a[1];
			u.pass = a[2];
			u.conPass = a[3];
			u.type = a[4];
			
			al.add(u);
		}
		
		br.close();
		fr.close();
		file = null;
	}
	
	public static boolean loginpassdata(String login, String pass)
	{
		Iterator<User> it = al.iterator();
		
		while(it.hasNext())
		{
			User u = it.next();
			
			if(u.login.equalsIgnoreCase(login) && u.pass.equalsIgnoreCase(pass))
			{
				return true;
			}
		}
		return false;
	}
}

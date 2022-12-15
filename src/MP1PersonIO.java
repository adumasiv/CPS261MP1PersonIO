
import java.io.*;
import java.util.*;

public class MP1PersonIO 
	{

		String fileName;
		ObjectInputStream IS = null;
		ObjectOutputStream OS = null;
		static Scanner kbd = new Scanner(System.in);

		public MP1PersonIO(String fileName)
		{

			try 
			{
				this.OS = new ObjectOutputStream(new FileOutputStream(fileName));
				this.IS = new ObjectInputStream(new FileInputStream(fileName));
			} 			
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}

		}

		public void add() throws IOException 
		{
			System.out.println("Please enter the person's name:");
			String name=kbd.nextLine();
			System.out.println("Please enter the person's age:");
			int age=Integer.parseInt(kbd.nextLine());
			Person out=new Person(name,age);
			OS.writeObject(out);
      
		}

		public void display() throws ClassNotFoundException, IOException 
		{
			try
			{
				while (true) 
				{
					Person obj = (Person) IS.readObject();
					System.out.println(obj);
				}
			}
			catch (EOFException e){};
		}

		public static void main(String[] args) throws Exception 
		{
			MP1PersonIO MP = new MP1PersonIO("person.ser");
			try 
			{
				int option = -1;
				while (option != 0) 
				{
					System.out.println("Please choose an option:");
					System.out.println("0: quit");
					System.out.println("1: add");
					System.out.println("2: display");
					option = kbd.nextInt();
					kbd.nextLine();
					switch (option) 
					{
						case 0:
						System.out.println("Bye");
						break;
						case 1:
						MP.add();
	                    break;
					    case 2:
	                    MP.display();
	                    break;
					}

				}	

			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			} 
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			} 
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				MP.IS.close();
		        MP.OS.close();
		        kbd.close();
			}	

		}

	}
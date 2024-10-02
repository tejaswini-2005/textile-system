package textile;

import java.util.Scanner;

class stock{
	int stock_id;
	String description;
	float amnt;
	int quant;
	
	stock(int id, String des,float n,int q) {
		stock_id=id;
		description=des;
		amnt=n;
		quant=q;
	}
	
	stock(){
	}

	public void display() {
		System.out.println("STOCK ID\t DESCRIPTION\t\t QUANTITY\t\t PRICE");
		System.out.println(tops.stock_id+"\t\t"+tops.description+"\t\t\t"+tops.quant+"\t\t\t"+tops.amnt);
		System.out.println(shirt.stock_id+"\t\t"+shirt.description+"\t\t\t"+shirt.quant+"\t\t\t"+shirt.amnt);
		System.out.println(jps.stock_id+"\t\t"+jps.description+"\t\t"+jps.quant+"\t\t\t"+jps.amnt);
		System.out.println(sar.stock_id+"\t\t"+sar.description+"\t\t\t"+sar.quant+"\t\t\t"+sar.amnt);
	}


	static stock tops=new stock(101,"tops",450,20);
	static stock shirt=new stock(102,"shirt",700,50);
	static stock jps=new stock(103,"jumpsuit",1500,10);
	static stock sar=new stock(104,"saree",2000,55);
	
}

class emp_det extends stock{
	int emp_id;
	String emp_name;
	double comm=0.0;
	
	emp_det(int id, String s)
	{
		emp_id=id;
		emp_name=s;
	}
	
	void emp_display()
	{
		System.out.println("EMPID\t\t EMPNAME\t ALLOWANCE");
		System.out.println(s1.emp_id+"\t\t"+s1.emp_name+"\t\t"+s1.comm);
		System.out.println(s2.emp_id+"\t\t"+s2.emp_name+"\t\t"+s2.comm);
		System.out.println(s3.emp_id+"\t\t"+s3.emp_name+"\t\t"+s3.comm);
		System.out.println(s4.emp_id+"\t\t"+s4.emp_name+"\t\t"+s4.comm);
		System.out.println(s5.emp_id+"\t\t"+s5.emp_name+"\t\t"+s5.comm);
	}
	
	static emp_det s1=new emp_det(1,"pritham");
	static emp_det s2=new emp_det(2,"udit");
	static emp_det s3=new emp_det(3,"faheema");
	static emp_det s4=new emp_det(4,"dolly");
	static emp_det s5=new emp_det(5,"hrithik");
	
	emp_det(){
	}
}

class generateBill extends emp_det
{
        Scanner sc = new Scanner(System.in);
    	generateBill(int no,salesday sd,int emp)
    	{
    		float totprice=0;
    		for(int i=0;i<no;i++)
    		{
    			System.out.println("\nenter stock id:");
    			int sId=sc.nextInt() ; 
    			System.out.println("enter quantity of the stock");
    			int quant=sc.nextInt();
                
    			if(sId==tops.stock_id)
    			{
    				float price=quant*tops.amnt;
    				System.out.print("Description:"+tops.description+"\t"+"price:"+(quant*tops.amnt)+"\n");
    				totprice+=price;
    			}
    			else if(sId==shirt.stock_id)
    			{
    				float price=quant*shirt.amnt;
    				System.out.print("Description:"+shirt.description+"\t"+"price:"+price+"\n");
    				totprice+=price;
    			}
    			else if(sId==jps.stock_id)
    			{
    				float price=quant*jps.amnt;
    				System.out.print("Description:"+jps.description+"\t"+"price:"+(quant*jps.amnt)+"\n");
    				totprice+=price;
    			}
    			else if(sId==sar.stock_id)
    			{
    				float price=quant*sar.amnt;
    				System.out.print("Description:"+sar.description+"\t"+"price:"+(quant*sar.amnt)+"\n");
    				totprice+=price;
    			}
    			else
    			{
    				System.out.println("invalid ID.Try again");
    			}
    		}
    		System.out.println("------------------------------------------");
    		System.out.println("\n\tTotal amount is:"+totprice+"\n");
    		System.out.println("------------------------------------------");
    		sd.sales(totprice);
    		
    		if(emp==s1.emp_id)
			{
				s1.comm+= ((0.1)*totprice);
			}
			else if(emp==s2.emp_id)
			{
				s2.comm+= ((0.1)*totprice);
			}
			else if(emp==s3.emp_id)
			{
				s3.comm+= ((0.1)*totprice);
			}
			else if(emp==s4.emp_id)
			{
				s4.comm+= ((0.1)*totprice);
			}
			else if(emp==s5.emp_id)
			{
				s5.comm+= ((0.1)*totprice);
			}
			else
			{
				System.out.println("invalid empid....try again");
			}
    	}
}

class salesday{
	float totalsales=0;
	
	public void sales(float rec)
	{
		totalsales+=rec;
	}
	public void dis()
	{
		System.out.println("Total Sales per day is:"+totalsales);
	}
}


public class projecttex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
		
		System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("*                                         *");
		System.out.println("*                                         *");
		System.out.println("*         WELCOME TO DODGER'S TEX         *");
		System.out.println("*                                         *");
		System.out.println("*                                         *");
		System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
		
		salesday sd=new salesday();
		
		int ch;
		do
		{
			System.out.println("\n1.Check Stock Details");
			System.out.println("2.Generate Bill");
			System.out.println("3.Employee Details");
			System.out.println("4.Sales Details");
			System.out.println("5.Exit");			
			System.out.println("\nenter your choice:");
			ch=sc.nextInt();
			
			stock s = new stock();
			emp_det E=new emp_det();
			
			if(ch==1)
			{
				s.display();
			}
			else if(ch==2)
			{
				System.out.println("enter the total no of stock_id that is being purchased(1-4)");
				int n=sc.nextInt();
				System.out.println("enter employee number:");
				int m=sc.nextInt();
                generateBill GB= new generateBill(n,sd,m);
			}
			else if(ch==3)
			{
				E.emp_display();
			}
			else if(ch==4)
			{
				sd.dis();
			}
			else
			{
				System.out.println("Exiting the program...");
				System.exit(0);
			}
		}while(ch<6);
		
		sc.close();
	}

}


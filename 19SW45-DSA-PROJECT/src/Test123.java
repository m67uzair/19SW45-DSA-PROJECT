import java.util.Scanner;

public class Test123 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		String inputString = "";

		String Salaried;
		String firstN;
		String lastN;
		double salary;
		double grossWages;
		double federalTaxes;
		double stateTaxes;
		double retirement;
		double netwages;

		String Monthly;
		String MfirstN;
		String MlastN;
		double Hourly;
		int week1;
		int week2;
		int week3;
		int week4;
		double Regular;
		double grossWages2;
		double federalTaxes2;
		double stateTaxes2;
		double netwages2;

		String Hourly2;
		String HfirstN;
		String HlastN;
		double grossWages3;
		double Hour;
		double Nhour;

		String getEmployeeType = "";

		String Quit;

		while (!getEmployeeType.equals("Quite")) {
			System.out.print("Enter Employee Type [ Salaried ], [ Monthly ], [ Hourly ] or [ Quit ]: ");
			getEmployeeType = keyboard.next();
			if(getEmployeeType.equals("Quit") ) {
				System.out.println("Quit");
				break;
			}
			switch (getEmployeeType) {
			case "Salaried": {

				System.out.print("Enter Employee First Name: ");
				firstN = keyboard.next();

				System.out.print("Enter Employee Last Name : ");
				lastN = keyboard.next();

				System.out.print(firstN + " " + lastN + "'s Yearly Salary: ");
				salary = keyboard.nextDouble();
				grossWages = salary * 1 / 13;
				double roundOff = Math.round(grossWages * 100.00) / 100.00;

				System.out.print("\nEmployee             : " + firstN + " " + lastN + "\n");

				System.out.print("Gross Wages              : " + roundOff + "\n");

				federalTaxes = roundOff * 3 / 25;
				double roundOff2 = Math.round(federalTaxes * 100.00) / 100.00;
				System.out.print("Federal Taxes Withheld   : " + roundOff2 + "\n");

				stateTaxes = roundOff * 3 / 100;
				double roundOff3 = Math.round(stateTaxes * 100.00) / 100.00;
				System.out.print("State Taxes Withheld     : " + roundOff3 + "\n");

				retirement = roundOff * 4 / 100;
				double roundOff4 = Math.round(retirement * 100.00) / 100.00;
				System.out.print("State Taxes Withheld     : " + roundOff4 + "\n");

				netwages = roundOff - roundOff2 - roundOff3 - roundOff4;
				double roundOff5 = Math.round(netwages * 100.00) / 100.00;
				System.out.print("Net Wages                : " + roundOff5 + "\n");
				break;

			}
			case "Hourly": {
				System.out.print("Enter Employee First Name: ");
				HfirstN = keyboard.next();

				System.out.print("Enter Employee Last Name : ");
				HlastN = keyboard.next();

				System.out.print(HfirstN + " " + HlastN + "'s Hourly Salary: ");
				Hour = keyboard.nextDouble();

				System.out.print("Enter" + HfirstN + " " + HlastN + "Number of Hours: ");
				Nhour = keyboard.nextDouble();

				System.out.print("\nEmployee             : " + HfirstN + " " + HlastN + "\n");

				grossWages3 = Hour * Nhour;
				System.out.print("Gross Wages              : " + grossWages3 + "\n");
				System.out.println("NO Taxes Deducted");
			}

			}

		}
//        if(inputString.equals("Salaried"))
//        {
//            System.out.print("Enter Employee First Name: " );
//            MfirstN=keyboard.next();
//            
//            System.out.print("Enter Employee Last Name : " );
//            MlastN=keyboard.next();
//            
//            System.out.print(MfirstN + " " + MlastN + "'s Hourly Salary: ");
//            Hourly=keyboard.nextDouble();
//            
//            System.out.print("Hours Works for Week 1: " );
//            week1=keyboard.nextInt();
//            System.out.print("Hours Works for Week 2: " );
//            week2=keyboard.nextInt();
//            System.out.print("Hours Works for Week 3: " );
//            week3=keyboard.nextInt();
//            System.out.print("Hours Works for Week 4: " );
//            week4=keyboard.nextInt();
//            
//            System.out.print("\nEmployee             : " + MfirstN + " " + MlastN +"\n");
//            
//            Regular= (week1+week2+week3+week4)*Hourly;
//            System.out.print("Regular Wages              : " + Regular + "\n");
//            
//            System.out.print("Overtime Wages             : " + Hourly + "\n");
//            
//            grossWages2= Hourly*1/13;
//            double roundOff6 = Math.round(grossWages2 * 100.00) / 100.00;
//            System.out.print("Gross Wages              : " + roundOff6 + "\n");
//            
//            federalTaxes2 = roundOff6*3/25;
//            double roundOff7 = Math.round(federalTaxes2 * 100.00) / 100.00;
//            System.out.print("Federal Taxes Withheld   : " + roundOff7 + "\n");
//            
//            stateTaxes2 = Hourly* 3/100 ;
//            double roundOff8 = Math.round(stateTaxes2 * 100.00) / 100.00;
//            System.out.print("State Taxes Withheld     : " + roundOff8  + "\n");
//            
//            netwages2=roundOff6-roundOff7-roundOff8;
//            double roundOff9 = Math.round(netwages2 * 100.00) / 100.00;
//            System.out.print("Net Wages                : " + roundOff9  + "\n"); 
//            
//        }
//        else if ( inputString.equals(" Hourly2 ") ) {
//            System.out.print("Enter Employee First Name: " );
//            HfirstN=keyboard.next();
//            
//            System.out.print("Enter Employee Last Name : " );
//            HlastN=keyboard.next();
//            
//            System.out.print(HfirstN + " " + HlastN + "'s Hourly Salary: ");
//            Hour=keyboard.nextDouble();
//            
//            System.out.print("Enter" + HfirstN + " " + HlastN + "Number of Hours: " );
//            Nhour=keyboard.nextDouble();
//            
//            System.out.print("\nEmployee             : " + HfirstN + " " + HlastN +"\n");
//            
//            grossWages3 = Hour * Nhour;
//            System.out.print("Gross Wages              : "+ grossWages3 + "\n");
//            System.out.println("NO Taxes Deducted");
//        }
//        else {
//        	System.out.println("Quit");
//		}

	}

}

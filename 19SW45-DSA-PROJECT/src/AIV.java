import java.util.Scanner;
public class AIV {
	
	public static void main(String[] args) {
		int numOfViolations;
		String typeOfOffence,typeOFAssesment;
		System.out.println("Student Academic Integrity Policy");
		System.out.println("Enter the number of previous AVI");
		Scanner obj = new Scanner(System.in);
		numOfViolations = obj.nextInt();
		numOfViolations++;
		System.out.println("Enter the type of offence");
		Scanner obj2 = new Scanner(System.in);
		typeOfOffence = obj2.nextLine();
		System.out.println("Enter the type of assesment");
		Scanner obj3 = new Scanner(System.in);
		typeOFAssesment= obj3.nextLine();
		

		if(numOfViolations==1 && ( !typeOFAssesment.contains("project")) && typeOfOffence.equalsIgnoreCase("plagiarism") ) {
			numOfViolations++;
			System.out.println("Ask the student to re-submit within 5 days of he/she was informed");
			System.out.println("Is the re-submission free of plagiarism?Answere with true/false");
			boolean resubmit = obj.nextBoolean();
			if(resubmit) {
				System.out.println("25% deduction will be applied on the total marks for the resubmission");
				
			}
			else {
				System.out.println("The student should be awarded zero marks");
				numOfViolations++;
			}
			
		}
		
		if(numOfViolations==1 && typeOFAssesment.contains("project") && typeOfOffence.equalsIgnoreCase("plagiarism")) {
			System.out.println("The student is awarded F grade, ask the student to re-register the module");
		}
		
		if(numOfViolations==1  && ( typeOfOffence.equalsIgnoreCase("malpractice") ||
				typeOfOffence.equalsIgnoreCase("ghostwrriting") || typeOfOffence.equalsIgnoreCase("collusion") ) ) {
			System.out.println("The student will fail the module");
		}
		
		if(numOfViolations==2 && typeOfOffence.equalsIgnoreCase("plagiarism") ) {
			System.out.println("Student is not allowed to re-submit and is awarded 0 for the work done");
			System.out.println("WARNING!!!");
			System.out.println("FURTHER VIOLATION OF ACADEMIC INTEGRITY CAN RESULT IN SUSPENSION OF THE STUDENT");
		}
		
		if(numOfViolations==2  && ( typeOfOffence.equalsIgnoreCase("malpractice") ||
				typeOfOffence.equalsIgnoreCase("ghostwrriting") || typeOfOffence.equalsIgnoreCase("collusion") ) ) {
			System.out.println("The student will fail the module");
			System.out.println("WARNING!!!");
			System.out.println("FURTHER VIOLATION OF ACADEMIC INTEGRITY CAN RESULT IN SUSPENSION OF THE STUDENT");
		}
		if(numOfViolations==3) {
			System.out.println("1) The student shall fail the module and also shall be suspended for one semester from the College\n"
					+ "once the academic integrity violation case is confirmed by Institutional Assessment Review Committee.");
			System.out.println("2) During the suspension period, the student shall have to mandatorily complete a course on academic "
					+ "\nintegrity/writing before s/he can register for any modules.");
			System.out.println("3) During the period of suspension, the student shall be allowed to attempt supplementary examinations if "
					+ "\ns/he is eligible for the same. S/he shall also be allowed access to all college facilities permitted for a regular student\n"
					+ " except for registering the modules");
			
		}
		if(numOfViolations==4) {
			System.out.println("1)The student shall fail the module and also shall be expelled from the College, once the case is confirmed by\n"
					+ "Institutional Assessment Review Committee.");
			System.out.println("2)The student shall not be refunded any fees paid for the academic semester in which academic integrity violation was observed");
		}
		else {
			System.out.println("Please enter valid info");
		}
		
		
		
		
		
	}
}

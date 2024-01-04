import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Arrays;

public class FinishFirst {
	
	public static int finishFirst(ArrayList<String[]> schedule) {
		int intervals = 0;
		
		while (schedule.size() > 0) {
			int smallestFinish = 0;
			for (int i = 1; i < schedule.size(); i++) {
				if (Integer.parseInt(schedule.get(i)[1]) < Integer.parseInt(schedule.get(smallestFinish)[1])) {
					smallestFinish = i;
				}
			}
			//System.out.println(Arrays.toString(schedule.get(smallestFinish)));
			int shortestStart = Integer.parseInt(schedule.get(smallestFinish)[1]);
			schedule.remove(smallestFinish);
			while (schedule.size() > 0 && Integer.parseInt(schedule.get(0)[0]) < shortestStart) {
				schedule.remove(0);
			}
			intervals++;
		}
		
		return intervals;
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int instances = scnr.nextInt();
		ArrayList<ArrayList<String[]>> scheds = new ArrayList<ArrayList<String[]>>();
		
		for (int i = 0; i < instances; i++) {
			int numJobs = scnr.nextInt();
			scnr.nextLine();
			ArrayList<String[]> newSched = new ArrayList<String[]>();
			for (int j = 0; j < numJobs; j++) {
				String[] job = scnr.nextLine().trim().split(" ");
				if (newSched.size() == 0) {
					newSched.add(job);
				} else {
					int z = 0;
					while (z < newSched.size() 
							&& Integer.parseInt(newSched.get(z)[0]) 
							< Integer.parseInt(job[0])) {
						z++;
					}
					newSched.add(z, job);
				}
			}
			scheds.add(newSched);
		}
		
		for (int i = 0; i < instances; i++) {
			System.out.println(finishFirst(scheds.get(i)));
			/*
			for (int j = 0; j < scheds.get(i).size(); j++) {
				System.out.print(Arrays.toString(scheds.get(i).get(j)));
			}
			System.out.println();
			*/
		}
		
	}

}

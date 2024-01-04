import java.util.ArrayList;
import java.util.Scanner;

public class FarthestInFuture {

	public static int FF(ArrayList<Integer> cache) {
		int faults = 0;
		int pages[] = new int[cache.get(0)];
		int size = 0;

		for (int i = 1; i < cache.size(); i++) {
			boolean found = false;
			for (int x : pages) {
				if (cache.get(i) == x) {
					found = true;
					break;
				}
			}
			if (!found) {
				faults++;

				int maxDist = 0;
				int furthestIndex = 0;
				for (int x = 0; x < pages.length; x++) {
					if (pages[x] == 0) {
						furthestIndex = x;
						break;
					}
					int j;
					for (j = i + 1; j < cache.size(); j++) {
						if (pages[x] == cache.get(j)) {
							break;
						}
					}
					if (j - i > maxDist) {
						maxDist = j - i;
						furthestIndex = x;
					}
				}
				//System.out.print(pages[furthestIndex] + " ");
				pages[furthestIndex] = cache.get(i);
			}
		}

		return faults;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> caches = new ArrayList<ArrayList<Integer>>();
		Scanner scnr = new Scanner(System.in);
		int instances = scnr.nextInt();

		for (int i = 0; i < instances; i++) {
			caches.add(new ArrayList<Integer>());
			caches.get(i).add(scnr.nextInt());
			int requests = scnr.nextInt();
			for (int j = 0; j < requests; j++) {
				caches.get(i).add(scnr.nextInt());
			}
		}

		for (int i = 0; i < instances; i++) {
			/*
			for (int j = 0; j < caches.get(i).size(); j++) {
				System.out.print(caches.get(i).get(j) + " ");
			}
			System.out.println();
			*/
			System.out.println(FF(caches.get(i)));
		}
	}

}

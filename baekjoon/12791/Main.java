import java.io.*;
import java.util.*;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int[] year = { 1967, 1969, 1970, 1971, 1972, 1973, 1973, 1974, 1975, 1976, 1977, 1977, 1979, 1980, 1983, 1984, 1987,
				1993, 1995, 1997, 1999, 2002, 2003, 2013, 2016 };

		String[] name = { "DavidBowie", "SpaceOddity", "TheManWhoSoldTheWorld", "HunkyDory",
				"TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars", "AladdinSane", "PinUps", "DiamondDogs", "YoungAmericans",
				"StationToStation", "Low", "Heroes", "Lodger", "ScaryMonstersAndSuperCreeps", "LetsDance", "Tonight",
				"NeverLetMeDown", "BlackTieWhiteNoise", "1.Outside", "Earthling", "Hours", "Heathen", "Reality", "TheNextDay",
				"BlackStar" };
		int t, a, b, i, s;

		t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			s = 0;
			for (i = 0; i < 25; i++)
				if (year[i] >= a && year[i] <= b)
					s++;
			sb.append(s + "\n");
			for (i = 0; i < 25; i++)
				if (year[i] >= a && year[i] <= b)
					sb.append(year[i] + " " + name[i] + "\n");
		}


		System.out.println(sb);

		
	}
}
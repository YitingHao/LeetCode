package hard;
/*
 * Question 44:
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character. '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 */
public class WildcardMatching {
	public static void main(String[] args)
	{
		WildcardMatching q44 = new WildcardMatching();
		String s = "ho";
		String p = "ho**";
		System.out.println(q44.isMatch(s, p));
	}
	public boolean isMatch(String s, String p)
	{
		boolean[][] record = new boolean[s.length() + 1][p.length() + 1];		
		int sLength = s.length();
		int pLength = p.length();
		// Initiation
		record[sLength][pLength] = true;		
		for (int col = pLength - 1; col > -1; col --)
		{
			if (p.charAt(col) == '*' && record[sLength][col + 1])
				record[sLength][col] = true;
			else
				break;
		}
		// Fill out record iteratively
		for (int i = sLength - 1; i > -1; i --)
		{
			for (int j = pLength - 1; j > -1; j --)
			{
				if (p.charAt(j) != '*')
				{
					if ((p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') && record[i + 1][j + 1])
						record[i][j] = true;
				}else
				{
					if (record[i][j+1])
						record[i][j] = true;
					else
					{
						for (int k = i + 1; k <s.length() + 1; k ++)
						{
							if (record[k][j + 1])
								record[i][j] = true;
						}
					}
				}
			}
		}
		if (record[0][0])
			return true;
		else
			return false;
	}	
//	}
	// This method I used to solve this questions is similar to "Regular Expression Matching" question.
	// However, this method exceeds time limit
	public boolean isMatch_TimeLimit(String s, String p)
	{
		if (p.length() == 0)
			return s.length() == 0;
		if (p.charAt(0) == '*')
		{
			// boundary case
			if (s.length() <= 1)
				return true;
			int i = 0;
			while (i < s.length())
			{
				if (isMatch_TimeLimit(s.substring(i), p.substring(1)))
					return true;
				i ++;
			}
			return false;
		}else
		{
			if (s.length() == 0)
				return false;
			if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '?')
			{
				if (isMatch_TimeLimit(s.substring(1), p.substring(1)))
					return true;
			}
			return false;
		}
	}
}
package hard;
/*
 * Question 10:
 * Implement regular expression matching with support for '.' and '*'. 
 * '.' Matches any single character and '*' Matches zero or more of the preceding element.
 */
public class RegularExpressionMatching {
	public static void main(String[] args)
	{
		RegularExpressionMatching q10 = new RegularExpressionMatching();
		String s = "aab";
		String p = "c*a*b";
		System.out.println(q10.isMatch(s, p));
	}
	public boolean isMatch(String s, String p)
	{
		if (p.length() == 0)
			return s.length() == 0;
		if (p.length() == 1)
		{
			if (s.length() == 0)
				return false;
			else if (s.length() == 1)
			{
				if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
					return true;
				else
					return false;
			}
			else
				return isMatch(s.substring(1), p.substring(1));
		}
		if (p.charAt(1) != '*')
		{
			if (s.length() < 1)
				return false;
			if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
				return isMatch(s.substring(1), p.substring(1));
			else
				return false;
		}else
		{
			if (isMatch(s, p.substring(2)))
				return true;
			int i = 0;
			while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.'))
			{
				if (isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i ++;
			}
			return false;
		}
	}
}
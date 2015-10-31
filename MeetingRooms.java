package easy;
import java.util.*;
/*
 * Question 252: 
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings. For example, given [[0, 30],[5, 10],[15, 20]], return false.
 */
public class MeetingRooms {
	public boolean canAttenMeetings(Interval[] intervals)
	{
		if (intervals.length <= 1) return true;
		Arrays.sort(intervals,(o1, o2) -> {
			int dif = o1.start - o2.start;
			return dif == 0 ? o1.end - o2.end : dif;
		});
		for (int i = 0; i < intervals.length - 1; i ++)
		{
			if (intervals[i].end > intervals[i + 1].start)
				return false;
		}
		return true;
	}
	public boolean canAttenMeetings_brute(Interval[] intervals)
	{
		for (int i = 0; i < intervals.length - 1; i ++)
		{
			for (int j = i + 1; j < intervals.length; j ++)
			{
				if (!(intervals[j].start >= intervals[i].end || intervals[i].start >= intervals[j].end))
					return false;
			}
		}
		return true;
	}
}
class Interval
{
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
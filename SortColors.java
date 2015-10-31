package medium;
/* 75th Question:
 * Given an array with n objects colored red, white or blue, sort them so that objects of the 
 * same color are adjacent, with the colors in the order red, white and blue. Here, we will 
 * use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */	

public class SortColors {
	public static void main(String[] args)
	{
		SortColors q75 = new SortColors();
		int[] test = new int[]{2,1,2,1,0,1,1,2,1,0};
		q75.sortColors(test);
		for(int i = 0; i < test.length; i ++)
			System.out.print(test[i] + " ");
	}
	void sortColors(int[] nums)
	{
		int highP = 0;
		int lowP = 0;
		for (int i = 0; i < nums.length; i ++)
		{
			if (nums[i] == 0)
			{
				nums[i] = 2;
				nums[highP ++] = 1;
				nums[lowP ++] = 0;
			}else if (nums[i] == 1)
			{
				nums[i] = 2;
				nums[highP ++] = 1;
			}
		}
	}
}
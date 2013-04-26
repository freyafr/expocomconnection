package com.sitronics.data;

public class Solution
{
	private String _name;	
	private String _longDescription;
	private int _image;

	public Solution(String name,					
					String longDescription,
					int image)
	{
		_name = name;		
		_longDescription = longDescription;
		_image = image;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public String getDescription()
	{
		return _longDescription;
	}
	
	public int getImage()
	{
		return _image;
	}
}

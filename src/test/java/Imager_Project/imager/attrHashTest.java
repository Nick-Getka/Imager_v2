package Imager_Project.imager;

import java.util.HashMap;

import org.junit.Test;

import imager.core.attrHash;
import imager.core.attribute;

import static org.junit.Assert.*;

public class attrHashTest{
	@Test
	public void addTest1()
	{
		attrHash testHash= new attrHash();
		attribute test1 = new attribute("Red", .2);
		attribute test2 = new attribute("Green", .3);
		
		testHash.addAttr(test1);
		testHash.addAttr(test2);
		testHash.addAttr("Blue", 1.0);
		testHash.addAttr("Yellow", 0.0);
		
		HashMap<String, Double> temp = testHash.getHmap();
		assertEquals(temp.get("Red"),.2,0);
		assertEquals(temp.get("Green"),.3,0);
		assertEquals(temp.get("Blue"),1.0,0);
		assertEquals(temp.get("Yellow"),0.0,0);
		System.out.println("Empty Test: "+temp.get("Orange"));
	}
}

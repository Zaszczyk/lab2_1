package tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import edu.iis.mto.bsearch.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	@Test	
	public void test_length1_included(){
		int[] seq = { 10 };
		SearchResult result = BinarySearch.search(10, seq);
		
		assertThat(result.isFound(), is(true));
		assertThat(result.getPosition(), is(1));
	}
	
	@Test	
	public void test_length1_notIncluded(){
		int[] seq = { 10 };
		SearchResult result = BinarySearch.search(11, seq);
		
		assertThat(result.isFound(), is(false));
		assertThat(result.getPosition(), is(-1));
	}	
	
	@Test	
	public void test_lengthMoreThan1_isFirst(){
		int[] seq = { 10, 11, 14, 19, 9};
		SearchResult result = BinarySearch.search(10, seq);
		
		assertThat(result.isFound(), is(true));
		assertThat(result.getPosition(), is(1));
	}
	
	@Test	
	public void test_lengthMoreThan1_isLast(){
		int[] seq = {9, 10, 11, 14, 19};
		SearchResult result = BinarySearch.search(19, seq);
		
		assertThat(result.isFound(), is(true));
		assertThat(result.getPosition(), is(5));
	}
	
	@Test	
	public void test_lengthMoreThan1_isCenter(){
		int[] seq = {9, 10, 11, 14, 19};
		SearchResult result = BinarySearch.search(11, seq);
		
		assertThat(result.isFound(), is(true));
		assertThat(result.getPosition(), is(3));
	}
	
	@Test	
	public void test_lengthMoreThan1_notIncluded(){
		int[] seq = {9, 10, 11, 14, 19};
		SearchResult result = BinarySearch.search(20, seq);
		
		assertThat(result.isFound(), is(false));
	}

}

package tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import edu.iis.mto.bsearch.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest {

	@Test	
	public void Search_SeqLength1AndResultIncluded_expectedTrue(){
		int[] seq = { 10 };
		SearchResult result = BinarySearch.search(10, seq);
		
		assertThat(result.isFound(), is(true));
		assertThat(result.getPosition(), is(1));
	}
	
	@Test	
	public void Search_SeqLength1AndResultNotIncluded_expectedFalse(){
		int[] seq = { 10 };
		SearchResult result = BinarySearch.search(11, seq);
		
		assertThat(result.isFound(), is(false));
		assertThat(result.getPosition(), is(-1));
	}	
	
	@Test	
	public void Search_SeqLengthMoreThan1AndResultFirst_expectedTrue(){
		int[] seq = { 10, 11, 14, 19, 9};
		SearchResult result = BinarySearch.search(10, seq);
		
		assertThat(result.isFound(), is(true));
		assertThat(result.getPosition(), is(1));
	}
	
	@Test	
	public void Search_SeqLengthMoreThan1AndResultLast_expectedTrue(){
		int[] seq = {9, 10, 11, 14, 19};
		SearchResult result = BinarySearch.search(19, seq);
		
		assertThat(result.isFound(), is(true));
		assertThat(result.getPosition(), is(seq.length));
	}
	
	@Test	
	public void Search_SeqLengthMoreThan1AndResultOnMiddle_expectedTrue(){
		int[] seq = {9, 10, 11, 14, 19};
		SearchResult result = BinarySearch.search(11, seq);
		
		assertThat(result.isFound(), is(true));
		assertThat(result.getPosition(), is(3));
	}
	
	@Test	
	public void Search_SeqLengthMoreThan1AndResultNotIncluded_expectedFalse(){
		int[] seq = {9, 10, 11, 14, 19};
		SearchResult result = BinarySearch.search(20, seq);
		
		assertThat(result.isFound(), is(false));
	}
	
	@Test	
	public void Search_SeqLengthMoreThan1AndNullAndResultNotIncluded_expectedFalse(){
		int[] seq = {-10, 9, 10, 11, 14, 19};
		SearchResult result = BinarySearch.search(20, seq);
		
		assertThat(result.isFound(), is(false));
	}
	
	@Test	
	public void Search_SeqEmptyAndResultNotIncluded_expectedFalse(){
		int[] seq = { };
		SearchResult result = BinarySearch.search(11, seq);
		
		assertThat(result.isFound(), is(false));
		assertThat(result.getPosition(), is(-1));
	}
	
	@Test	
	public void Search_SeqLength3AndSameElements_expectedTrue(){
		int[] seq = {3, 3, 3};
		SearchResult result = BinarySearch.search(3, seq);
		
		assertThat(result.isFound(), is(true));
		assertThat(result.getPosition(), is(1));
	}

}

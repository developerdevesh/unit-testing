package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.never;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.internal.verification.Times;

public class ListMockTest {

	List<String> mock= mock(List.class);
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	
	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("codeball");
		assertEquals("codeball", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("codeball");
		assertEquals("codeball", mock.get(0));
		assertEquals("codeball", mock.get(1));
	}
	
	
	@Test
	public void verificationBasic() {
		String value1=mock.get(0);
		String value2=mock.get(1);
		verify(mock).get(0);
//		verify(mock).get(anyInt());
		verify(mock,times(2)).get(anyInt());
		verify(mock,never()).get(2);
		
		
	}
	
	@Test
	public void argumentCapturing() {
		
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//verification
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		
		assertEquals("SomeString1", captor.getAllValues().get(0));
		assertEquals("SomeString2", captor.getAllValues().get(1));
		
	}

}

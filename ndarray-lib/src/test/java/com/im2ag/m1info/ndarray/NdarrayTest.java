package com.im2ag.m1info.ndarray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NdarrayTest {

	@Test
	public void initializationTest() {
		double data[][] = {{1,2,3}, {4,5,6}};
		int shape[] = {3, 2};
		Ndarray ndarray_test = new Ndarray(data, 6, 2, shape);
		assertEquals(shape, ndarray_test.shape, "Ndarray initializationTest: shape");
		assertEquals(6, ndarray_test.getSize(), "Ndarray initializationTest: size");
		assertEquals(2, ndarray_test.ndim, "Ndarray initializationTest: ndim");
		for (int i = 0; i < ndarray_test.shape[1]; i++) {
			for (int j = 0; j < ndarray_test.shape[0]; j++) {
				assertEquals(data[i][j], ndarray_test.data[i][j], "Ndarray initializationTest: data");
			}
		}
	}
	
	@Test
	public void addTest() {
		double data1[][] = {{0,1,2}, {3,4,5}};
		double data2[][] = {{0,1,2}, {3,4,5}};
		double expected_result[][] = {{0,2,4}, {6,8,10}};
		
		Ndarray array_1 = Numja.array(data1);
		Ndarray array_2 = Numja.array(data2);
		
		array_1.add(array_2);
		
		for (int i = 0; i < array_1.shape[0]; i++) {
			for (int j = 0; j < array_1.shape[1]; j++) {
				assertEquals(expected_result[i][j], array_1.data[i][j], "Ndarray addTest: data");
			}
		}
	}
	
	@Test
	public void subTest() {
		double data1[][] = {{0,1,2}};
		double data2[][] = {{2.,-1.,4}};
		double expected_result[][] = {{-2, 2, -2}};
		
		Ndarray array_1 = Numja.array(data1);
		Ndarray array_2 = Numja.array(data2);
		
		array_1.sub(array_2);
		
		for (int i = 0; i < array_1.shape[0]; i++) {
			for (int j = 0; j < array_1.shape[1]; j++) {
				assertEquals(expected_result[i][j], array_1.data[i][j], "Ndarray addTest: data");
			}
		}
	}
	
	@Test
	public void mulTest() {
		double data1[][] = {{1,2,3}};
		double data2[][] = {{1}, {2}, {3}};
		
		Ndarray array_1 = Numja.array(data1);
		Ndarray array_2 = Numja.array(data2);
		
		array_1.mul(array_2);
		
		assertEquals(14, array_1.data[0][0]);
		
	}
	
	@Test
	public void getSizeTest() {
		double data1[][] = {{0,1,2}};
		int shape1[] = {3,1};
		Ndarray ndarray_test = new Ndarray(data1, 3, 1, shape1);
		assertEquals(3, ndarray_test.getSize(), "getSizeTest: length 3");
		
		double data2[][] = {{0,1}};
		int shape2[] = {2,1};
		ndarray_test = new Ndarray(data2, 2, 1, shape2);
		assertEquals(2, ndarray_test.getSize(), "getSizeTest: length 2");
		
		
	}
	
	
	
	
	
	
	
}

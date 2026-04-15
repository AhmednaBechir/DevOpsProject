package com.im2ag.m1info.ndarray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumjaTest {

	@Test
	void arrayTest() {
		double[] data = {0,1,2};
		Ndarray ndarray_test = Numja.array(data);
		assertEquals(3, ndarray_test.getSize(), "arrayTest");
	}
	
	@Test
	public void initializationTest() {
		double[][] data = {{1,2,3}, {4,5,6}};
		int[] shape = {2, 3};
		Ndarray ndarray_test = Numja.array(data);
		for (int i = 0; i < 2; i++) {
			assertEquals(shape[i], ndarray_test.shape[i], "Numja initializationTest: shape");
		}
		assertEquals(6, ndarray_test.getSize(), "Numja initializationTest: size");
		assertEquals(2, ndarray_test.ndim, "Numja initializationTest: ndim");
		for (int i = 0; i < ndarray_test.shape[0]; i++) {
			for (int j = 0; j < ndarray_test.shape[1]; j++) {
				assertEquals(data[i][j], ndarray_test.data[i][j], "Numja initializationTest: data");
			}
		}
	}
	
	@Test
	public void zerosTest() {
		int[] shape1 = {3};
		Ndarray zeros_test = Numja.zeros(shape1);
		assertEquals(1, zeros_test.ndim, "Numja zerosTest: ndim 1 dimension");
		assertEquals(1, zeros_test.shape[0], "Numja zerosTest: nombre lignes 1 dimension");
		assertEquals(3, zeros_test.shape[1], "Numja zerosTest: nombre colonnes 1 dimension");
		
		int[] shape2 = {4, 2};
		zeros_test = Numja.zeros(shape2);
		assertEquals(2, zeros_test.ndim, "Numja zerosTest: ndim 2 dimensions");
		assertEquals(4, zeros_test.shape[0], "Numja zerosTest: nombre lignes 2 dimensions");
		assertEquals(2, zeros_test.shape[1], "Numja zerosTest: nombre colonnes 2 dimensions");
		
		
	}
	
	@Test
	public void arangeTest() {
		
	}
	
	@Test
	public void reshapeTest() {
		
	}
	
	@Test
	public void addTest() {
		double[][] data1 = {{0,1,2}, {3,4,5}};
		double[][] data2 = {{0,1,2}, {3,4,5}};
		double[][] expected_result = {{0,2,4}, {6,8,10}};
		
		Ndarray array_1 = Numja.array(data1);
		Ndarray array_2 = Numja.array(data2);
		Ndarray array_add_result = Numja.add(array_1, array_2);
		
		for (int i = 0; i < array_add_result.shape[0]; i++) {
			for (int j = 0; j < array_add_result.shape[1]; j++) {
				assertEquals(expected_result[i][j], array_add_result.data[i][j], "Numja addTest: data");
			}
		}
	}
	
	@Test
	public void subTest() {
		double[] data1 = {0,1,2};
		double[] data2 = {2.,-1.,4};
		double[] expected_result = {-2, 2, -2};
		
		Ndarray array_1 = Numja.array(data1);
		Ndarray array_2 = Numja.array(data2);
		Ndarray array_sub_result = Numja.sub(array_1, array_2);
		
		for (int i = 0; i < array_sub_result.shape[0]; i++) {
			for (int j = 0; j < array_sub_result.shape[1]; j++) {
				assertEquals(expected_result[j], array_sub_result.data[i][j], "Numja subTest: data");
			}
		}
	}
	
	@Test
	public void mulTest() {
		double[][] M1 = {{1,2}, {3,4}, {5,6}};
		double[][] M2 = {{1,2,3}, {4,5,6}};

		double[][] expected_result_M1_M2 = {{9, 12, 15}, {19, 26, 33}, {29, 40, 51}};
		double[][] expected_result_M2_M1 = {{22, 28}, {49, 64}};
		
		Ndarray array_1 = Numja.array(M1);
		Ndarray array_2 = Numja.array(M2);
		Ndarray array_mul_result_1 = Numja.mul(array_1, array_2);
		Ndarray array_mul_result_2 = Numja.mul(array_2, array_1);

		assertEquals(3, array_mul_result_1.shape[0], "Numja mulTest: result1 nombre lignes");
		assertEquals(3, array_mul_result_1.shape[1], "Numja mulTest: result1 nombre colonnes");

		for (int i = 0; i < array_mul_result_1.shape[0]; i++) {
			for (int j = 0; j < array_mul_result_1.shape[1]; j++) {
				assertEquals(expected_result_M1_M2[i][j], array_mul_result_1.data[i][j], "Numja mulTest: data M1 M2");
			}
		}
		
		assertEquals(2, array_mul_result_2.shape[0], "Numja mulTest: result2 nombre lignes");
		assertEquals(2, array_mul_result_2.shape[1], "Numja mulTest: result2 nombre colonnes");

		for (int i = 0; i < array_mul_result_2.shape[0]; i++) {
			for (int j = 0; j < array_mul_result_2.shape[1]; j++) {
				assertEquals(expected_result_M2_M1[i][j], array_mul_result_2.data[i][j], "Numja mulTest: data M2 M1");
			}
		}
	}
	
	@Test
	public void getSizeTest() {
		double[] data1 = {0,1,2};
		Ndarray ndarray_test = Numja.array(data1);
		assertEquals(3, ndarray_test.getSize(), "Numja getSizeTest: length 2");
		
		double[] data2 = {0,1};
		ndarray_test = Numja.array(data2);
		assertEquals(2, ndarray_test.getSize(), "Numja getSizeTest: length 3");
		
		double[][] data3 = {{0,1,2}, {3,4,5}};
		ndarray_test = Numja.array(data3);
		assertEquals(6, ndarray_test.getSize(), "Numja getSizeTest: length 6");
		
		
	}

	@Test
	public void addBadDimensionsTest1() {
		double[][] M1 = {{1,2,3}};
		double[][] M2 = {{4,5,6,7}};
		Ndarray array_1 = Numja.array(M1);
		Ndarray array_2 = Numja.array(M2);
		
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.add(array_1, array_2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.add(array_2, array_1);
		});
	}
	
	@Test
	public void addBadDimensionsTest2() {
		double[][] M1 = {{1,2,3}, {4,5,6}};
		double[][] M2 = {{1,2,3}, {4,5,6}, {7,8,9}};
		Ndarray array_1 = Numja.array(M1);
		Ndarray array_2 = Numja.array(M2);
		
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.add(array_1, array_2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.add(array_2, array_1);
		});
	}
	
	@Test
	public void subBadDimensionsTest1() {
		double[][] M1 = {{1,2,3}};
		double[][] M2 = {{4,5,6,7}};
		Ndarray array_1 = Numja.array(M1);
		Ndarray array_2 = Numja.array(M2);
		
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.sub(array_1, array_2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.sub(array_2, array_1);
		});
	}
	
	@Test
	public void subBadDimensionsTest2() {
		double[][] M1 = {{1,2,3}, {4,5,6}};
		double[][] M2 = {{1,2,3}, {4,5,6}, {7,8,9}};
		Ndarray array_1 = Numja.array(M1);
		Ndarray array_2 = Numja.array(M2);
		
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.sub(array_1, array_2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.sub(array_2, array_1);
		});
	}
	
	@Test
	public void mulBadDimensionsTest1() {
		double[][] M1 = {{1}, {2}, {3}};
		double[][] M2 = {{1,2,3,4}, {5,6,7,8}};
		Ndarray array_1 = Numja.array(M1);
		Ndarray array_2 = Numja.array(M2);
		
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.mul(array_1, array_2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.mul(array_2, array_1);
		});
	}
	
	@Test
	public void mulBadDimensionsTest2() {
		double[][] M1 = {{1,2,3}};
		double[][] M2 = {{4,5,6}};
		Ndarray array_1 = Numja.array(M1);
		Ndarray array_2 = Numja.array(M2);
		
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.mul(array_1, array_2);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.mul(array_2, array_1);
		});
	}
	
	@Test
	public void zeros0dimensionsTest() {
		int[] dim = {0,0};
		assertThrows(IllegalArgumentException.class, () -> {
			Numja.zeros(dim);
		});
	}
}

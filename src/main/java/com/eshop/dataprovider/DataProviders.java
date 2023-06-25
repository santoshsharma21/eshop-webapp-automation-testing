/**
 * 
 */
package com.eshop.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.eshop.utils.ExcelUtils;

/**
 * @author Santosh Sharma
 *
 */
public class DataProviders {

	static String path = System.getProperty("user.dir") + "/src/test/resources/testdata/login_data.xlsx";

	@DataProvider(name = "loginCredentials")
	public static String[][] getLoginData() throws IOException {

		ExcelUtils xlutils = new ExcelUtils(path);
		int nrows = xlutils.getRowCount("Sheet1");
		int ncells = xlutils.getCellCount("Sheet1", nrows);

		String[][] data = new String[nrows][ncells];

		for (int row = 1; row <= nrows; row++) {
			for (int cell = 0; cell < ncells; cell++) {
				data[row - 1][cell] = xlutils.getCellData("Sheet1", row, cell);
			}
		}
		return data;
	}

	@DataProvider(name = "data_true_true")
	public static String[][] getLoginData1() throws IOException {

		ExcelUtils xlutils = new ExcelUtils(path);
		int nrows = xlutils.getRowCount("Sheet2");
		int ncells = xlutils.getCellCount("Sheet2", nrows);

		String[][] data = new String[nrows][ncells];

		for (int row = 1; row <= nrows; row++) {
			for (int cell = 0; cell < ncells; cell++) {
				data[row - 1][cell] = xlutils.getCellData("Sheet2", row, cell);
			}
		}
		return data;
	}

	@DataProvider(name = "data_true_false")
	public static String[][] getLoginData2() throws IOException {

		ExcelUtils xlutils = new ExcelUtils(path);
		int nrows = xlutils.getRowCount("Sheet3");
		int ncells = xlutils.getCellCount("Sheet3", nrows);

		String[][] data = new String[nrows][ncells];

		for (int row = 1; row <= nrows; row++) {
			for (int cell = 0; cell < ncells; cell++) {
				data[row - 1][cell] = xlutils.getCellData("Sheet3", row, cell);
			}
		}
		return data;
	}

	@DataProvider(name = "data_false_true")
	public static String[][] getLoginData3() throws IOException {

		ExcelUtils xlutils = new ExcelUtils(path);
		int nrows = xlutils.getRowCount("Sheet4");
		int ncells = xlutils.getCellCount("Sheet4", nrows);

		String[][] data = new String[nrows][ncells];

		for (int row = 1; row <= nrows; row++) {
			for (int cell = 0; cell < ncells; cell++) {
				data[row - 1][cell] = xlutils.getCellData("Sheet4", row, cell);
			}
		}
		return data;
	}

	@DataProvider(name = "data_false_false")
	public static String[][] getLoginData4() throws IOException {

		ExcelUtils xlutils = new ExcelUtils(path);
		int nrows = xlutils.getRowCount("Sheet5");
		int ncells = xlutils.getCellCount("Sheet5", nrows);

		String[][] data = new String[nrows][ncells];

		for (int row = 1; row <= nrows; row++) {
			for (int cell = 0; cell < ncells; cell++) {
				data[row - 1][cell] = xlutils.getCellData("Sheet5", row, cell);
			}
		}
		return data;
	}
}

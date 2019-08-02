package com.qdu.test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.SocketTimeoutException;
import java.sql.SQLException;
import java.text.NumberFormat;

import jxl.*;
import jxl.read.biff.BiffException;

/**
 * @author lidcha
 * @createDate ：2019年7月23日
 */
public class Main {
	public static void main(String[] args) throws SQLException {
		double[][] array = { { 31075, 16.5, 117.138386517297, 36.6667662168931, 59, 85.8 },
				{ 30542, 16.4, 117.138385251038, 36.6667634187423, 50, 85.8 },
				{ 29848, 18.9, 117.138388938996, 36.6667646090718, 40.5, 80 },
				{ 29774, 18.8, 117.13839133794, 36.6667638298979, 30.5, 80 },
				{ 29318, 20.7, 117.138386288411, 36.6667631482726, 20.5, 72.9 },
				{ 28841, 22.3, 117.13838423627, 36.6667630504485, 20, 71.6 },
//				{ 28554, 22.2, 117.138385076564, 36.6667647835984, 11, 53.4 },
				{ 27798, 23, 117.138379160555, 36.6667725920874, 6.40000009536743, 34.9 } };

		double c = 111319.5;
		double Altitude = 0.0;
		double latB = 0.0, lonB = 0.0, latA = 0.0, lonA = 0.0;
		double β = 0.0, θ = 0.0;
		double reallonB = 117.138412272135, reallatB = 36.6667654079861;
		BigDecimal countlonB = new BigDecimal(Double.valueOf(0.0)),countlatB= new BigDecimal(Double.valueOf(0.0));
		for (int i = 0; i < 7; i++) {
			β = array[i][1];
			lonA = array[i][2];
			latA = array[i][3];
			Altitude = array[i][4];
			θ = array[i][5];
			System.out.println("LocationID：" + array[i][0]);
			System.out.println("航向角β：" + β);
			System.out.println("无人机经度：" + lonA);
			System.out.println("无人机纬度：" + latA);
			System.out.println("无人机高度：" + Altitude);
			System.out.println("镜头下倾角：" + θ);
			latB = latA + (Altitude / Math.tan(θ)) * Math.cos(β) / c;
			lonB = lonA + (Altitude / Math.tan(θ)) / (c * Math.cos(latB));
			System.out.println(lonB + "----" + latB);
			BigDecimal bg1 = new BigDecimal(reallonB - lonB+"");
			BigDecimal bg2 = new BigDecimal(reallatB - latB+"");
			BigDecimal templon = bg1.abs().multiply(new BigDecimal(111319.5*Math.abs(Math.cos(latB))));
			BigDecimal templat = bg2.abs().multiply(new BigDecimal(111319.5));
			countlonB = countlonB.add(templon);
			countlatB = countlatB.add(templat);
			System.out.println("经度误差：" + templon);
			System.out.println("纬度误差：" + templat);
			System.out.println("----------------------------------");
		}
		System.out.println(countlonB+"-----"+countlatB);
//		System.out.printf("经度平均误差："+countlonB.divide(new BigDecimal(Double.valueOf(6))), 10, RoundingMode.HALF_DOWN);
//		System.out.println();
//		System.out.printf("纬度平均误差："+countlatB.divide(new BigDecimal(Double.valueOf(6))), 10, RoundingMode.HALF_DOWN);
	}

}

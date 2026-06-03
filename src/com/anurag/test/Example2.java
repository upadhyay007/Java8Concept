package com.anurag.test;

import java.lang.module.ResolutionException;

public class Example2 {
	public static void main(String[] args) {
		try {
			System.out.println('A');
			try {
			System.out.println('B');
			throw new ResolutionException();
			} finally {
				System.out.println('C');
			}

		} catch (Exception e) {
			System.out.println('D');
			// TODO: handle exception
		}finally {
			System.out.println('E');
			
		}
	}
}

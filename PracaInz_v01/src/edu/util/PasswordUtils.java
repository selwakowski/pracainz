package edu.util;

import com.lambdaworks.crypto.SCryptUtil;

public class PasswordUtils {
	
	/*
	 * Metoda koduje haslo, ktore w bazie danych przechowywane jest w formie niejawnej,
	 * jezeli uzytkownik wpisze haslo to nawet administrator czy autor kodu, ktory ma dostep
	 * do bazy danych nie moze hasla podejzec, po przechowywana jest tam jego zakodowana forma.
	 * Sprawdzenie hasla polega na zakodowaniu podanego hasla i porownania ich zakodowanych wersji.
	 */
	public static String hashPassword(String originalPassword) {
        return SCryptUtil.scrypt(originalPassword, 16, 16, 16);		
	}
	
	public static boolean isPasswordMatch(String password, String passwordHashed) {
		return SCryptUtil.check(password, passwordHashed);
	}
}

package es.ieslavereda.exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size,passwordLength;
        Password[] passwords;
        boolean[] isPasswordsStrong;

        System.out.println("Enter the size of the array:");
        size= scanner.nextInt();

        System.out.println("Enter the length of the passwords:");
        passwordLength = scanner.nextInt();

        passwords = new Password[size];
        isPasswordsStrong = new boolean[passwords.length];

        for(int i=0;i<passwords.length;i++){
            passwords[i]=new Password(passwordLength);
            isPasswordsStrong[i]= passwords[i].isStrong();
        }

        for(int i=0;i<passwords.length;i++){
            System.out.println(isPasswordsStrong[i] +" -> " + passwords[i]);
        }

    }
}

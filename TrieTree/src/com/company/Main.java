package com.company;

import java.util.Scanner;

public class Main {
    static Node root = new Node();
    
    static class Node {
        Node  childNode[] = new Node[27];
        boolean flag;
        
        Node() {
            flag = false;
            for( Node i : childNode ) {
                i = null;
            }
        }
    }
    
    static void insert( String word) {
        Node current  = root;
        int len = word.length();
        
        for( int i = 0; i < len; i++) {
            int index = word.charAt(i)-'a';
            if( current.childNode[index] == null) {
                current.childNode[index] = new Node();
            }
            current = current.childNode[index];
        }
        current.flag = true;
    }
    
    static boolean search(String word) {
        Node current  = root;
        int len = word.length();
    
        for( int i = 0; i < len; i++) {
            int index = word.charAt(i)-'a';
            if( current.childNode[index] == null) {
                return false;
            }
            current = current.childNode[index];
        }
        return (current != null && current.flag);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = 0;
        while( n!=3 ) {
            System.out.println("Choose the operation to do:\n \t1. Inserta a word. \t2. Search a word. \t3. EXIT the process");
            n = sc.nextInt();
            //sc.nextLine();   //if want to ue this line then use sc.nextLine()
            if(n==1) {
                String s;
                System.out.println("Enter the word to be added to the library.");
                s = sc.next();
                insert(s);
            }
            else if(n==2) {
                String s;
                System.out.println("Enter the word to be search in the library.");
                s = sc.next();
                boolean pos = search(s);
                System.out.println( pos? "Word found\n":"Word not found.\n");
            }
            else if(n==3) {
                break;
            }
            else {
                System.out.println("Wrong choice. Choose the correct option.");
            }
        }
    }
}

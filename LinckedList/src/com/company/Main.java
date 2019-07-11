package com.company;

import java.util.Scanner;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    private static Node root = null;
    static class Node { //structure of the elements
        int roll;
        String name;
        Node next;
    }

    // Creat the list
    private void creatNew() {
        if(root != null) {
            System.out.println("The is already a  list.");
            return;
        }
    
        System.out.print("Enter the number of elements: ");
        int n;
        n = sc.nextInt();
        Node current = null;
        for(int i=1;i<=n;i++) {
            Node newNode = new Node();
            System.out.print("Enter the roll and name of element "+ i+": ");
            newNode.roll = sc.nextInt();
            newNode.name = sc.nextLine();
            if (root ==  null) {
                root = newNode;
                current = root;
            }
            else {
                if(current != null) {
                    current.next = newNode;
                }
                current = current.next;
            }
        }
    }

    // printing the elements of the link list
    private void showList() {
        if(root == null) {
            System.out.println("The list is empty.");
            return;
        }
    
        Node current = root;
        while(current!=null) {
            System.out.println("Roll: "+ current.roll+" "+"Name: "+current.name);
            current = current.next;
        }
    }

    //insert an element after any element
    private void insert() {
        if(root == null) {
            System.out.println("The list is empty.");
            return;
        }
    
        int roll;
        System.out.print("Enter the target ahead roll number :");
        roll = sc.nextInt();
        Node current = root;
        while( current != null && current.roll != roll)
            current = current.next;
    
        if(current == null)
            System.out.println("Element can't be found;");
        else {
            Node newNode = new Node();
            System.out.print("Enter the roll and name: ");
            newNode.roll = sc.nextInt();
            newNode.name = sc.nextLine();
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    //Delete any specific element
    private void deleteElement() {
        if(root == null) {
            System.out.println("The list is empty.");
            return;
        }
    
        int roll;
        System.out.println("Enter the node you want to delete.");
        roll = sc.nextInt();
        if( root.roll == roll) {
            root = root.next;
            return;
        }
    
        Node current = root, previous = null;
        while(current.roll != roll) {
            previous = current;
            current = current.next;
        }
    
        if(current == null)
            System.out.println("Element can't be found;");
        else
            previous.next = current.next;
    }
    private void deleteList()// Delete the whole list
    {
        if(root == null) {
            System.out.println("The list is already empty.");
            return;
        }
        
        root = null;
    }

    public static void main(String[] args) {
        Main list = new Main();
        int tp = 0;
        while(true) {
            System.out.println("Choose the correct option: 1. CreateNewList 2. DeleteList " +
                    "3. InsertElement 4. DeleteElement 5. ShowList 6. EndProcess");
            tp = sc.nextInt();
            switch(tp) {
                case 1:
                    list.creatNew();
                    break;
                case 2:
                    list.deleteList();
                    break;
                case 3:
                    list.insert();
                    break;
                case 4:
                    list.deleteElement();
                    break;
                case 5:
                    list.showList();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Wrong input choice. Choose the correct option.");
            
            }
        }
    }
}

/*
5
1 hello
2 world
3 helloworld
5 by
4 hi
* */
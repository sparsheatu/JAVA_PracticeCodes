/*
 * Author: Azijur Rahman Sheatu
 * GitHub: https://github.com/sparsheatu
 * Email: hellomyworld2016@gmail.com
 * FBook: https://www.facebook.com/profile.php?id=100008181334534
 */

import java.util.*;

public class KMP {
    static Scanner sc =  new Scanner(System.in);
    static int[] failour = new int[100005];

    static void calculate_failour(String pattern) {
        failour[0] = 0;
        failour[1] = 0;
        int len = pattern.length();

        for ( int i = 2; i<=len ; i++) {
            int j = failour[i-1];

            while (true) {
                if ( pattern.charAt(i-1) == pattern.charAt(j) ) {
                    i++;
                    j++;
                    failour[i] = j + 1;
                    break;
                }

                if ( j == 0) {
                    failour[i] = 0;
                    break;
                }

                j = failour[j];
            }
        }
    }

    static boolean kmp( String text, String pattern) {
        int len_text = text.length(), len_pattern = pattern.length();
        calculate_failour(pattern);
        int i = 0, j =0;

        while ( i != len_text ) {
            if ( text.charAt(i) == pattern.charAt(j) ) {
                i++;
                j++;
                if (j == len_pattern) return true;
            }
            else {
                if ( j == 0 ) i++;
                else
                    j = failour[j];
            }
        }

        return  false;
    }

    public static void main(String[] args) {
        String text, pattern;
        System.out.print("Enter the text where you want to find the pattern: ");
        text = sc.nextLine();
        System.out.print("Enter the pattern you want to find in text: ");
        pattern = sc.nextLine();
        boolean ispresent = kmp(text, pattern);
        if (ispresent)
            System.out.println("The pattern is found.");
        else
            System.out.println("The pattern isn't found.");

    }
}

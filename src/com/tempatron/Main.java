package com.tempatron;


public class Main {

    public static void main(String[] args) {
        String string = "I am a String. Yes I am";
        System.out.println(string);

        //replace all method accepts a RE
        String yourString = string.replaceAll("I", "U");
        System.out.println(yourString);


        //  " . "  REGEX character class matches any character
        //Anchors do not match any characters. They match a position.
        // ^ matches at the start of the string, and $ matches at the end
        // of the string. Most regex engines have a "multi-line" mode
        // that makes ^ match after any line break, and $ before any
        // line break. E.g. ^b matches only the first b in bob.

        String alphanumeric = "abcDeeF12ghiijkk665z";
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        System.out.println(alphanumeric.replaceAll("^abcDee", "YYY"));

        String secondString = "abcDeeF12ghiabcDeeijkk665z";
        System.out.println(secondString.replaceAll("^abcDee*", "YYY"));


        // matches returns true/false otherwise
        //here string as a whole is to be matched to the RE
        System.out.println(alphanumeric.matches("^hello"));
        System.out.println(alphanumeric.matches("^abcDee"));
        System.out.println(alphanumeric.matches("^abcDeeF12ghiijkk665z"));


        System.out.println(alphanumeric.replaceAll("kk665z$", "THE_END"));

        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        System.out.println(alphanumeric.replaceAll("[aei]", "I Replaced a letter here "));

        // any letter a or e or i is followed by an F or an J
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "0"));

        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeF12ghiijkk665z";

        // ^ in square bracket is character class not a boundary matcher
        // [^ej] will match all occurrences that are not e or j
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "x"));
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "x"));
        System.out.println(newAlphanumeric.replaceAll("[a-f3-8]","x"));
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]","x"));
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]","x"));
        //(?i) makes it match case insensitive
        System.out.println(newAlphanumeric.replaceAll("[0-9]","x"));
        System.out.println(newAlphanumeric.replaceAll("\\d","x"));
        System.out.println(newAlphanumeric.replaceAll("\\D","x"));

        String hasWhiteSpace = "I have blanks and\ta tab and also a newline\n";
        System.out.println(hasWhiteSpace);

        //using reg to remove all white space using char class
        System.out.println(hasWhiteSpace.replaceAll("\\s",""));

        System.out.println(hasWhiteSpace.replaceAll("\\t",""));
        System.out.println(hasWhiteSpace.replaceAll("\t",""));

        //REPLACING ALL NON WHITE SPACE CHARACTERS,only tab spaces and newline remain
        System.out.println(hasWhiteSpace.replaceAll("\\S","0"));
        System.out.println(hasWhiteSpace.replaceAll("[a-zA-Z0-9]","0"));

        //another char class \w matches a-z A-Z 0-9 and underscore(_)
        System.out.println(hasWhiteSpace.replaceAll("\\w","x"));

        //capital W will be the reverse. so it will replace whitspaces
        System.out.println(hasWhiteSpace.replaceAll("\\W","x"));


        //each word is surrounded by replacement string
        System.out.println(hasWhiteSpace.replaceAll("\\b","x"));
    }
}
package com.tempatron;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

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



        //     . = The dot matches a single character, except line break characters. Most applications have a "dot matches all" or "single line" mode that makes the dot match any single character, including line breaks.
        //     + = means 1 or more occurrences/ any number of preceding character is allowed, here any number of e
        //     * = 0 more occurrences

        //from stackoverflow
//        . means "any character".
//        * means "any number of this".
//        .* therefore means an arbitrary string of arbitrary length.
//        ^ indicates the beginning of the string.
//         $ indicates the end of the string.

        String alphanumeric = "abcDeeF12ghiijkk665z";
        System.out.println("Dot wala");
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        System.out.println(alphanumeric.replaceAll("^abcDee", "YYY"));

        String secondString = "abcDeeF12ghiabcDeeijkk665z";
        System.out.println(secondString.replaceAll("^abcDee", "YYY"));


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

        String thirdAlphaNumeric = "abcDeeeeeF12hhhhiiiijghiabcDeeijkk665z";
        System.out.println(thirdAlphaNumeric.replaceAll("^abcDe{3}", "YYY"));
        //Quantifiers {} specify how often an element can occur in a RE\

        System.out.println("plus wala");
        System.out.println(thirdAlphaNumeric.replaceAll("^abcDe+", "YYY"));
        // + means 1 or more occurrences/ any number of preceding character is allowed, here any number of e

        //String followed by A B C D and then 0 or more e's
        System.out.println("* wala");
        System.out.println(thirdAlphaNumeric.replaceAll("^abcDe*", "YYY"));

        System.out.println(thirdAlphaNumeric.replaceAll("^abcDe{2,5}", "YYY"));
        //{2,5} means accept the previous character(e)  2 - 5 times and replace

        System.out.println(thirdAlphaNumeric.replaceAll("h+i*j","Y"));



        StringBuilder htmlText = new StringBuilder("<h1> My heading</h1>");
        htmlText.append("<h2>Sub-Heading</h2>");
        htmlText.append("<p> This is a paragraph of text</p>");
        htmlText.append("<p> This is a paragraph about cats/p>");
        htmlText.append("<h2> HELLO </h2>");
        htmlText.append("<p>Thank you for reading/p>");


       // String h2Pattern = ".*<h2>.*";///RE  here . matches every character and * means 0 or more!
        //its case sensitive
       // Pattern p = Pattern.compile(h2Pattern, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        //String h2Pattern = "h2"; //changing RE the occurrence part as the above one doesn't work here and gives only 1 occurrence

        String h2Pattern = "<h2>"; // changing for groups

        Pattern p = Pattern.compile(h2Pattern);

        Matcher matcher = p.matcher(htmlText);

        System.out.println(matcher.matches());



        //finding occurrences and where they occur
        //start returns index of 1st character in the match.
        //end return the index of the character right after the character in the match

        //WE CAN ONLY USE A MATCHER ONCE
        //So we have to reset the MATCHER

        matcher.reset();
        int count = 0;
        while(matcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " +matcher.start() + " to "
            +matcher.end());
        }


        //groups help find multiple occurrences
        System.out.println("----------GROUPS----------");

        /*String h2GroupPattern = "(<h2>.+?</h2>)";*/ //if we don't want empty h2 starting and closing tags
         String h2GroupPattern = "(<h2>.*?</h2>)";//we grouped it here
        // * is greedy quantifier looks ahead
        // we to convert this to a lazy quantifier which is a '?'
        //so we append it after the greedy quantifier *

        Pattern groupPattern = Pattern.compile(h2GroupPattern);

        Matcher groupMatcher = groupPattern.matcher(htmlText);

        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()){
            System.out.println("Occurrence " +groupMatcher.group(1));
        }


        //printing without h2 tags
        String h2TextGroups = "(<h2>)(.+?)(</h2>)"; //3 groups
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);

        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()){
            System.out.println("Occurrence " +h2TextMatcher.group(2));
        }

        //[Hh]arry
        System.out.println("harry".replaceAll("[Hh]arry","Larry"));
        System.out.println("harry".replaceAll("[H|h]arry","Larry"));
        //using or

        //[^abc]  ^ here in brackets means not
        String tvTest = "tstvtkt";
        /*String tNotVRegExp = "t[^v]";*/
        String tNotVRegExp = "t(?=v)"; // t which does not have v ahead of it
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()){
            System.out.println("Occurrence " +count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }  //final t in line 196 isn't matched

        // ^([\(]{1}[0-9]{3}[\)]{1}[ ]{1}[0-9]{3}[\-]{1}[0-9]{4})$
        //^ american number RE (800) 342-2323   ^^

        String phone1 = "1234567890";  // Shouldn't match
        String phone2 = "(123) 456-7890"; // match
        String phone3 = "123 456-7890"; // Shouldn't match
        String phone4 = "(123)456-7890"; // Shouldn't match

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));


        System.out.println();
        //RE To validate a visa card number
        // ^4[0-9]{12}([0-9]{3})?$
        //  the group in () is optional .. ? matches 0 or 1 occurrences.

        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));


    }
}
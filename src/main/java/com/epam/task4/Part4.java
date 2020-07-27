package com.epam.task4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {

    public static void main(String[] args) {

        SentenceIterator sentenceIterator = new SentenceIterator();
        while(sentenceIterator.hasNext()){
            System.out.println(sentenceIterator.next());
        }

    }

    private static class SentenceIterator implements Iterator<String>{
        Logger log = Logger.getLogger(SentenceIterator.class.getName());
        String input = Part1.getInput("part1.txt");
        Pattern pattern = Pattern.compile("\\p{Lu}[^.!?]+\\.", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(input);
        boolean hasNext = matcher.find();

        @Override
        public boolean hasNext(){
            return hasNext;
        }

        @Override
        public String next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            String next = matcher.group();
            hasNext = matcher.find();
            return next;
        }

        @Override
        public void remove(){
            throw new NoSuchElementException();
        }

    }

}

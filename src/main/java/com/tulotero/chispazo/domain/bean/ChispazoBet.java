package com.tulotero.chispazo.domain.bean;

import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class ChispazoBet {

    static int TOTAL_SELECTIONS = 5;
    static int MIN_VALUE = 1;
    static int MAX_VALUE = 28;
    static String INVALID_LIST_SIZE = "The list must contain %s numbers";
    static String INVALID_SELECTION = "The list must contain different numbers";
    static String INVALID_RANGE = "The list must contain numbers between %s and %s";
    List<Integer> numbers;

    public ChispazoBet(List<Integer> numbers) throws IllegalArgumentException {
        checkRequest(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    private void checkRequest(List<Integer> numbers) {
        if(!numbers.isEmpty() && numbers.size()==TOTAL_SELECTIONS){
            checkBusinessRule(numbers);
        }else{
            throw new IllegalArgumentException(String.format(INVALID_LIST_SIZE,TOTAL_SELECTIONS));
        }
    }

    private void checkBusinessRule(List<Integer> numbers) {
        // Check distinct
        int distinct = (int) numbers.stream().distinct().count();
        if(TOTAL_SELECTIONS!=distinct){
            throw new IllegalArgumentException(INVALID_SELECTION);
        }
        //Check range
        if(!numbers.stream().allMatch(integer -> integer<=MAX_VALUE && integer>=MIN_VALUE)){
            throw new IllegalArgumentException(String.format(INVALID_RANGE,MIN_VALUE,MAX_VALUE));
        }
    }
}

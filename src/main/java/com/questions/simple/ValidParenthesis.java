package com.questions.simple;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class ValidParenthesis {

    private final Stack<String> parenthesisStack = new Stack<>();

    public boolean isValid(String parenthesis){
        return Optional.ofNullable(parenthesis).map((str) -> this.isValidParenthesis.test(str)).orElse(false);
    }

    private Predicate<String> isValidParenthesis = (parenthesis) -> parenthesis.chars().mapToObj(this.convertIntToString).allMatch(this.validateParenthesis) && this.parenthesisStack.empty();

    private final Supplier<Map<String, String>> parenthesisMap = () -> new HashMap<>(){
        {
            put("(",")");
            put("{","}");
            put("[","]");
        }
    };

    private final Supplier<String> popFromStack = () -> {
        if(!this.parenthesisStack.empty()){
            return this.parenthesisStack.pop();
        }
        return "";
    };

    private final Consumer<String> pushInStack = (parenthesis) ->{
        parenthesisStack.add(parenthesis);
    };

    private IntFunction<String> convertIntToString = (digit) -> String.valueOf((char)digit);

    private Predicate<String> validateParenthesis = (parenthesis) -> {
        if(!this.containsParenthesis.test(parenthesis)){
            return parenthesis.equals(this.parenthesisMap.get().get(this.popFromStack.get()));
        }
        this.pushInStack.accept(parenthesis);
        return true;
    };

    private final Predicate<String>  containsParenthesis = (parenthesis) -> this.parenthesisMap.get().get(parenthesis)!=null;
}

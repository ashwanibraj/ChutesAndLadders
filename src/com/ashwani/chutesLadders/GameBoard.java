package com.ashwani.chutesLadders;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameBoard {
	static final int WINNING_SQUARE = 100;
	
	static final Map<Integer, Integer> CHUTES;
    static {
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        temp.put(16, 6);
        temp.put(47, 26);
        temp.put(49, 11);
        temp.put(56, 53);
        temp.put(62, 19);
        temp.put(64, 60);
        temp.put(87, 24);
        temp.put(93, 73);
        temp.put(95, 75);
        temp.put(98, 78);
        CHUTES = Collections.unmodifiableMap(temp);
    }
    
    static final Map<Integer, Integer> LADDERS;
    static {
    	Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
    	temp.put(1, 38);
    	temp.put(4, 14);
        temp.put(9, 31);
        temp.put(21, 42);
        temp.put(28, 84);
        temp.put(36, 44);
        temp.put(51, 67);
        temp.put(71, 91);
        temp.put(80, 100);
        LADDERS = Collections.unmodifiableMap(temp);
    }
}

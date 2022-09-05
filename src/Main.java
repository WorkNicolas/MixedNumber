import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    static BigDecimal finalResult = new BigDecimal("0");

    static boolean check(short[] checks) {
        boolean isContinues = true;
        int index = -1;
        for (short ind : checks) {
            index++;
            if (ind==1) {

            }
            else if (ind==0) {
                isContinues = false;
                break;
            }
            else if (ind==-1) {
                if (index==0) {
                    isContinues = false;
                }
                break;
            }
        }

        return isContinues;
    }
    static int[] analyzeDecimal() { // will return int[3]
        int[] analysis = new int[3];
        int dot = finalResult.toString().indexOf(".");
        String num = finalResult.toString();
        int state = -1;
        int firstPart = 0; // first part will be compared with each secondPart!
        int secondPart = 0; 
        String part = ""; // without the dot
        int index = 0; // index for every loop!
        int loop = 6;
        int originalLoop = loop;
        int size = 0; // until six!
        int ps = -1;
        short[] checks = new short[] {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1}; // 10 compares for each part!
        // length of checks is 10!
        int continues = -1; // -1 means there is no continues part!
        boolean stop = false;
        while (true) { // while for size!
            if (size!=6) {
            while (true) { // we need to compare a part with a part!
                // while for loop
                // 6 loops, every loop will increase the compared part by 1!
                if (loop!=-1) { // TODO : check every part with the increasing pos
                    firstPart = dot+1+(originalLoop-loop); // changed
                    try {
                        part = num.substring(firstPart, firstPart+(size+1));
                    }
                    catch (StringIndexOutOfBoundsException ex) {
                        break;
                    }
                    int partSize = part.length();
                    int afterDecimal = num.length()-(dot+1);
                    while (index!=checks.length && 
                        firstPart+partSize+index*partSize-(dot+1)<=afterDecimal) { // while for index!
                        secondPart = firstPart+partSize+index*partSize;
                        String comparedPart;
                        try {
                            comparedPart = num.substring(secondPart, secondPart+partSize);
                        }
                        catch (StringIndexOutOfBoundsException ex) {
                            break;
                        }
                        if (part.equals(comparedPart)) {
                            checks[index] = 1;
                        }
                        else {
                            checks[index] = 0;
                        }
                        index++;
                    }
                    index = 0;
                    if (check(checks)) {
                        stop = true;
                        continues = firstPart;
                        ps = partSize;
                    }
                    for (int i = 0 ; i!=10 ; i++) {
                        checks[i] = -1;
                    }
                }
                else { // finished!
                    break;
                }
                loop--;
                if (stop) {
                    break;
                }
            }
            loop = originalLoop;
            size++;
            if (stop) {
                break;
            }
            }
            else {
                break;
            }
        }
        if (continues==-1) {
            state = 2;
        }
        else {
            if (dot+1==continues) {
                state = 1;
            }
            else {
                state = 0;
            }
        }
        analysis[0] = state;
        analysis[1] = continues;
        analysis[2] = ps;

        return analysis;
    }
    static String convertToStandard() {
        // determine the state first : 
        int[] analysis = analyzeDecimal();
        int dot = finalResult.toString().indexOf('.')+1;
        int continues = analysis[1];
        int partSize = analysis[2]; // how many steps after the continues part
        if (analysis[0]==0) { // constant + continues
            String number = finalResult.toString().substring(0, continues+partSize);
            int numOfConst = continues-dot;
            int numOfDecimals = continues+partSize-dot;
            int den = (int)(Math.pow(10, numOfDecimals)-Math.pow(10, numOfConst)); // (10^numOfDecimals)-(10^numOfConst);
            int num;
            int toSubtract = Integer.parseInt(number.substring(0, dot-1)+number.substring(dot, dot+numOfConst));
            if (number.charAt(0)==0) {
                num = Integer.parseInt(number.substring(dot));
            }
            else {
                
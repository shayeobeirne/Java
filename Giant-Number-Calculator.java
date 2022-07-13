import java.util.ArrayList;
/**
 * Filename: GinormInt.java
 * Description: A calculator that takes in two very long numbers and can perform additive and subtractive methods.
 * Author: Shaye O'Beirne
 * Date: 4/10/21
 */

public class GinormInt implements Comparable<GinormInt> {
    public static GinormInt ZERO = new GinormInt("0");
    public static GinormInt ONE = new GinormInt("1");
    public static GinormInt TEN = new GinormInt("10");
    public static String sumSign;
    public static String diffSign;
    public int[] number;
    public int length;
    public String sign;

    public GinormInt(String value) {
        if (value.startsWith("-") == true) {
            this.sign = "negative";
            value = value.replace("-", "");
        } else {
            this.sign = "positive";
        }
        this.length = value.length();
        this.number = new int[value.length()];
        for (int i = value.length() - 1; i > -1; i--) {
            var a = value.charAt(value.length() - 1 - i);
            if (a != '0' && a != '1' && a != '2' && a != '3' && a != '4') {
                if (a != '5' && a != '6' && a != '7' && a != '8' && a != '9') { 
                    throw new NumberFormatException("Sorry, all characters must be decimal digit or sign characters.");
                }
            }
            int x = Integer.parseInt(String.valueOf(value.charAt(value.length() - 1 - i)));
            number[i] = x;
        }

    }

    public GinormInt plus(GinormInt otherInt) {
        var firstInt = this.number;
        var firstIntSign = this.sign;
        var firstIntLength = this.length;
        boolean cond1 = false;
        boolean cond2 = false;
        if (firstIntSign == "positive" && otherInt.sign == "positive") {
            cond1 = true;
        }
        if (firstIntSign == "negative" && otherInt.sign == "negative") {
            cond2 = true;
        }
        int[] sum = {}; 
        String finalIntString = "";
        if ((cond1 == true) || (cond2 == true)) {
            if (firstIntSign == "positive" && otherInt.sign == "positive") {
                sumSign = "positive";
            } else if (firstIntSign == "negative" && otherInt.sign == "negative") {
                sumSign = "negative";
            }
            if (firstIntLength == otherInt.length) {
                sum = new int[firstIntLength + 1];
                for (int i = 0; i < firstIntLength; i++) {
                    int element = (firstInt[i] + otherInt.number[i]);
                    if (sum[i] == 0) {
                        if (element < 10) {
                            sum[i] = element;
                        } else if (element >= 10) {
                            sum[i] = (element % 10);
                            sum[i + 1] = (element / 10);
                        }
                    } else if (sum[i] != 0) {
                        if (element < (10 - sum[i])) {
                            sum[i] += element;
                        } else if (element >= (10 - sum[i])) {
                            sum[i] += (element % 10);
                            if (sum[i] >= 10) {
                                sum[i] -= 10;
                            }
                            sum[i + 1] = 1;
                        }
                    }
                }
            } else if (firstIntLength > otherInt.length) {
                sum = new int[firstIntLength + 1];
                for (int i = 0; i < otherInt.length; i++) {
                    int element = (firstInt[i] + otherInt.number[i]);
                    if (sum[i] == 0) {
                        if (element < 10) {
                            sum[i] = element;
                        } else if (element >= 10) {
                            sum[i] = (element % 10);
                            sum[i + 1] = (element / 10);
                        }
                    } else if (sum[i] != 0) {
                        if (element < (10 - sum[i])) {
                            sum[i] += (element);
                        } else if (element >= (10 - sum[i])) {
                            sum[i] += (element % 10);
                            if (sum[i] >= 10) {
                                sum[i] -= 10;
                            }
                            sum[i + 1] = 1;
                        }
                    }
                }
                for (int i = otherInt.length; i < firstIntLength; i++) {
                    if (sum[i] == 0) {
                        sum[i] = firstInt[i];
                    } else if (sum[i] != 0) {
                        int element = (sum[i] + firstInt[i]);
                        if (element < 10) {
                            sum[i] = element;
                        } else if (element >= 10) {
                            sum[i] = (element % 10);
                            sum[i + 1] = (element / 10);
                        }
                    }
                }
            } else if (firstIntLength < otherInt.length) {
                sum = new int[otherInt.length + 1];
                for (int i = 0; i < firstIntLength; i++) {
                    int element = (firstInt[i] + otherInt.number[i]);
                    if (sum[i] == 0) {
                        if (element < 10) {
                            sum[i] = element;
                        } else if (element >= 10) {
                            sum[i] = (element % 10);
                            sum[i + 1] = (element / 10);
                        }
                    } else if (sum[i] != 0) {
                        if (element < (10 - sum[i])) {
                            sum[i] += element;
                        } else if (element >= (10 - sum[i])) {
                            sum[i] += (element % 10);
                            if (sum[i] >= 10) {
                                sum[i] -= 10;
                            }
                            sum[i + 1] = 1;
                        }
                    }
                }
                for (int i = firstIntLength; i < otherInt.length; i++) {
                    if (sum[i] == 0) {
                        sum[i] = otherInt.number[i];
                    } else if (sum[i] != 0) {
                        int element = (sum[i] + otherInt.number[i]);
                        if (element < 10) {
                            sum[i] = element;
                        } else if (element >= 10) {
                            sum[i] = (element % 10);
                            sum[i + 1] = (element / 10);
                        }
                    }
                }
            }
        } else if (firstIntSign == "positive" && otherInt.sign == "negative") {
            if (firstIntLength == otherInt.length) {
                sum = new int[firstIntLength];
                for (int i = firstIntLength - 1; i > -1; i--) {
                    if (firstInt[i] != otherInt.number[i]) {
                        if (firstInt[i] > otherInt.number[i]) {
                            sumSign = "negative";
                        } else if (firstInt[i] < otherInt.number[i]) {
                            sumSign = "positive";
                        }
                    } 
                    break;
                }
                if (sumSign == "negative") {
                    for (int i = 0; i < otherInt.length; i++) {
                        int element = (firstInt[i] - otherInt.number[i]);
                        if (element >= 0) {
                            sum[i] = element;
                        } else if (element < 0) {
                            element += 10;
                            sum[i] = element;
                            otherInt.number[i + 1] -= 1;
                        }
                    }
                } else if (sumSign == "positive") {
                    for (int i = 0; i < firstIntLength; i++) {
                        int element = (otherInt.number[i] - firstInt[i]);
                        if (element >= 0) {
                            sum[i] = element;
                        } else if (element < 0) {
                            element += 10;
                            sum[i] = element;
                            firstInt[i + 1] -= 1;
                        }
                    }
                }
            } else if (firstIntLength > otherInt.length) {
                sumSign = "positive";
                sum = new int[firstIntLength];
                for (int i = 0; i < otherInt.length; i++) {
                    int element = (firstInt[i] - otherInt.number[i]);
                    if (element >= 0) {
                        sum[i] = element;
                    } else if (element < 0) {
                        element += 10;
                        sum[i] = element;
                        firstInt[i + 1] -= 1;
                    }
                }
                for (int i = otherInt.length; i < firstIntLength; i++) {
                    sum[i] = firstInt[i];
                }
            } else if (firstIntLength < otherInt.length) {
                sumSign = "negative";
                sum = new int[otherInt.length];
                for (int i = 0; i < firstIntLength; i++) {
                    int element = (otherInt.number[i] - firstInt[i]);
                    if (element >= 0) {
                        sum[i] = element;
                    } else if (element < 0) {
                        element += 10;
                        sum[i] = element;
                        otherInt.number[i + 1] -= 1;
                    }
                }
                for (int i = firstIntLength; i < otherInt.length; i++) {
                    sum[i] = otherInt.number[i];
                }
            }
        } else if (firstIntSign == "negative" && otherInt.sign == "positive") {
            if (firstIntLength == otherInt.length) {
                sum = new int[firstIntLength];
                for (int i = firstIntLength - 1; i > -1; i--) {
                    if (firstInt[i] != otherInt.number[i]) {
                        if (firstInt[i] > otherInt.number[i]) {
                            sumSign = "negative";
                        } else if (firstInt[i] < otherInt.number[i]) {
                            sumSign = "positive";
                        }
                    } 
                    break;
                }
                if (sumSign == "negative") {
                    for (int i = 0; i < otherInt.length; i++) {
                        int element = (otherInt.number[i] - firstInt[i]);
                        if (element >= 0) {
                            sum[i] = element;
                        } else if (element < 0) {
                            element += 10;
                            sum[i] = element;
                            firstInt[i + 1] -= 1;
                        }
                    }
                } else if (sumSign == "positive") {
                    for (int i = 0; i < firstIntLength; i++) {
                        int element = (firstInt[i] - otherInt.number[i]);
                        if (element >= 0) {
                            sum[i] = element;
                        } else if (element < 0) {
                            element += 10;
                            sum[i] = element;
                            otherInt.number[i + 1] -= 1;
                        }
                    }
                }
            } else if (firstIntLength > otherInt.length) {
                sumSign = "negative";
                sum = new int[firstIntLength];
                for (int i = 0; i < otherInt.length; i++) {
                    int element = (otherInt.number[i] - firstInt[i]);
                    if (element >= 0) {
                        sum[i] = element;
                    } else if (element < 0) {
                        element += 10;
                        sum[i] = element;
                        firstInt[i + 1] -= 1;
                    }
                }
                for (int i = otherInt.length; i < firstIntLength; i++) {
                    sum[i] = firstInt[i];
                }
            } else if (firstIntLength < otherInt.length) {
                sumSign = "positive";
                sum = new int[otherInt.length];
                for (int i = 0; i < firstIntLength; i++) {
                    int element = (firstInt[i] - otherInt.number[i]);
                    if (element >= 0) {
                        sum[i] = element;
                    } else if (element < 0) {
                        element += 10;
                        sum[i] = element;
                        otherInt.number[i + 1] -= 1;
                    }
                }
                for (int i = firstIntLength; i < otherInt.length; i++) {
                    sum[i] = otherInt.number[i];
                }
            }
        }
        int startIndex = 0;
        for (int i = sum.length - 1; i > -1; i--) {
            if (sum[i] != 0) {
                startIndex = i;
                break;
            }
        }
        if (sumSign == "negative") {
            finalIntString = finalIntString.concat("-");
        }
        for (int i = startIndex; i  > -1; i--) {
            finalIntString = finalIntString.concat(String.valueOf(sum[i]));
        }
        var finalSum = new GinormInt(finalIntString);
        return finalSum;
    }

    public GinormInt minus(GinormInt otherInt) {
        var firstInt = this.number;
        var firstIntSign = this.sign;
        var firstIntLength = this.length;
        boolean cond1 = false;
        boolean cond2 = false;
        if (firstIntSign == "positive" && otherInt.sign == "negative") {
            cond1 = true;
        }
        if (firstIntSign == "negative" && otherInt.sign == "positive") {
            cond2 = true;
        }
        int[] diff = {}; 
        String finalIntString = "";
        if ((cond1 == true) || (cond2 == true)) {
            if (firstIntSign == "positive" && otherInt.sign == "negative") {
                diffSign = "positive";
            } else if (firstIntSign == "negative" && otherInt.sign == "positive") {
                diffSign = "negative";
            }
            if (firstIntLength == otherInt.length) {
                diff = new int[firstIntLength + 1];
                for (int i = 0; i < firstIntLength; i++) {
                    int element = (firstInt[i] + otherInt.number[i]);
                    if (diff[i] == 0) {
                        if (element < 10) {
                            diff[i] = element;
                        } else if (element >= 10) {
                            diff[i] = (element % 10);
                            diff[i + 1] = (element / 10);
                        }
                    } else if (diff[i] != 0) {
                        if (element < (10 - diff[i])) {
                            diff[i] += element;
                        } else if (element >= (10 - diff[i])) {
                            diff[i] += (element % 10);
                            if (diff[i] >= 10) {
                                diff[i] -= 10;
                            }
                            diff[i + 1] = 1;
                        }
                    }
                }
            } else if (firstIntLength > otherInt.length) {
                diff = new int[firstIntLength + 1];
                for (int i = 0; i < otherInt.length; i++) {
                    int element = (firstInt[i] + otherInt.number[i]);
                    if (diff[i] == 0) {
                        if (element < 10) {
                            diff[i] = element;
                        } else if (element >= 10) {
                            diff[i] = (element % 10);
                            diff[i + 1] = (element / 10);
                        }
                    } else if (diff[i] != 0) {
                        if (element < (10 - diff[i])) {
                            diff[i] += (element);
                        } else if (element >= (10 - diff[i])) {
                            diff[i] += (element % 10);
                            if (diff[i] >= 10) {
                                diff[i] -= 10;
                            }
                            diff[i + 1] = 1;
                        }
                    }
                }
                for (int i = otherInt.length; i < firstIntLength; i++) {
                    if (diff[i] == 0) {
                        diff[i] = firstInt[i];
                    } else if (diff[i] != 0) {
                        int element = (diff[i] + firstInt[i]);
                        if (element < 10) {
                            diff[i] = element;
                        } else if (element >= 10) {
                            diff[i] = (element % 10);
                            diff[i + 1] = (element / 10);
                        }
                    }
                }
            } else if (firstIntLength < otherInt.length) {
                diff = new int[otherInt.length + 1];
                for (int i = 0; i < firstIntLength; i++) {
                    int element = (firstInt[i] + otherInt.number[i]);
                    if (diff[i] == 0) {
                        if (element < 10) {
                            diff[i] = element;
                        } else if (element >= 10) {
                            diff[i] = (element % 10);
                            diff[i + 1] = (element / 10);
                        }
                    } else if (diff[i] != 0) {
                        if (element < (10 - diff[i])) {
                            diff[i] += element;
                        } else if (element >= (10 - diff[i])) {
                            diff[i] += (element % 10);
                            if (diff[i] >= 10) {
                                diff[i] -= 10;
                            }
                            diff[i + 1] = 1;
                        }
                    }
                }
                for (int i = firstIntLength; i < otherInt.length; i++) {
                    if (diff[i] == 0) {
                        diff[i] = otherInt.number[i];
                    } else if (diff[i] != 0) {
                        int element = (diff[i] + otherInt.number[i]);
                        if (element < 10) {
                            diff[i] = element;
                        } else if (element >= 10) {
                            diff[i] = (element % 10);
                            diff[i + 1] = (element / 10);
                        }
                    }
                }
            }
        } else if (firstIntSign == "negative" && otherInt.sign == "negative") {
            if (firstIntLength == otherInt.length) {
                diff = new int[firstIntLength];
                for (int i = firstIntLength - 1; i > -1; i--) {
                    if (firstInt[i] != otherInt.number[i]) {
                        if (firstInt[i] > otherInt.number[i]) {
                            diffSign = "negative";
                        } else if (firstInt[i] < otherInt.number[i]) {
                            diffSign = "positive";
                        }
                    } 
                    break;
                }
                if (diffSign == "negative") {
                    for (int i = 0; i < otherInt.length; i++) {
                        int element = (firstInt[i] - otherInt.number[i]);
                        if (element >= 0) {
                            diff[i] = element;
                        } else if (element < 0) {
                            element += 10;
                            diff[i] = element;
                            otherInt.number[i + 1] -= 1;
                        }
                    }
                } else if (diffSign == "positive") {
                    for (int i = 0; i < firstIntLength; i++) {
                        int element = (otherInt.number[i] - firstInt[i]);
                        if (element >= 0) {
                            diff[i] = element;
                        } else if (element < 0) {
                            element += 10;
                            diff[i] = element;
                            firstInt[i + 1] -= 1;
                        }
                    }
                }
            } else if (firstIntLength > otherInt.length) {
                diffSign = "negative";
                diff = new int[firstIntLength];
                for (int i = 0; i < otherInt.length; i++) {
                    int element = (otherInt.number[i] - firstInt[i]);
                    if (element >= 0) {
                        diff[i] = element;
                    } else if (element < 0) {
                        element += 10;
                        diff[i] = element;
                        firstInt[i + 1] -= 1;
                    }
                }
                for (int i = otherInt.length; i < firstIntLength; i++) {
                    diff[i] += firstInt[i];
                }
            } else if (firstIntLength < otherInt.length) {
                diffSign = "positive";
                diff = new int[otherInt.length];
                for (int i = 0; i < firstIntLength; i++) {
                    int element = (firstInt[i] - otherInt.number[i]);
                    if (element >= 0) {
                        diff[i] = element;
                    } else if (element < 0) {
                        element += 10;
                        diff[i] = element;
                        otherInt.number[i + 1] -= 1;
                    }
                }
                for (int i = firstIntLength; i < otherInt.length; i++) {
                    diff[i] += otherInt.number[i];
                }
            }
        } else if (firstIntSign == "positive" && otherInt.sign == "positive") {
            if (firstIntLength == otherInt.length) {
                diff = new int[firstIntLength];
                for (int i = firstIntLength - 1; i > -1; i--) {
                    if (firstInt[i] != otherInt.number[i]) {
                        if (firstInt[i] > otherInt.number[i]) {
                            diffSign = "negative";
                        } else if (firstInt[i] < otherInt.number[i]) {
                            diffSign = "positive";
                        }
                    } 
                    break;
                }
                if (diffSign == "negative") {
                    for (int i = 0; i < otherInt.length; i++) {
                        int element = (firstInt[i] - otherInt.number[i]);
                        if (element >= 0) {
                            diff[i] = element;
                        } else if (element < 0) {
                            element += 10;
                            diff[i] = element;
                            otherInt.number[i + 1] -= 1;
                        }
                    }
                } else if (diffSign == "positive") {
                    for (int i = 0; i < firstIntLength; i++) {
                        int element = (otherInt.number[i] - firstInt[i]);
                        if (element >= 0) {
                            diff[i] = element;
                        } else if (element < 0) {
                            element += 10;
                            diff[i] = element;
                            firstInt[i + 1] -= 1;
                        }
                    }
                }
            } else if (firstIntLength > otherInt.length) {
                diffSign = "positive";
                diff = new int[firstIntLength];
                for (int i = 0; i < otherInt.length; i++) {
                    int element = (firstInt[i] - otherInt.number[i]);
                    if (element >= 0) {
                        diff[i] = element;
                    } else if (element < 0) {
                        element += 10;
                        diff[i] = element;
                        firstInt[i + 1] -= 1;
                    }
                }
                for (int i = otherInt.length; i < firstIntLength; i++) {
                    diff[i] += firstInt[i];
                }
            } else if (firstIntLength < otherInt.length) {
                diffSign = "negative";
                diff = new int[otherInt.length];
                for (int i = 0; i < firstIntLength; i++) {
                    int element = (otherInt.number[i] - firstInt[i]);
                    if (element >= 0) {
                        diff[i] = element;
                    } else if (element < 0) {
                        element += 10;
                        diff[i] = element;
                        otherInt.number[i + 1] -= 1;
                    }
                }
                for (int i = firstIntLength; i < otherInt.length; i++) {
                    diff[i] += otherInt.number[i];
                }
            }
        }
        int startIndex = 0;
        for (int i = diff.length - 1; i > -1; i--) {
            if (diff[i] != 0) {
                startIndex = i;
                break;
            }
        }
        if (diffSign == "negative") {
            finalIntString = finalIntString.concat("-");
        }
        for (int i = startIndex; i  > -1; i--) {
            finalIntString = finalIntString.concat(String.valueOf(diff[i]));
        }
        var finalDiff = new GinormInt(finalIntString);
        return finalDiff;
    } 
    
    public GinormInt times(GinormInt otherInt) {
        return otherInt;
    }

    public GinormInt div(GinormInt otherInt) {
        return otherInt;
    }

    public GinormInt mod(GinormInt otherInt) {
        return otherInt;
    }

    @Override
    public int compareTo(GinormInt otherInt) {
        var firstInt = this.number;
        var firstIntSign = this.sign;
        var firstIntLength = this.length;
        if (firstIntSign == "positive" && otherInt.sign == "negative") {
            return 1;
        } else if (firstIntSign == "negative" && otherInt.sign == "positive") {
            return -1;
        } else if (firstIntSign == "positive" && otherInt.sign == "positive") {
            if (firstIntLength > otherInt.length) {
                return 1;
            } else if (firstIntLength < otherInt.length) {
                return -1;
            } else if (firstIntLength == otherInt.length) {
                for (int i = firstIntLength - 1; i > -1; i--) {
                    if (firstInt[i] > otherInt.number[i]) {
                        return 1;
                    } else if (firstInt[i] < otherInt.number[i]) {
                        return -1;
                    }
                }
            }
        } else if (firstIntSign == "negative" && otherInt.sign == "negative") {
            if (firstIntLength > otherInt.length) {
                return -1;
            } else if (firstIntLength < otherInt.length) {
                return 1;
            } else if (firstIntLength == otherInt.length) {
                for (int i = firstIntLength - 1; i > -1; i--) {
                    if (firstInt[i] > otherInt.number[i]) {
                        return -1;
                    } else if (firstInt[i] < otherInt.number[i]) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public boolean equals(GinormInt otherInt) {
        var firstInt = this.number;
        var firstIntSign = this.sign;
        var firstIntLength = this.length;
        if (firstIntSign == otherInt.sign) {
            if (firstIntLength == otherInt.length) {
                for (int i = firstIntLength - 1; i > -1; i--) {
                    if (firstInt[i] != otherInt.number[i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String finalIntString = "";
        var finalInt = this.number;
        var finalIntSign = this.sign;
        var finalIntLength = this.length;
        if (finalIntSign == "negative") {
            finalIntString = finalIntString.concat("-");
        }
        for (int i = finalIntLength - 1; i  > -1; i--) {
            finalIntString = finalIntString.concat(String.valueOf(finalInt[i]));
        }
        return finalIntString;
    }

    public static void main(String[] args) {
        var int1 = new GinormInt(args[0]);
        var int2 = new GinormInt(args[1]);
        System.out.println(int1.plus(int2));
    }
}
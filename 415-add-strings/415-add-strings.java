class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while (len1 >= 0 && len2 >= 0) {
            int a = Character.getNumericValue(num1.charAt(len1));
            int b = Character.getNumericValue(num2.charAt(len2));
            if (a + b + carry > 9) {
                sb.append((a + b + carry) % 10);
                carry = (a + b + carry) / 10;
            } else {
                sb.append(a + b + carry);
                carry = 0;
            }
            len1--;
            len2--;
        }
        
        
        while (len1 >= 0 && len2 < 0) {
            int a = Character.getNumericValue(num1.charAt(len1));
            if (a + carry > 9) {
                sb.append((a + carry) % 10);
                carry = (a + carry) / 10;
            } else {
                sb.append(a + carry);
                carry = 0;
            }
            len1--;
        }
        
        while (len1 < 0 && len2 >= 0) {
            int a = Character.getNumericValue(num2.charAt(len2));
            if (a + carry > 9) {
                sb.append((a + carry) % 10);
                carry = (a + carry) / 10;
            } else {
                sb.append(a + carry);
                carry = 0;
            }
            len2--;
        }
        
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
package com.sarat.rough;

public class ExtractValue {
    public static void main(String[] args) {
        String input = "{out_action=[{ASSIGNIPV=assignipv4}], OUT_SUBNETSIZE=/29, out_error_code=0, out_error_message=null}";

        // Find the start index of ASSIGNIPV
        int startIndex = input.indexOf("ASSIGNIPV=");
        if (startIndex != -1) {
            // Move the index to the start of the value
            startIndex += "ASSIGNIPV=".length();
            // Find the end index of the value
            int endIndex = input.indexOf("]", startIndex);
            if (endIndex == -1) {
                endIndex = input.indexOf(",", startIndex);
            }
            // Extract the value
            String assignIpvValue = input.substring(startIndex, endIndex).trim();
            System.out.println("Value of ASSIGNIPV: " + assignIpvValue);
        } else {
            System.out.println("ASSIGNIPV not found.");
        }
    }
}

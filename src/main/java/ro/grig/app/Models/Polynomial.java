package ro.grig.app.Models;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private final HashMap<Integer, Double> monomials;
    private int rank;

    public Polynomial(String regex) {
        monomials = new HashMap<>();
        regex = regex.replace(" ", "");

        String termRegex = "([-+]?\\b\\d+)?([-+]?x\\^?(\\d+\\b)?)?";
        Pattern pattern = Pattern.compile(termRegex);
        Matcher matcher = pattern.matcher(regex);

        while (matcher.find()) {
            String coefficientString = matcher.group(1);
            String format = matcher.group(2);
            String exponentString = matcher.group(3);

            if (coefficientString == null && format == null && exponentString == null) break;

            int exponent = determineExponent(exponentString, format);
            int coefficient = determineCoefficient(coefficientString, format);

            monomials.put(exponent, (double) coefficient);

            if (exponent > rank) {
                rank = exponent;
            }
        }
    }

    private int determineExponent(String exponentString, String format) {
        if (exponentString != null) return Integer.parseInt(exponentString);

        return (format != null) ? 1 : 0;
    }

    private int determineCoefficient(String coefficientString, String format) {
        if (coefficientString != null) return Integer.parseInt(coefficientString);

        return (format != null) ? (format.contains("-") ? -1 : 1) : 0;
    }

    public Double getMonomialCoefficient(int i) {
        if (monomials.containsKey(i)) return monomials.get(i);
        return 0.0;
    }

    public HashMap<Integer, Double> getMonomials() {
        return monomials;
    }
    public void setMonomial(Integer exponent, Double coefficient) { monomials.put(exponent, coefficient); }
    public void updateRank() { while(getMonomialCoefficient(rank) == 0) rank--; }
    public void setRank(int newRank) { rank = newRank; }
    public int getRank() { return rank; }

    @Override
    public String toString() {
        StringBuilder polynomialString = new StringBuilder();
        boolean firstTerm = true;

        for (Map.Entry<Integer, Double> entry : monomials.entrySet()) {
            int exponent = entry.getKey();
            double coefficient = entry.getValue();

            // Check if the coefficient is zero
            if (coefficient == 0) {
                continue;
            }

            // Append plus sign or minus sign if necessary
            if (!firstTerm && coefficient > 0) {
                polynomialString.append(" + ");
            } else if (coefficient < 0) {
                polynomialString.append(" - ");
                coefficient = -coefficient; // Make coefficient positive for displaying
            }

            // Append the coefficient
            if (Math.abs(coefficient) != 1 || exponent == 0) {
                polynomialString.append(coefficient);
            }

            // Append variable and exponent if necessary
            if (exponent > 0) {
                polynomialString.append("x");
                if (exponent != 1) {
                    polynomialString.append("^").append(exponent);
                }
            }

            firstTerm = false;
        }

        // If polynomial is empty, return "0"
        if (polynomialString.isEmpty()) {
            return "0";
        }

        return polynomialString.toString();
    }
}

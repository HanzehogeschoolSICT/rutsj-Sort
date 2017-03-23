package nl.rutsj.sort.util;

/**
 * A class to hold the data with it's intended highlight.
 * Some inspiration has been taken from this StackOverflow answer:
 * http://stackoverflow.com/a/521235
 */
public class DataPair {
    private int value;
    private String highlight; // String for now

    public DataPair(int value, String highlight) {
        this.value = value;
        this.highlight = highlight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }
}

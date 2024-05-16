public class Polynomial {
    private double cofficient;
    private int exponent;
     Polynomial next;
     Polynomial prev;

    public Polynomial(double cofficient, int exponent) {
        this.cofficient = cofficient;
        this.exponent = exponent;
    }

    public double getCofficient() {
        return cofficient;
    }

    public void setCofficient(double cofficient) {
        this.cofficient = cofficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }
}

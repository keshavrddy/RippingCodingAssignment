package tasks;


public class TaskTwo {

    public static void main(String[] args) throws Exception {
        System.out.println(checkInput("DAY", 80));
        System.out.println(checkInput("DAY", 630));
    }

    public static String checkInput(String type, Integer amount) {
        String label = Type.valueOf(type).getLabel();
        Integer min = Type.valueOf(type).getMin();
        Integer max = Type.valueOf(type).getMax();

        String result = inRange(amount, min, max) ? "Valid" : "Invalid";

        return label + " is " + result;
    }

    private static boolean inRange(Integer amount, Integer low, Integer high) {
        return (low <= amount && amount <= high);
    }

    public enum Type {
        HOUR("Hourly Wage", 10, 100),
        DAY("Daily Wage", 70, 600),
        MONTH("Weekly Wage", 300, 3000),
        WEEK("Monthly Salary", 1200, 12000),
        YEAR("Annual Salary", 14000, 140000);

        private String label;
        private Integer min;
        private Integer max;

        Type(String envLabel, Integer envMin, Integer envMax) {
            this.label = envLabel;
            this.min = envMin;
            this.max = envMax;
        }

        public String getLabel() {
            return label;
        }

        public Integer getMin() {
            return min;
        }

        public Integer getMax() {
            return max;
        }
    }

}

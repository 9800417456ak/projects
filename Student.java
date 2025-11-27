public class Student{
    private final String id;
    private final String name;
    private final double[] scores;
    private final double gpa;

    public Student(String id, String name, double[] scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
        this.gpa = calculateGPA();
    }

    private double calculateGPA() {
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        return total / scores.length;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double[] getScores() {
        return scores;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Scores: ");
        sb.append("Grade");
        for (double score : scores) {
            sb.append(score).append(" ");
        }
        sb.append("\nGPA: ").append(String.format("%.2f", gpa)).append("\n");
        return sb.toString();
    }

    public String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id).append(",").append(name).append(",");
        for (double score : scores) {
            sb.append(score).append(",");
        }
        sb.append(gpa);
        return sb.toString();
    }
}



class inheri7 {
    public static void main(String[] args) {
        Course course = new Course("Data Science Basics", "3 months");
        course.getCourseDetails();

        OnlineCourse onlineCourse = new OnlineCourse("Machine Learning", "4 months", "Udemy", true);
        onlineCourse.getCourseDetails();

        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Deep Learning", "6 months", "Coursera", true, 500, 10);
        paidOnlineCourse.getCourseDetails();
    }
}

class Course {
    String courseName;
    String duration;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    void getCourseDetails() {
        System.out.println("Course Name: " + courseName + ", Duration: " + duration);
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, String duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    void getCourseDetails() {
        System.out.println("Online Course -> Course Name: " + courseName +
                ", Duration: " + duration +
                ", Platform: " + platform +
                ", Recorded: " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    public PaidOnlineCourse(String courseName, String duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    void getCourseDetails() {
        double finalPrice = fee - (fee * discount / 100);
        System.out.println("Paid Online Course -> Course Name: " + courseName +
                ", Duration: " + duration +
                ", Platform: " + platform +
                ", Recorded: " + (isRecorded ? "Yes" : "No") +
                ", Fee: $" + fee +
                ", Discount: " + discount + "%" +
                ", Final Price: $" + finalPrice);
    }
}
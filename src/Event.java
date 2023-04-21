public class Event {
    private boolean success;
    private int points;

    public Event() {
        this.points = 0;
        success = false;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


}

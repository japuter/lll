package Memento;

public class Memento {
    private final boolean isSelected;
    private final int[] options;
    private final String timestamp;

    public Memento(boolean isSelected, int[] options) {
        this.isSelected = isSelected;
        this.options = options.clone();
        this.timestamp = java.time.LocalDateTime.now().toString(); // Store time of state creation
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int[] getOptions() {
        return options.clone();
    }

    public String getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "State at " + timestamp + " | Checkbox: " + isSelected;
    }
}

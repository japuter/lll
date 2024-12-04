package Memento;

import java.util.List;
import java.util.Stack;

public class Controller {
    private final Stack<Memento> undoStack = new Stack<>();
    private final Stack<Memento> redoStack = new Stack<>();
    private final Gui gui;

    private int[] options = new int[3];
    private boolean isSelected;

    public Controller(Gui gui) {
        this.gui = gui;
        saveState(); // Save the initial state
    }

    public int getOption(int index) {
        return options[index - 1];
    }

    public void setOption(int index, String color) {
        saveState(); // Save current state
        options[index - 1] = color.hashCode(); // Store color as hash code
        redoStack.clear(); // Clear redo history on new action
        gui.updateGui();
    }


    public boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean selected) {
        saveState();
        isSelected = selected;
        redoStack.clear(); // Clear redo history on new action
        gui.updateGui();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(saveCurrentState()); // Save current state to redo stack
            Memento memento = undoStack.pop(); // Restore the last saved state
            restoreState(memento);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(saveCurrentState()); // Save current state to undo stack
            Memento memento = redoStack.pop(); // Restore the last undone state
            restoreState(memento);
            gui.updateGui();
        }
    }

    private void saveState() {
        undoStack.push(new Memento(options.clone(), isSelected));
    }

    private Memento saveCurrentState() {
        return new Memento(options.clone(), isSelected);
    }

    private void restoreState(Memento memento) {
        this.options = memento.getOptions();
        this.isSelected = memento.isSelected();
    }

    public List<Memento> getUndoHistory() {
        return List.copyOf(undoStack); // Return an unmodifiable copy of the undo stack
    }

    public void restoreFromHistory(Memento memento) {
        saveState(); // Save the current state before restoring
        restoreState(memento);
        gui.updateGui();
    }

    // Inner Memento class to store state
    public static class Memento {
        private final int[] options;
        private final boolean isSelected;

        public Memento(int[] options, boolean isSelected) {
            this.options = options;
            this.isSelected = isSelected;
        }

        public int[] getOptions() {
            return options;
        }

        public boolean isSelected() {
            return isSelected;
        }

        @Override
        public String toString() {
            return "State: " + java.util.Arrays.toString(options) + ", Checkbox: " + isSelected;
        }
    }
}

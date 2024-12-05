package Visitor;

public class Main {
    public static void main(String[] args) {

        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.doc", 20);
        File file3 = new File("notes.txt", 5);

        // Create directories
        Directory root = new Directory("root");
        Directory subDir1 = new Directory("subDir1");
        Directory subDir2 = new Directory("subDir2");

        // Build the file system structure
        subDir1.addElement(file1);
        subDir1.addElement(file2);
        subDir2.addElement(file3);
        root.addElement(subDir1);
        root.addElement(subDir2);

        // Apply SizeCalculatorVisitor
        SizeCalculatorVisitor sizeCalculator = new SizeCalculatorVisitor();
        root.accept(sizeCalculator);
        System.out.println("Total size of all files: " + sizeCalculator.getTotalSize() + " MB");

        // Apply SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor("file");
        root.accept(searchVisitor);
        System.out.println("Files matching 'file':");
        for (File file : searchVisitor.getMatchingFiles()) {
            System.out.println(" - " + file.getName());
        }
    }
}

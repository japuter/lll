package Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String searchTerm;
    private final List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchTerm)) {
            matchingFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Nothing specific to do for directories
    }
}

package org.example.patterns;

interface Repository {
    void execute();
}

class JPARespository implements  Repository{

    @Override
    public void execute() {

    }
}

class FileRepository implements Repository {

    @Override
    public void execute() {

    }
}

public class ExecutorService {
    Repository fileRepository = new FileRepository();
    Repository jPARepository = new JPARespository();

    public void runTheCall(String type) {
        switch(type) {
            case "FILE": fileRepository.execute();
                break;
            case "DB": jPARepository.execute();
                break;
            default: throw new IllegalCallerException("");
        }
    }
}

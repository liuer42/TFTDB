package springxml.services;

public class validate implements inputService {

    @Override
    public boolean validate(String input){
        if(input!=null)
        {
            return true;
        }
        return false;
    }

    //public String getString();
}


package services;

public class ServiceImpl implements Service {
    @Override
    public String capitalize(String str) {
        return str.toUpperCase();
    }
}
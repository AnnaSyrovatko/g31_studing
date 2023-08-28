package practice.abstract_class;

public class HouseImpl implements House{

    @Override
    public boolean addPet(Pet pet) {
        return false;
    }

    @Override
    public Pet removePet(Pet pet) {
        return null;
    }
}

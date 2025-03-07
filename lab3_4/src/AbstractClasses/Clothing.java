package AbstractClasses;

public abstract class Clothing extends Item{
    private String name;
    {
        name = "элемент одежды";
    }

    public Clothing(String name){
        super(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothing clothing = (Clothing) o;
        return name != null && name.equals(clothing.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Часть одежды под названием " + name + ".";
    }
}

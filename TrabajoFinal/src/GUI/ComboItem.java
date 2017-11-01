package GUI;

public class ComboItem
{
    
    private String id;
    private String string;

    public ComboItem(String id, String string)
    {
        this.id = id;
        this.string = string;
    }

    @Override
    public String toString()
    {
        return this.string;
    }

    public String getId()
    {
        return this.id;
    }

}

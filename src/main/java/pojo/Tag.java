package pojo;

public class Tag {
	
    private Integer id;
    private String name;

    public Tag() {
        setId(22);
        setName("Sufian");
    }

    public Tag(Integer id, String name) {
        setId(id);
        setName(name);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	

}

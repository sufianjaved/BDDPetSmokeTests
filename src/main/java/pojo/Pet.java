package pojo;

public class Pet {
	
    private Integer id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    public Pet() {
        setId(6);
        setCategory(new Category(13, "Cainine"));
        setName("ScoobyDooby");
        setPhotoUrls(new String[]{"http://pathtoimage"});
        setTags(new Tag[]{new Tag(17, "HurryFurry")});
        setStatus("available");
    }

    public Pet(Integer id, Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        setId(id);
        setCategory(category);
        setName(name);
        setPhotoUrls(photoUrls);
        setTags(tags);
        setStatus(status);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
	

}

package ssm.model;

/**
 * Created by hongcheng on 17/4/17.
 */
public class CardDetail {

    private Long id;
    private String imageUrl;
    private String description;
    private String type;
    private String content;
    private String infoId;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CardDetail{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", infoId='" + infoId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

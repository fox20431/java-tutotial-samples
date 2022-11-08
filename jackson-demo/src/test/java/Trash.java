import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @JsonProperty 用于Json转Object时映射
 * @JsonAlias 用于Object转Json时映射
 */
public class Trash {
    @JsonProperty("name")
    private String name;
    @JsonProperty("trust")
    private Integer trust;
    @JsonProperty("lajitype")
    private Integer type;
    @JsonProperty("lajitip")
    private String tip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTrust() {
        return trust;
    }

    public void setTrust(Integer trust) {
        this.trust = trust;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return "MyTrash{" +
                "name='" + name + '\'' +
                ", trust=" + trust +
                ", type=" + type +
                ", tip='" + tip + '\'' +
                '}';
    }
}

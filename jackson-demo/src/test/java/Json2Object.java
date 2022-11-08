import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Json2Object {

    public static void main(String[] args) {

        String jsonString = "{\"code\":200,\"msg\":\"success\",\"newslist\":[{\"name\":\"橙子\",\"trust\":0.872066,\"lajitype\":2,\"lajitip\":\"橙子是厨余湿垃圾，常见包括剩菜剩饭、果皮、蛋壳、骨头等。投放时应注意去除包装、分别投置。\"},{\"name\":\"脐橙\",\"trust\":0.684726,\"lajitype\":4,\"lajitip\":\"脐橙的垃圾分类系统暂时无法判别，请重新尝试拍摄物体的主要特征。\"},{\"name\":\"桔子\",\"trust\":0.446504,\"lajitype\":2,\"lajitip\":\"桔子是厨余湿垃圾，常见包括剩菜剩饭、果皮、蛋壳、骨头等。投放时应注意去除包装、分别投置。\"},{\"name\":\"丑橘\",\"trust\":0.252022,\"lajitype\":4,\"lajitip\":\"丑橘的垃圾分类系统暂时无法判别，请重新尝试拍摄物体的主要特征。\"},{\"name\":\"柚子\",\"trust\":0.072328,\"lajitype\":2,\"lajitip\":\"柚子是厨余湿垃圾，常见包括剩菜剩饭、果皮、蛋壳、骨头等。投放时应注意去除包装、分别投置。\"}]}";

        // 将Json转换为对象
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            String newsList = jsonNode.get("newslist").toString();
            List<Trash> trashes = objectMapper.readValue(newsList, new TypeReference<List<Trash>>() {
            });
            System.out.println(trashes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
